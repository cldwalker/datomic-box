(ns datomic-box.core
  (:require
    [pallet.api :as api]
    [pallet.configure :as configure]
    [pallet.crate.automated-admin-user :as admin-user]
    [pallet.crate.java :as java]
    [pallet.crate.datomic :as datomic]
    [pallet.crate.upstart :as upstart]))

(def default-node-spec
  (api/node-spec
   :image {:os-family :ubuntu :image-id "us-east-1/ami-9c78c0f5"}
    ;; Using a small since datomic defaults to using a 1GB ram
   :hardware {:min-cores 1 :hardware-id "m1.small" }))

(def
  ^{:doc "Defines the type of node datomic-box will run on"}
  base-server
  (api/server-spec
   :phases
   {:bootstrap (api/plan-fn (admin-user/automated-admin-user))}))

(def project-spec
  (api/group-spec "datomic-box"
   :extends [base-server
             ;; TODO: Use openjdk. Currently ubuntu 12 ships with a broken openjdk.
             ;; Need to update packages to unbreak it.
             (java/server-spec {:vendor :oracle :version [7]})
             (datomic/datomic {})
             (upstart/server-spec {})]
   :count 1
   :node-spec default-node-spec))

(comment
  ;; Use api/converge when creating your box for the first time.
  ;; For future invocations on your box, use api/lift.
  (api/converge
    project-spec 
    :phase :install
    :compute (configure/compute-service :aws))) 
