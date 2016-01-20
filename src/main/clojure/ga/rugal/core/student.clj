(ns ga.rugal.core.student
  (:require [korma.core :as korma])
  (:require [ga.rugal.core.entity :refer :all])
  )


(defn get-by-id
  ""
  [sid]
  (korma/select
    student
    (korma/fields :sid :name)
    (korma/where {:sid sid})
    )
  )


(defn get-by-page
  ""
  [no size]
  (korma/select
    student
    (korma/fields :sid :name)
    (korma/offset (* (- no 1) size))
    (korma/limit size)
    )
  )



(defn save
  ""
  [bean]
  (if bean
    (korma/insert
      student
      (korma/values {:name (get bean :name)})
      )
    )
  )


(defn update
  ""
  [bean]
  (if bean
    (korma/update
      student
      (korma/set-fields {:name (get bean :name)})
      (korma/where {:sid (get bean :sid)})
      )
    )
  )


(defn delete
  ""
  [sid]
  (if (get-by-id sid)
    (korma/delete
      student
      (korma/where {:sid sid})
      )
    )
  )



(defn count-total
  ""
  []
  ;(korma/exec-raw  ["SELECT count(mid) total FROM menu"] :results)
  (->
    (korma/select
      student
      (korma/aggregate (count :sid) :total)
      )
    first
    :total
    )
  )
