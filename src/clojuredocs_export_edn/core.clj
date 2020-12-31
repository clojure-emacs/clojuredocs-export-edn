(ns clojuredocs-export-edn.core
  (:require
   [clojure.data.json :as json]
   [clojure.java.io :as io]
   [clojure.pprint :as p]))

(def json-url
  (or (System/getenv "CLOJUREDOCS_JSON_URL")
      "https://clojuredocs.org/clojuredocs-export.json"))

(def raw-data
  (-> json-url
      slurp
      (json/read-str :key-fn keyword)))

(defn- compact-see-also [see-also]
  (let [v (:to-var see-also)]
    (keyword (:ns v) (:name v))))

(defn- compact-see-alsos [v]
  (update v :see-alsos #(some->> % (mapv compact-see-also))))

(defn- compact-examples [v]
  (update v :examples #(some->> % (mapv :body))))

(defn- compact-notes [v]
  (update v :notes #(some->> % (mapv :body))))

(def ^:private compact-values
  (comp compact-see-alsos
        compact-examples
        compact-notes))

(def compact-data
  (->> (:vars raw-data)
       (map compact-values)
       (reduce (fn [res x] (assoc res (keyword (:ns x) (:name x)) x)) {})))

(defn -main []
  (spit "exports/export.edn" (pr-str raw-data))
  (p/pprint compact-data (io/writer "exports/export.compact.edn"))
  (spit "exports/export.compact.min.edn" (pr-str compact-data)))
