(ns composer.subs
  (:require
    [re-frame.core :refer [reg-sub subscribe]]))

(defn velocity-value
  [db _]
  (get-in db [:panel-velocity :value]))
(reg-sub :panels/velocity-value velocity-value)
