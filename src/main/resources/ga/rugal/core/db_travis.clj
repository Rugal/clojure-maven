(ns ga.rugal.core.db
  (:require [korma.db :refer [defdb]]))
;This is actually a database configuration file


(def dbinfo
  {:classname   "org.postgresql.Driver"
   :subprotocol "postgresql"
   :subname     (str "//localhost:5432/postgres")
   ; Any additional keys are passed to the driver
   ; as driver-specific properties.
   :user        "postgres"
   :password    "123456"})


(defdb connection dbinfo)
