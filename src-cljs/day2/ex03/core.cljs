(ns day2.ex03.core
  (:require-macros
   [reagent.ratom :refer [reaction]]
   [cljs-log.core :refer [debug info]])
  (:require
   [reagent.core :as reagent]))

(defonce app (atom {}))

(defn app-component
  []
  [:div [:h1 "Hallo Mainzer!"]])

(defn main
  []
  (reagent/render-component
   [app-component]
   (.getElementById js/document "app")))

(main)
