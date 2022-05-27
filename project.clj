(defproject dev.gethop/hydrogen.module.ragtime-wrapper "0.1.3-SNAPSHOT"
  :description "Duct module wrapping configuration for Ragtime migrations"
  :url "https://github.com/gethop-dev/hydrogen.module.ragtime-wrapper"
  :license {:name "Mozilla Public Licence 2.0"
            :url "https://www.mozilla.org/en-US/MPL/2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [duct/core "0.8.0"]
                 [integrant "0.7.0"]]
                   :deploy-repositories [["snapshots" {:url "https://clojars.org/repo"
                                      :username :env/CLOJARS_USERNAME
                                      :password :env/CLOJARS_PASSWORD
                                      :sign-releases false}]
                        ["releases"  {:url "https://clojars.org/repo"
                                      :username :env/CLOJARS_USERNAME
                                      :password :env/CLOJARS_PASSWORD
                                      :sign-releases false}]]
  :profiles {:dev {:plugins [[lein-cljfmt "0.8.0"]
                             [jonase/eastwood "1.2.3"]]}})
