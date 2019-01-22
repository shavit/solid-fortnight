(ns composer.views.about
  (:require [reagent.core :as reagent]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]
            [composer.layout :refer [page-layout]]))

(defn render
  []
  (page-layout [:div "About page"]))
