--liquibase formatted sql

--changeset Ivan Mataras:initialize database

CREATE TABLE "users"
(
  "id"              serial                NOT NULL,
  "name"            character varying(32) NOT NULL,
  "full_name"       character varying(32) NOT NULL,
  "organization_id" integer               NOT NULL,
  "role_id"         integer               NOT NULL,
  CONSTRAINT users_pk PRIMARY KEY ("id")
) WITH
(
  OIDS=FALSE
);



CREATE TABLE "organization"
(
  "id"        serial                NOT NULL,
  "name"      character varying(32) NOT NULL,
  "full_name" character varying(32) NOT NULL,
  CONSTRAINT organization_pk PRIMARY KEY ("id")
) WITH
(
  OIDS=FALSE
);



CREATE TABLE "roles"
(
  "id"        serial                NOT NULL,
  "name"      character varying(32) NOT NULL,
  "full_name" character varying(32) NOT NULL,
  CONSTRAINT roles_pk PRIMARY KEY ("id")
) WITH
(
  OIDS=FALSE
);



CREATE TABLE "document_types"
(
  "id"   serial                NOT NULL,
  "type" character varying(32) NOT NULL,
  CONSTRAINT document_types_pk PRIMARY KEY ("id")
) WITH
(
  OIDS=FALSE
);



CREATE TABLE "document_statuses"
(
  "id"     serial                NOT NULL,
  "status" character varying(32) NOT NULL,
  CONSTRAINT document_statuses_pk PRIMARY KEY ("id")
) WITH
(
  OIDS=FALSE
);



CREATE TABLE "routes"
(
  "id"       serial  NOT NULL,
  "owner_id" integer NOT NULL,
  "sender"   integer NOT NULL,
  "receiver" integer NOT NULL,
  CONSTRAINT routes_pk PRIMARY KEY ("id")
) WITH
(
  OIDS=FALSE
);



CREATE TABLE "documents"
(
  "id"          serial                 NOT NULL,
  "number"      integer                NOT NULL,
  "date"        TIMESTAMP              NOT NULL,
  "type"        integer                NOT NULL,
  "status"      integer                NOT NULL,
  "filename"    character varying(256) NOT NULL,
  "sender_id"   integer                NOT NULL,
  "receiver_id" integer                NOT NULL,
  CONSTRAINT documents_pk PRIMARY KEY ("id")
) WITH
(
  OIDS=FALSE
);



ALTER TABLE "users"
  ADD CONSTRAINT "users_fk0" FOREIGN KEY ("organization_id") REFERENCES "organization" ("id");
ALTER TABLE "users"
  ADD CONSTRAINT "users_fk1" FOREIGN KEY ("role_id") REFERENCES "roles" ("id");



ALTER TABLE "routes"
  ADD CONSTRAINT "routes_fk0" FOREIGN KEY ("owner_id") REFERENCES "organization" ("id");
ALTER TABLE "routes"
  ADD CONSTRAINT "routes_fk1" FOREIGN KEY ("sender") REFERENCES "organization" ("id");
ALTER TABLE "routes"
  ADD CONSTRAINT "routes_fk2" FOREIGN KEY ("receiver") REFERENCES "organization" ("id");

ALTER TABLE "documents"
  ADD CONSTRAINT "documents_fk0" FOREIGN KEY ("type") REFERENCES "document_types" ("id");
ALTER TABLE "documents"
  ADD CONSTRAINT "documents_fk1" FOREIGN KEY ("status") REFERENCES "document_statuses" ("id");
ALTER TABLE "documents"
  ADD CONSTRAINT "documents_fk2" FOREIGN KEY ("sender_id") REFERENCES "organization" ("id");
ALTER TABLE "documents"
  ADD CONSTRAINT "documents_fk3" FOREIGN KEY ("receiver_id") REFERENCES "organization" ("id");
