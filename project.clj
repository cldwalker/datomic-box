(defproject datomic-box "0.1.0-SNAPSHOT"
  :description "TODO"
  :url "http://github.com/cldwalker/datomic-box"
  :license {:name "The MIT License"
            :url "https://en.wikipedia.org/wiki/MIT_License"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 ;; Can't do 0.8.0-beta10
                 ;; datomic-crate error - ExceptionInfo Invalid remote-file-arguments: Path [:service-impl] was not specified in the schema.  clojure.core/ex-info (core.clj:4327)
                 [com.palletops/pallet "0.8.0-beta.8"]
                 [org.cloudhoist/pallet-jclouds "1.5.2"]
                 [org.clojars.strad/datomic-crate "0.8.6"]
                 [com.palletops/java-crate "0.8.0-beta.5"]
                 [com.palletops/upstart-crate "0.8.0-alpha.2"]

                 ;; To get started we include all jclouds compute providers.
                 ;; You may wish to replace this with the specific jclouds
                 ;; providers you use, to reduce dependency sizes.
                 [org.jclouds/jclouds-allblobstore "1.5.5"]
                 [org.jclouds/jclouds-allcompute "1.5.5"]
                 [org.jclouds.driver/jclouds-slf4j "1.5.5"
                  ;; the declared version is old and can overrule the
                  ;; resolved version
                  :exclusions [org.slf4j/slf4j-api]]
                 [org.jclouds.driver/jclouds-sshj "1.5.5"]
                 [ch.qos.logback/logback-classic "1.0.9"]]
  :plugins [[com.palletops/pallet-lein "0.6.0-beta.9"]]
  :profiles {:1.4 {:dependencies [[org.clojure/clojure "1.4.0"]]}
             :pallet {}}
  :repositories
  {"sonatype" "https://oss.sonatype.org/content/repositories/releases/"} 
  :aliases {"all" ["with-profile" "dev:dev,1.4"]}
  :test-selectors {:focus :focus :default (constantly true)})
