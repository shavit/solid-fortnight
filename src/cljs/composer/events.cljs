(ns composer.events
  (:require [re-frame.core :refer [reg-event-db reg-event-fx inject-cofx
              path trim-v after debug dispatch]]
            [secretary.core :as secretary :include-macros true]
            [composer.db :refer [default-db composer->local-store]]
            [cljs.spec.alpha :as spec]
            [ajax.core :refer [GET POST json-response-format]])
  (:require-macros
            [cljs.core.async.macros :refer [go go-loop]]))

(reg-event-fx
  :keyboard/key-down
  (fn [db [_ v]]
    (println "[Events] Keyboard down" v)
    nil))

; TODO: Move this to a different module
(def velocity-default 60)
; Validate that the value is between 0-100
(defn velocity-valid?
  [v]
  (and
    (>= v 0)
    (<= v 100)))

; Set the new velocity value
(reg-event-db
  :change-velocity
  (fn [db [_ v]]
    (let [db-value-opt (get-in db [:panel-velocity :value])
          db-value (if (nil? db-value-opt)
                              velocity-default
                              db-value-opt)
          velocity-value (+ db-value v)
          new-value (if (velocity-valid? velocity-value)
                        velocity-value
                        db-value)]
          (assoc-in db [:panel-velocity :value] new-value)
  )))

(reg-event-fx
  :keyboard/key-up
  (fn [db [_ v]]
    (println "[Events] Keyboard up" v)

    (case v
      "KeyZ" (dispatch [:change-velocity -1])
      "KeyX" (dispatch [:change-velocity 1])
      nil)

    nil))

; TODO: Set interval
(reg-event-fx
  :musical-key-pressed
  (fn [db [_ v]]
    (println "[Events] Musical key pressed" v)))
