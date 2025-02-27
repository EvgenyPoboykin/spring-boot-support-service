
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS public.issue (
    "id" uuid PRIMARY KEY NOT NULL DEFAULT (uuid_generate_v4()),
    "target_uri" varchar NOT NULL,
    "image" varchar NOT NULL,
    "description" varchar NOT NULL,
    "client_id" varchar NULL,
    "client_name" varchar NULL,
    "stage" varchar DEFAULT('NEW'),
    "created_at" TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    "updated_at" TIMESTAMP WITH TIME ZONE DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS public.stage (
    "value" varchar NOT NULL,
    "label" varchar NOT NULL
);

CREATE TABLE IF NOT EXISTS public.comment (
    "id" uuid PRIMARY KEY NOT NULL DEFAULT (uuid_generate_v4()),
    "issue_id" uuid NOT NULL,
    "description" varchar NOT NULL,
    "created_at" TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    "client_id" varchar NULL,
    "client_name" varchar NULL
);
