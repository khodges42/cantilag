(ns cantilag.spec
  (:require [clojure.edn :as edn]
            [clojure.java.io :as io]))

(defn load-spec [path]
  (-> path
      slurp
      edn/read-string))

(defn require-key! [m k context]
  (when-not (contains? m k)
    (throw (ex-info (str "Missing required key " k " in " context)
                    {:context context
                     :missing-key k
                     :value m}))))

(defn validate-field! [field idx]
  (require-key! field :name (str "field #" idx))
  (require-key! field :type (str "field #" idx))

  (when-not (string? (:name field))
    (throw (ex-info "Field :name must be a string"
                    {:field field
                     :index idx})))

  (when-not (keyword? (:type field))
    (throw (ex-info "Field :type must be a keyword like :f32 or :bytes32"
                    {:field field
                     :index idx}))))

(defn validate-system! [system]
  (require-key! system :name "system")
  (require-key! system :reads "system")
  (require-key! system :writes "system")
  (require-key! system :ops "system")

  (when-not (vector? (:ops system))
    (throw (ex-info "System :ops must be a vector of C operation strings"
                    {:system system}))))

(defn validate-spec! [spec]
  (require-key! spec :name "spec")
  (require-key! spec :entity "spec")
  (require-key! spec :fields "spec")
  (require-key! spec :system "spec")

  (when-not (seq (:fields spec))
    (throw (ex-info "Spec must contain at least one field"
                    {:spec spec})))

  (doseq [[idx field] (map-indexed vector (:fields spec))]
    (validate-field! field idx))

  (validate-system! (:system spec))

  spec)