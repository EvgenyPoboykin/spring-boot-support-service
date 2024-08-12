
CREATE TABLE IF NOT EXISTS public.issue (
    id UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
    target_uri varchar NOT NULL,
    image varchar,
    description varchar NOT NULL,
    client_id UUID NOT NULL,
    client_name varchar NULL,
    stage varchar DEFAULT('NEW'),
    created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS public.comment (
    id UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
    issue_id UUID REFERENCES public.issue(id),
    description varchar NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    client_id UUID NOT NULL,
    client_name varchar NULL
);
