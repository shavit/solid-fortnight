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
  :musical-key-pressed
  (fn [db [_ v]]
    (println "[Events] Key pressed" v)))
