(ns composer.db
  (:require [cljs.reader]
            [cljs.spec.alpha :as spec]
            [re-frame.core :as rf]))

;; ------------------------------
;; Specification

(spec/def ::id int?)

;; ------------------------------
;; Default values

(def default-db
  {:settings {}
    :panel-velocity {:value nil}
    })

;; ------------------------------
;; localStorage

(def ls-key "composer-reframe")
(defn composer->local-store
  "Puts db into local storage"
  [params]
  (.setItem js/localStorage ls-key (str params)))

;; ------------------------------
;; Handler

(rf/reg-cofx
  :local-store-composer
  (fn [cofx _]
    (assoc cofx :local-store-composer
      (into (sorted-map)
        (some->> (.getItem js/localStorage ls-key)
        (cljs.reader/read-string)
        )))))
