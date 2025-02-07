(ns to.tuo.portfolio
  (:require
   ["react-dom/client" :refer [createRoot]]
   [reagent.core :as r]
   [clojure.string :as str]))

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

(defn projects []
  [:section#projects
   [:h2 "projects"]
   [:section
    [:h3 "i'll brb"]
    [:ul
     [:li [:a {:href "https://ill-brb.each.do/"} "live"]]
     [:li [:a {:href "https://github.com/ozzloy/solo-ill-brb"} "code"]]]
    [:p "In this project, me and my pair programming partner created a
     rental site, much like AirBnB.  For the backend, we used
     sequelize which handles JSON requests and serves JSON.  The
     frontend uses React Vite.  For client side state management,
     Redux greatly simplified and centralized code, especially code
     for making requests to the backend and dealing with responses."]
    [:img {:src "images/projects/ill-brb.png"
           :style {:border "2px solid AccentColor"
                   :border-radius "10px"
                   :width "500px"}}]]
   [:section
    [:h3 "where da gas at?"]
    [:ul
     [:li [:a {:href "https://where-da-gas-at.each.do/"} "live"]]
     [:li [:a {:href "https://github.com/ozzloy/where-da-gas-at"}
           "code"]]]
    [:p "&quot;where da gas at?&quot; This app helps users track gas
     stations and prices.  I took leadership of a group of 4 to
     complete this project.  Team members looked to me for guidance
     about what to work on.  I assessed their skills and constraints
     to give tasks that made the most of them.  I also integrated all
     the work frequently by rebasing their work into a single line of
     history."]
    [:img {:src "images/projects/where-da-gas-at.png"
           :style {:border "2px solid AccentColor"
                   :border-radius "10px"
                   :width "500px"}}]]])

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

(def programming-language-badge-width "100px")
(defn devicon [language wordmark?]
  (let [protocol "https"
        host     "cdn.jsdelivr.net"
        path     (str
                  "/gh/devicons/devicon@latest/icons/" language "/")
        filename (str language
                      "-original"
                      (if wordmark? "-wordmark" "")
                      ".svg")]
    (str protocol "://" host path filename)))

(defn local-icon [language extension]
  (str "images/icons/" language "." extension))

(defn- icon-item [language src background]
  [:li
   [:div
    [:span (str/replace language #"-" " ")]
    [:img
     {:src   src
      :class background
      :style {:width  programming-language-badge-width
              :height "auto"}}]]])

(defn item-local-icon
  ([language] (item-local-icon language "png"))
  ([language extension]
   (item-local-icon language extension "none"))
  ([language extension background]
   [icon-item
    language (local-icon language extension) background]))

(defn item-devicon
  ([language] (item-devicon language "none"))
  ([language background]
   (item-devicon language background false))
  ([language background wordmark?]
   [icon-item language (devicon language wordmark?) background]))

(defn skills []
  [:section#skills
   [:h2 "skills"]
   [:section
    [:h3 "programming languages"]
    [:p "these are all languages that i've helped other people with, or
    i have written a lot of for myself.  after working with this many
    languages, picking up a new one is relatively easy."]
    [:ul
     [item-local-icon "arm" "svg" "light"]
     [item-devicon "arduino"]
     [item-devicon "awk" "light" "wordmark"]
     [item-devicon "bash" "light"]
     [item-devicon "c"]
     [item-devicon "cplusplus"]
     [item-devicon "clojure"]
     [item-devicon "clojurescript"]
     [item-local-icon "common-lisp"]
     [item-devicon "elm"]
     [item-devicon "emacs" "light"]
     [item-local-icon "guile" "svg" "light"]
     [item-devicon "haskell"]
     [item-devicon "java"]
     [item-devicon "javascript"]
     [item-local-icon "ladder-diagram"]
     [item-devicon "matlab"]
     [item-local-icon "MIPS" "svg" "light"]
     [item-devicon "ocaml"]
     [item-local-icon "octave"]
     [item-local-icon "openscad"]
     [item-devicon "prolog"]
     [item-devicon "python"]
     [item-local-icon "racket" "svg"]
     [item-devicon "ruby"]
     [item-local-icon "scratch" "svg"]
     [item-local-icon "Snap!" "svg"]
     [item-local-icon "x86" "svg"]]]

   [:section
    [:h3 "frameworks and libraries and tools"]
    [:ul
     [item-devicon "apache"]
     [item-devicon "bitbucket"]
     [item-devicon "css3"]
     [item-devicon "debian"]
     [item-devicon "express" "light"]
     [item-devicon "flask" "light"]
     [item-devicon "gcc"]
     [item-devicon "git"]
     [item-devicon "gitlab"]
     [item-devicon "html5"]
     [item-devicon "latex" "light"]
     [item-devicon "linux" "light"]
     [item-devicon "mocha"]
     [item-devicon "mysql"]
     [item-devicon "nodejs"]
     [item-devicon "npm" "none" true]
     [item-devicon "postgresql"]
     [item-devicon "pypi"]
     [item-devicon "pytest"]
     [item-devicon "raspberrypi"]
     [item-devicon "react"]
     [item-local-icon "reagent" "svg"]
     [item-devicon "sqlite" "light"]
     [item-devicon "sequelize"]
     [item-devicon "sqlalchemy" "light"]
     [item-devicon "ssh" "light"]
     [item-devicon "ubuntu"]
     [item-devicon "vitejs"]]]])

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
     was a little kid, they would look up.  climbing has puzzle
     solving and physical strength wrapped together.  the same route
     looks different depending on who climbs it."]]
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
  [:<>
   [:header
    [professional-photo]
    [:div
     [:h1 "daniel watson"]
     [contact]
     [social]]]
   [about-me]
   [projects]
   [skills]
   [hobbies]
   [future-projects]])

(defonce root (createRoot (js/document.getElementById "app")))

(defn ^:export init []
  (.render root (r/as-element [content])))

(init)
