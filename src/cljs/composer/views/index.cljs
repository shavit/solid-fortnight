(ns composer.views.index
  (:require [reagent.core :as reagent]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]
            [composer.layout :refer [page-layout]]
            [composer.views.dashboard.playback :as playback]))

(defn on-click-key
  [event]
  (.preventDefault event)
  (dispatch [:musical-key-pressed (-> event .-target .-value)]))

(defn main-content
  []
  [:div
    [:hr]
    [playback/render]
    [:hr]
    [:div {:class "buttons-keys"}
      [:button {:on-click on-click-key, :value :c} "C"]
      [:button {:on-click on-click-key, :value :d} "D"]
      [:button {:on-click on-click-key, :value :e} "E"]
      [:button {:on-click on-click-key, :value :f} "F"]
      [:button {:on-click on-click-key, :value :g} "G"]
      [:button {:on-click on-click-key, :value :a} "A"]
      [:button {:on-click on-click-key, :value :b} "B"]
    ]
  ])

(defn render
  []
  (page-layout [main-content]))
