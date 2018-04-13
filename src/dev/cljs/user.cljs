(ns cljs.user
  (:require
    [fulcro.client :as fc]
    [cljs.pprint :refer [pprint]]
    [fulcro.client.logging :as log]
    [studygate.ui :as ui]
    [clojure.spec.alpha :as s]
    [clojure.spec.test.alpha :as st]
    fulcro.history
    [studygate.client-setup :refer [app]]))

(enable-console-print!)

(log/set-level :all)

;(st/instrument)

(defn mount []
  (reset! app (fc/mount @app ui/Root "app")))

(mount)

(defn app-state [] @(:reconciler @app))

(defn log-app-state [& keywords]
  (pprint (let [app-state (app-state)]
            (if (= 0 (count keywords))
              app-state
              (select-keys app-state keywords)))))
