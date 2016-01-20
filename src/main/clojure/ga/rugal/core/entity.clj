(ns ga.rugal.core.entity
  (:require [korma.core :as korma])
  (:require [ga.rugal.core.db :refer :all]))

(declare student course registration)


(korma/defentity student
  (korma/pk :sid)
  ;(entity-fields :rid :address :name :phone)
  (korma/has-many registration {:fk :sid}))


(korma/defentity course
  (korma/pk :cid)
  (korma/has-many registration {:fk :cid}))


(korma/defentity registration
  (korma/pk :rid)
  (korma/has-one student)
  (korma/has-one course))
