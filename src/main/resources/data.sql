insert into user values(1001, 'A', 'B');
insert into user values(1002, 'C', 'D');

insert into contact values (201, 'skype', 'skypename', 1001);
insert into contact values (202, 'phone', '000999', 1001);
insert into contact values (203, 'skype', 'value123', 1002);

insert into meeting (id, date, description, title, organizer_id) values (101, '2019-01-01', 'description', 'title', 1001);
insert into meeting (id, date, description, title, organizer_id) values (102, '2019-01-01', 'description', 'title', 1001);

insert into user_meeting (user_id, meeting_id) values (1001, 101);
insert into user_meeting (user_id, meeting_id) values (1001, 102);
insert into user_meeting (user_id, meeting_id) values (1002, 102);

insert into comment(id, text, meeting_id, user_id) values (301, 'comment text', 101, 1001);
