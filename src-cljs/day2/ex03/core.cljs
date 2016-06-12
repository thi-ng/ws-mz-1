(ns day2.ex03.core
  (:require-macros
   [reagent.ratom :refer [reaction]]
   [cljs-log.core :refer [debug info]])
  (:require
   [reagent.core :as reagent]
   [clojure.string :as str]))

(defonce app
  (atom {:title "hey"
         :body ""}))

(defn set-key
  [key]
  (fn [e]
    (swap! app assoc key (-> e .-target .-value))))

(defn app-component
  []
  (let [title (reaction (:title @app))
        body  (reaction (str/upper-case (:title @app)))]
    (fn []
      [:div
       [:h2 "Hallo"]
       [:label "Titel"
        [:input
         {:type "text"
          :default-value @title
          :on-change (set-key :title)}]]
       [:label "Inhalt"
        [:textarea
         {:cols 60
          :rows 20
          :value @body}]]])))

(defn main
  []
  (reagent/render-component
   [app-component]
   (.getElementById js/document "app")))

(main)
