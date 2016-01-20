(ns ga.rugal.core.entity
  (:require [korma.core :refer :all])
  (:require [ga.rugal.core.db :refer :all])
  )

(declare student course registration)

(defentity student
           (pk :sid)
           ;(entity-fields :rid :address :name :phone)
           (has-many registration {:fk :sid})
           )

(defentity course
           (pk :cid)
           (has-many registration {:fk :cid})
           )

(defentity registration
           (pk :rid)
           (has-one student)
           (has-one course)
  )