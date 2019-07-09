(ns clojuredocs-export-edn.core
  (:require [clojure.data.json :as json]))

(def json-url
  (or (System/getenv "CLOJUREDOCS_JSON_URL")
      "https://clojuredocs.org/clojuredocs-export.json"))

(defn -main []
  (-> json-url
      slurp
      (json/read-str :key-fn keyword)
      pr-str
      println))
