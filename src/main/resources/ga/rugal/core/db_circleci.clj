(ns ga.rugal.core.db
  (:require [korma.db :refer [defdb]]))
;This is actually a database configuration file


(def dbinfo
  {:classname   "org.postgresql.Driver"
   :subprotocol "postgresql"
   :subname     (str "//localhost:5432/circle_test")
   ; Any additional keys are passed to the driver
   ; as driver-specific properties.
   :user        "ubuntu"
   :password    "123456"})


(defdb connection dbinfo)
