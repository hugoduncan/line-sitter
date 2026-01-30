(ns line-sitter.check
  "Line length checking functions."
  (:require
   [clojure.string :as str]))

(defn check-line-lengths
  "Check a file for lines exceeding max-length.
  Returns vector of violations [{:line n :length len}] where :line is 1-indexed
  and :length is the actual character count of violating lines.
  Empty files return empty vector."
  [file-path max-length]
  (let [content (slurp file-path)
        lines (str/split-lines content)]
    (into []
          (comp
           (map-indexed (fn [idx line]
                          {:line (inc idx) :length (count line)}))
           (filter (fn [{:keys [length]}]
                     (> length max-length))))
          lines)))

(defn format-violation
  "Format a single violation for display.
  Returns string in format: path/to/file.clj:42: line exceeds 80 characters (actual: 95)"
  [{:keys [file line length]} max-length]
  (str file ":" line ": line exceeds " max-length " characters (actual: " length ")"))

(defn report-violations
  "Write formatted violations to stderr.
  Returns the number of violations reported."
  [violations max-length]
  (binding [*out* *err*]
    (doseq [v violations]
      (println (format-violation v max-length))))
  (count violations))
