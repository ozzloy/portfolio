(ns to.tuo.portfolio
  (:require
   ["react-dom/client" :refer [createRoot]]
   [reagent.core :as r]))

(defn hello []
  [:div
   [:h1 "hello from reagent"]
   [:p "this is a paragraph"]])

(defonce root (createRoot (js/document.getElementById "app")))

(defn ^:export init []
  (js/console.log "hello, figwheel!!")
  (.render root (r/as-element [hello])))

(init)
