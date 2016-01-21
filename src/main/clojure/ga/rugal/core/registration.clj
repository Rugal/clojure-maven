(ns ga.rugal.core.registration
  (:require [korma.core :as korma])
  (:require [ga.rugal.core.entity :refer :all])
  (:require [ga.rugal.core.student :as student])
  (:require [ga.rugal.core.course :as course])
  )


(defn get-by-id
  ""
  [rid]
  (korma/select registration
    (korma/fields :rid :score :sid :cid)
    (korma/where {:rid rid})))


(defn get-by-id-full
  ""
  [rid]
  (let [r (first (get-by-id rid))
        s (first(student/get-by-id (:sid r)))
        c (first(course/get-by-id (:cid r)))]
    (-> r
        (dissoc :cid :sid)
        (assoc :student s :course c))))

(defn get-by-page
  ""
  [no size]
  (korma/select registration
    (korma/fields :rid :cid :sid)
    (korma/offset (* (- no 1) size))
    (korma/limit size)))


(defn save
  ""
  [bean]
  (if bean
    (korma/insert registration
      (korma/values {:sid (get bean :sid)}
                    {:cid (get bean :cid)}))))


(defn update
  ""
  [bean]
  (if bean
    (korma/update registration
      (korma/set-fields
        {:sid (get bean :sid)}
        {:cid (get bean :cid)})
      (korma/where {:rid (get bean :rid)}))))


(defn delete
  ""
  [rid]
  (if (get-by-id rid)
    (korma/delete registration
      (korma/where {:rid rid}))))


(defn count-total
  ""
  []
  ;(korma/exec-raw  ["SELECT count(mid) total FROM menu"] :results)
  (->
    (korma/select registration
      (korma/aggregate (count :rid) :total))
    first
    :total))
