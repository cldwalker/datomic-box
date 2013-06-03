(defproject datomic-box "0.1.0-SNAPSHOT"
  :description "TODO"
  :url "http://github.com/cldwalker/datomic-box"
  :license {:name "The MIT License"
            :url "https://en.wikipedia.org/wiki/MIT_License"}
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :profiles {:1.4 {:dependencies [[org.clojure/clojure "1.4.0"]]}}
  :aliases {"all" ["with-profile" "dev:dev,1.4"]}
  :test-selectors {:focus :focus :default (constantly true)})
