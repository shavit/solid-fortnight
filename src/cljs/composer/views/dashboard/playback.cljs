(ns composer.views.dashboard.playback
  (:require [reagent.core :as reagent]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]))

(defn on-key-down
  [event]
  (dispatch [:keyboard/key-down (-> event .-code)]))

(defn on-key-up
  [event]
  (dispatch [:keyboard/key-up (-> event .-code)]))

(defn register-global-key-events
  []
  (set! js/onkeydown on-key-down)
  (set! js/onkeyup on-key-up)
  )

(defn playback-buttons
  []
  [:div {:class "buttons-play"}
    [:button "Play"]
    [:button "Pause"]
  ])

(defn velocity-buttons
  []
  [:div {:class "buttons-velocity"}
    [:button "Velocity -"]
    [:button "Velocity +"]
    [:span @(subscribe [:panels/velocity-value])]
  ])

(defn render
  []
  (register-global-key-events)
  [:div {:class "playback"
        :on-key-down on-key-down
        :on-key-up on-key-up
      }
    [:input {:on-key-down on-key-down}]
    [playback-buttons]
    [velocity-buttons]
  ])
