((clojure-mode
  . ((clojure-align-forms-automatically . t)
     (clojure-indent-style . :always-align)
     (fill-column . 70)))

 (clojurescript-mode
  . ((clojure-align-forms-automatically . t)
     (fill-column . 70)
     (cider-default-cljs-repl . figwheel-main)
     (cider-preferred-build-tool . clojure-cli)
     (cider-figwheel-main-default-options . ":dev")))

 (cider-repl-mode
  . ((cider-preferred-build-tool . clojure-cli)
     (cider-test-show-report-on-success . t)))

 (clojure-test-mode
  . ((cider-test-show-report-on-success . t)
     (cider-auto-test-mode . t))))
