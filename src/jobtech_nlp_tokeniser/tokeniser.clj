(ns jobtech-nlp-tokeniser.tokeniser
  (:require
   [clojure.string :as str]))

(defn tokenise-no-punctuation [text]
  "Split a text into tokens."
  (-> text
      ;; normalize different types of white space to space
      (str/replace #"\s+" " ")
      ;; Erase punctuation
      (str/replace #"[^\w\s\p{IsAlphabetic}]+" " ") ;; #","
      ;; Split on sequences of space
      (str/split #"\s+")))
