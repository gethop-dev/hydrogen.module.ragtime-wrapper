(defproject dev.gethop/module.ragtime-wrapper "0.1.1-SNAPSHOT"
  :description "Duct module wrapping configuration for Ragtime migrations"
  :url "https://github.com/gethop-dev/module.ragtime-wrapper"
  :license {:name "Mozilla Public Licence 2.0"
            :url "https://www.mozilla.org/en-US/MPL/2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [duct/core "0.8.0"]
                 [integrant "0.7.0"]]
                   :deploy-repositories [["snapshots" {:url "https://clojars.org/repo"
                                      :username :env/clojars_username
                                      :password :env/clojars_password
                                      :sign-releases false}]
                        ["releases"  {:url "https://clojars.org/repo"
                                      :username :env/clojars_username
                                      :password :env/clojars_password
                                      :sign-releases false}]]
  :profiles {:dev {:plugins [[lein-cljfmt "0.6.6"]
                             [jonase/eastwood "0.3.5"]]}})
