create table "users"(
    id int primary key not null,
    "name" varchar(50) not null,
    email varchar(100) not null,
    password varchar(255) not null,
    registrationDate timestamp default current_timestamp
);

create table categories(
    id int primary key,
    "name" varchar(50) not null
);

create table articles(
    id int primary key,
    title varchar(100) not null,
    content text not null,
    author_id int references "users"(id),
    category_id int references categories(id),
    premium boolean,
    publicationTime timestamp default current_timestamp
);

create table comments(
    id int primary key,
    author_id int references users(id),
    article_id int references articles(id),
    "text" varchar(150) not null
);

create table serveys(
    id int primary key,
    type varchar(50) not null,
    question varchar(150) not null,
    description text not null,
    publicationTime timestamp default current_timestamp
);

create table questions(
    id int primary key,
    servey_id int references serveys(id),
    question varchar(150) not null
);

create table answer(
    id int primary key,
    question_id int references questions(id),
    answer varchar(150) not null,
    is_correct boolean
);

create table tags(
    id int primary key,
    "name" varchar(50) not null,
    publicationTime timestamp default current_timestamp
);

create table post_tag(
    article_id int references articles(id),
    tag_id int references tags(id),
    primary key (article_id, tag_id)
);

create table if not exists roles (
    id int primary key,
    "name" varchar(19) not null
);

create table user_role (
    user_id int references users(id),
    role_id int references roles(id),
    primary key (user_id, role_id)
);