(ns ga.rugal.core.course
  (:require [korma.core :as korma])
  (:require [ga.rugal.core.entity :refer :all]))


(defn get-by-id
  ""
  [cid]
  (korma/select course
    (korma/fields :cid :name)
    (korma/where {:cid cid})))


(defn get-by-page
  ""
  [no size]
  (korma/select course
    (korma/fields :cid :name)
    (korma/offset (* (- no 1) size))
    (korma/limit size)))


(defn save
  ""
  [bean]
  (if bean
    (korma/insert course
      (korma/values {:name (get bean :name)}))))


(defn update
  ""
  [bean]
  (if bean
    (korma/update course
      (korma/set-fields {:name (get bean :name)})
      (korma/where {:cid (get bean :cid)}))))


(defn delete
  ""
  [cid]
  (if (get-by-id cid)
    (korma/delete course
      (korma/where {:cid cid}))))


(defn count-total
  ""
  []
  ;(korma/exec-raw  ["SELECT count(mid) total FROM menu"] :results)
  (->
    (korma/select course
      (korma/aggregate (count :cid) :total))
    first
    :total))
