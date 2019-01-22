(ns ^:figwheel-no-load composer.dev
  (:require
    [composer.core :as core]
    [devtools.core :as devtools]))

(devtools/install!)

(enable-console-print!)

(core/init!)
