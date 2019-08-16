(ns jobtech-nlp-tokeniser.tokeniser-test
  (:require [clojure.test :as test]
            [clojure.data :as data]
            [jobtech-nlp-tokeniser.tokeniser :as tokeniser]))

(test/deftest basic-tokenisation
  (test/testing "Tokenise a sentence."
    (let [tokens (tokeniser/tokenise-no-punctuation "Detta är en text -med, skräp:,:;())")
          [only-a only-b both] (data/diff tokens ["Detta" "är" "en" "text" "med" "skräp"])]
      (test/is (and (= only-a nil) (= only-b nil))))))
