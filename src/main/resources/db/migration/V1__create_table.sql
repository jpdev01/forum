create table course
(
    id       bigint not null auto_increment,
    name     varchar(50),
    category varchar(50),
    primary key (id)
);

insert into course(id, name, category) values(1, 'Kotlin', 'Programacao');

create table user
(
    id    bigint not null auto_increment,
    name  varchar(50),
    email varchar(50),
    primary key (id)
);

insert into user(id, name, email) values(1, 'Ana', 'ana@gmail.com');

create table topic
(
    id bigint not null auto_increment,
    title varchar(50) not null,
    message varchar(300),
    date_created datetime not null,
    status varchar(20) not null,
    course_id bigint not null,
    author_id bigint not null,

    primary key (id),
    foreign key (course_id) references course (id),
    foreign key (author_id) references user (id)
);

create table answer
(
    id bigint not null auto_increment,
    message varchar(300),
    date_created datetime not null,
    topic_id bigint not null,
    author_id bigint not null,
    solve_topic int(1) not null,

    primary key(id),
    foreign key(topic_id) references topic(id),
    foreign key(author_id) references user(id)
);