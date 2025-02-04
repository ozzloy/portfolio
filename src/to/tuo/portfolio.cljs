(ns to.tuo.portfolio
  (:require
   ["react-dom/client" :refer [createRoot]]
   [reagent.core :as r]))

(defn professional-photo []
  [:img {:src   "me.jpg"
         :style {:border-radius "10px"
                 :width         "300px"
                 :height        "auto"}}])

(defn about-me []
  [:section
   [:h2 "about me"]
   [:p "
Computers carry math into physical reality. That is really neat.
Math offers a clarity of thinking that I find soothing and enjoyable.
When implementing an algorithm, the computer makes it clear if some
step is not specified completely enough, or is altogether incorrect."]
   [:p "
When doing math, I discover things that are true about the world
around me that have been true and will continue to be true forever.
Consequences of certain ideas followed out to their conclusions always
comport with prior facts about the world. Seemingly unrelated ideas
can have underlying connections that I find satisfying to discover."]
   [:p "
Collaboration with other people motivates me as well. We can make a
lot more progress relying on each other than working alone. I have
been working with computers for decades. When I hit a key on my
keyboard, corresponding text shows up on the screen. I know a lot of
the steps involved in making that happen, more than even most
programmers. There are also datastuctures at play that I do not know.
These abstractions make it much easier for me to do the same thing
with a wide variety of keyboards. I contribute to this pretty
directly. With circuitpython, and kmkfw, I recently identified an
assumption on the availability of USB HID. The adafruit devs made an
update to circuit python, and I made an update to kmkfw to allow a
chip with bluetooth to act as a keyboard. As a result, I can now use
my seeed xiao esp32 c6 as a controller for my keyboard, a capability
that was absent when I bought the board."]])

(defn future-projects []
  [:section
   [:h2 "future projects"]
   [:section
    [:h3 "fit"]
    [:p "an application to help with workout timing and tracking"]]])

(defn skills []
  [:section
   [:h2 "skills"]
   [:p "look at all the skills i got"]])

(defn social []
  [:section
   [:h2 "socials"]
   [:ul
    [:li [:a {:href "https://linkedin.com/in/ozzloy"} "linkedin"]]
    [:li [:a {:href "https://github.com/ozzloy"} "github"]]]])

(defn hello []
  [:div
   [:h1 "daniel watson"]
   [professional-photo]
   [about-me]
   [future-projects]
   [skills]
   [social]])

(defonce root (createRoot (js/document.getElementById "app")))

(defn ^:export init []
  (js/console.log "hello, figwheel!!")
  (.render root (r/as-element [hello])))

(init)
