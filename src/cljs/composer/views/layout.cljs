(ns composer.layout
  (:require [reagent.core :as reagent]
    [re-frame.core :refer [subscribe dispatch]]))

(defn authenticated
  []
  @(subscribe [:username]))

(defn page-layout
  [dom]
  [:div {:class "page"}

  [:header
    [:a {:href "/"} "Home"]
    [:a {:href "/about"} "About"]]

  ; TODO: Move this into the router
  ; [:header
  ;  [:p [:a {:href (path-for :index)} "Home"] " | "
  ;   [:a {:href (path-for :about)} "About composer"]]]

  dom
  ])
