(ns clojuredocs-export-edn.core-test
  (:require [clojure.edn :as edn]
            [clojure.java.io :as io]
            [clojure.pprint :as p]
            [clojure.test :as t]
            [clojuredocs-export-edn.core :as sut]))

(t/deftest generate-test
  (do (spit "target/out/export.edn"
            (pr-str sut/raw-data))
      (p/pprint sut/compact-data
                (io/writer "target/out/export.compact.edn"))
      (spit "target/out/export.compact.min.edn"
            (pr-str sut/compact-data)))

  (t/is (= (-> "target/out/export.compact.edn" slurp edn/read-string)
           (-> "target/out/export.compact.min.edn" slurp edn/read-string))))
