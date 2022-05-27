;; This Source Code Form is subject to the terms of the Mozilla Public
;; License, v. 2.0. If a copy of the MPL was not distributed with this
;; file, You can obtain one at http://mozilla.org/MPL/2.0/

(ns dev.gethop.module.ragtime-wrapper
  (:require [clojure.string :as str]
            [duct.core :as core]
            [integrant.core :as ig]))

(defn- migration-name [migration-path]
  (last (str/split migration-path #"/")))

(defn- migration-keyword [migration-namespace migration-path]
  (keyword
   migration-namespace
   (str "_" (migration-name migration-path))))

(defn- migrations-refs [migration-namespace migrations-paths]
  (mapv #(ig/ref (migration-keyword migration-namespace %)) migrations-paths))

(defmethod ig/init-key :dev.gethop.module/ragtime-wrapper [_ _]
  (fn [config]
    (core/merge-configs
     config
     (when-let [migrations-paths (get-in config [:duct.migrator/ragtime :migrations-paths])]
       (let [m-namespace (str (::core/project-ns config) ".migration")]
         (into {:duct.migrator/ragtime {:migrations (migrations-refs m-namespace migrations-paths)}}
               (map
                (fn [m-path]
                  [[:duct.migrator.ragtime/sql (migration-keyword m-namespace m-path)]
                   {:up [(core/resource (str m-path ".up.sql"))]
                    :down [(core/resource (str m-path ".down.sql"))]}])
                migrations-paths)))))))
