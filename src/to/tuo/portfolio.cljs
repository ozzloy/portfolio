(ns to.tuo.portfolio
  (:require
   ["react-dom/client" :refer [createRoot]]
   [reagent.core :as r]))

(defn professional-photo []
  [:img#professional-photo
   {:src   "me.jpg"
    :style {:border-radius "10px"
            :width         "300px"
            :height        "auto"}}])

(defn about-me []
  [:section#about-me
   [:h2 "about me"]
   [:p "Computers carry math into physical reality.  That is really
    neat.  Math offers a clarity of thinking that I find soothing and
    enjoyable.  When implementing an algorithm, the computer makes it
    clear if some step is not specified completely enough, or is
    altogether incorrect."]
   [:p "When doing math, I discover things that are true about the
    world around me that have been true and will continue to be true
    forever.  Consequences of certain ideas followed out to their
    conclusions always comport with prior facts about the world.
    Seemingly unrelated ideas can have underlying connections that I
    find satisfying to discover."]
   [:p "Collaboration with other people motivates me as well.  We can
    make a lot more progress relying on each other than working alone.
    I have been working with computers for decades.  When I hit a key
    on my keyboard, corresponding text shows up on the screen.  I know
    a lot of the steps involved in making that happen, more than even
    most programmers.  There are also datastuctures at play that I do
    not know.  These abstractions make it much easier for me to do the
    same thing with a wide variety of keyboards.  I contribute to this
    pretty directly.  With circuitpython, and kmkfw, I recently
    identified an assumption on the availability of USB HID.  The
    adafruit devs made an update to circuit python, and I made an
    update to kmkfw to allow a chip with bluetooth to act as a
    keyboard.  As a result, I can now use my seeed xiao esp32 c6 as a
    controller for my keyboard, a capability that was absent when I
    bought the board."]])

(defn future-projects []
  [:section#future-projects
   [:h2 "future projects"]
   [:section
    [:h3 "fit"]
    [:h4 "workout timing and tracking."]
    [:p "the way i work out right now is to watch videos on youtube
     that have someone do the exercise and follow along with their
     exact timing.  it would be nice to have an app that can display a
     couple images of the exercise.  it should alsokeep time and beep
     to let me know when to switch sides, when to do a mini-rest, when
     to start and stop an exercise completely."]]
   [:section
    [:h3 "keyboard"]
    [:h4 "wireless split column splay bluetooth 32 key modified
    miryoku with home row mods"]
    [:p "i want to make a keyboard using my xiao ble board and kmk
     firmware.  my current keyboard is a wireless split column stagger
     keyboard.  it would be neat to make a wireless one with columns
     splayed out to match my natural finger travel more closely.  this
     would also be a good project for learning about battery power and
     usb c plugs and cables.  i have already hand soldered a full
     keyboard and written firmware for a few devices, so i think that
     part will be easy enough."]]])


(defn skills []
  [:section#skills
   [:h2 "skills"]
   [:p "look at all the skills i got"]])

(defn social []
  [:section#social
   [:h2 "socials"]
   [:ul
    [:li [:a {:href "https://linkedin.com/in/ozzloy"} "linkedin"]]
    [:li [:a {:href "https://github.com/ozzloy"} "github"]]]])

(defn hobbies []
  [:section#hobbies
   [:h2 "hobbies"]
   [:section
    [:h3 "climbing"]
    [:p "my mom and dad tell me that if they could not find me when i
was a little kid, they would look up.  climbing has puzzle solving and
physical strength wrapped together.  the same route looks different
depending on who climbs it."]]
   [:section
    [:h3 "juggling"]
    [:p "i can juggle 5-ball.  i made a "
     [:a {:href (str "https://docs.google.com/document/d/"
                     "197iyXQcppY7B1_M6Gn-lUU21qyMRK8LqvhypGGvaiHk")}
      "tutorial on making chain mail juggling props"]
     "."]]])

(defn contact []
  [:section#contact
   [:h2 "contact"]
   [:p
    [:a {:href "mailto:ozzloy@each.do"} "email"]]])

(defn content []
  [:div
   [:h1 "daniel watson"]
   [professional-photo]
   [about-me]
   [future-projects]
   [skills]
   [social]
   [hobbies]
   [contact]])

(defonce root (createRoot (js/document.getElementById "app")))

(defn ^:export init []
  (.render root (r/as-element [content])))

(init)
