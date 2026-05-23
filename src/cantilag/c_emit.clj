(ns cantilag.c-emit
  (:require [clojure.string :as str]))
(defn c-type [field]
  (case (:type field)
    :f32 "float"
    :bytes32 "char[32]"
    (throw (ex-info "Unsupported field type"
                    {:field field}))))

(defn emit-header []
  "#include <stdio.h>\n#include <stdlib.h>\n#include <time.h>\n\n")

(defn emit-c [spec]
  (str
   (emit-header)
   "int main(void) {\n"
   "  printf(\"cantilag generated benchmark: "
   (:name spec)
   "\\n\");\n"
   "  return 0;\n"
   "}\n"))