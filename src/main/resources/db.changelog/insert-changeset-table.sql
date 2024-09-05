insert into roles (id, name)
values (1, 'ADMIN'), (2, 'AUTHOR'), (3, 'READER'), (4, 'PREMIUM');

insert into users (id, email, "name", "password") values (1, 'sasha@gmail.com', 'sasha', '123qwe'),
                                                         (2, 'vika@gmail.com', 'vika', 'qwertt');

insert into categories(id, "name") values (1, 'кулинария'),
                                          (2, 'спорт'),
                                          (3, 'музыка');

insert into articles(id, "content", premium, title) values
        (1, 'Человеческая деятельность по приготовлению пищи.', false, 'Кулинария'),
        (2, 'Олимпиада', false, 'Легкая атлетика');

insert into "comments"(id, "text") values (1, 'Лайк');

insert into serveys(id, "type", description, question) values (1, 'тест', 'пройди тест', 'вапрол?');

insert into questions(id, question, servey_id) values (1, 'asdfg?', 1);

insert into answer(id, answer, is_correct, question_id) values (1, 'dfghjk', true, 1),
                                                               (2, 'ertyu', false, 1),
                                                               (3, ';lkjn', false, 1);
insert into tags(id, "name") values (1, 'олимпиада'),
                                    (2, 'бег');