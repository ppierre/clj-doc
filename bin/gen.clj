(require 'clj-doc.core 'clj-doc.generator.default)


(let [[clojure-src clojure-contrib-src doc-dest static-contents-dir] *command-line-args*]
  (clj-doc.core/generate-and-write
    `(clojure.core clojure.set clojure.xml
      clojure.contrib.cond  clojure.contrib.def  clojure.contrib.duck-streams
      clojure.contrib.fcase clojure.contrib.pred clojure.contrib.seq-utils
      clojure.contrib.str-utils)
    `(~clojure-src,
      ~clojure-contrib-src)
    #(clj-doc.generator.default/generate  %1 %2 static-contents-dir
      {:title "clj-doc: Clojure Library Documentation"})
    doc-dest)
  )
