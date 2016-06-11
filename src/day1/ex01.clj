(ns day1.ex01
  (:require
   [hiccup.core :as hiccup]
   [thi.ng.geom.svg.core :as svg]))

(println 42 3.1415926 1/3)

;; REPL = Read, Evaluate, Print, Loop

;; REPL kommandos:
;; (doc ...)
;; (source ...)
;; (find-doc ...)
;; (apropos ...)

;; 42 => integer
;; 23.4 => floating point number
;; 1/4 => ratio
;; "text" => string
;; \a => character
;; #"regexp" => regular expressing

;; ReSeq => CamelCase (Java)
;; re_seq => snake_case (C)
;; re-seq => kebab-case (Clojure, Lisp)

(defn grid
  "Generiert ein Raster von Linien. Fragt nach Anzahl von Spalten & Zeilen."
  [cols rows]
  (let [verts   (+ cols 1)
        horsz   (+ rows 1)
        v-lines (map (fn [x] [[x 0] [x rows]]) (range verts))
        h-lines (map (fn [y] [[0 y] [cols y]])
                     (range horsz))]
    (svg/svg
     {:width 1000 :height 1000 :viewBox (str "0 0 " cols " " rows)}
     [:g {:stroke "red" :stroke-width "0.01"}
       (map (fn [p] (apply svg/line p)) (concat v-lines h-lines))])))

;; (grid 5 10)
;; (spit "grid2x2.svg" (svg/serialize (grid 2 2)))
