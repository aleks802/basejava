create table if not exists resume
(
	uuid char(36) not null
		constraint resume_pkey
			primary key,
	fullname text
);

create table if not exists contact
(
	id serial not null
		constraint contact_pkey
			primary key,
	type text not null,
	value text not null,
	resume_uuid char(36) not null
		constraint contact_resume_uuid_fk
			references resume
				on delete cascade
);

