(ns composer.views.dashboard.playback
  (:require [reagent.core :as reagent]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]))


; :on-key-press

(defn render
  []
  [:div {:class "buttons-play"}
    [:button "Play"]
    [:button "Pause"]
  ])
