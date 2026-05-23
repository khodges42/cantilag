(ns cantilag.core
  (:require [cantilag.spec :as spec]
            [cantilag.c-emit :as c-emit]
            [clojure.java.io :as io]))

(defn generated-path [spec]
  (str "generated/" (:name spec) "_soa.c"))

(defn write-generated! [spec c-code]
  (let [path (generated-path spec)]
    (io/make-parents path)
    (spit path c-code)
    path))

(defn -main [& args]
  (let [path (first args)
        s (-> path
              spec/load-spec
              spec/validate-spec!)
        c-code (c-emit/emit-c s)
        out-path (write-generated! s c-code)]
    (println "cantilag online")
    (println "loaded spec:" (:name s))
    (println "generated:" out-path)))