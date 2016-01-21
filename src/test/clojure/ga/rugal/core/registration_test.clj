(ns ga.rugal.core.registration-test
  (:require [clojure.test :refer :all]
            [ga.rugal.core.registration :refer :all]))


(deftest test-get-by-page
  (testing "get by page"
    (let [no 1  size 2 records (count(get-by-page no size))]
      (is (and (>= 0 ) (<= records size))))))


(deftest test-get-by-id
  (testing "get by id"
    (let [id 1 bean  (get-by-id-full id)]
      (is (not (empty? bean))))))


(deftest test-get-by-id-full
  (testing "get by id full"
    (let [id 1 bean  (get-by-id id)]
      (is (not (empty? bean))))))


(deftest test-count-total
  (testing "test count total"
    (let [count (count-total)]
    (is (>= count 0)))))
