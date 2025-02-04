(ns to.tuo.portfolio
  (:require [reagent.dom :as rdom]))

(defn hello []
  [:div
   [:h1 "hello from reagent"]
   [:p "this is a paragraph"]])

(defn ^:export init []
  (js/console.log "hello, figwheel!")
  (rdom/render [hello] (js/document.getElementById "app")))

(init)
