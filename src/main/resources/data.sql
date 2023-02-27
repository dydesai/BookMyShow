
INSERT INTO city(city_id,city_name) values(1,'PUNE');
INSERT INTO city(city_id,city_name) values(2,'MUMBAI');

INSERT INTO movie(movie_id,title,genre,duration) values(1,'AVENGERS','SCI-FI',180);
INSERT INTO movie(movie_id,title,genre,duration) values(2,'GOLMAAL','COMEDY',180);
INSERT INTO movie(movie_id,title,genre,duration) values(3,'DRISHYAM 2','SUSPENSE',180);
INSERT INTO movie(movie_id,title,genre,duration) values(4,'RRR','ACTION',180);

INSERT INTO theatre(theatre_id,name,city_id,capacity,movie_id) values(1,'Alka talkies',1,100,1);
INSERT INTO theatre(theatre_id,name,city_id,capacity,movie_id) values(2,'Sun talkies',1,100,2);
INSERT INTO theatre(theatre_id,name,city_id,capacity,movie_id) values(3,'Moon talkies',1,100,3);
INSERT INTO theatre(theatre_id,name,city_id,capacity,movie_id) values(4,'Rupam talkies',1,100,4);

INSERT INTO show(show_id,show_time,availability,price,movie_id,theatre_id) values(1,'2023-02-26T09:30:00.000000',100,120,1,1);
INSERT INTO show(show_id,show_time,availability,price,movie_id,theatre_id) values(2,'2023-02-26T13:00:00.000000',100,120,1,1);
INSERT INTO show(show_id,show_time,availability,price,movie_id,theatre_id) values(3,'2023-02-26T17:00:00.000000',100,120,1,1);

INSERT INTO show(show_id,show_time,availability,price,movie_id,theatre_id) values(5,'2023-02-26T09:30:00.000000',100,200,2,2);
INSERT INTO show(show_id,show_time,availability,price,movie_id,theatre_id) values(6,'2023-02-26T13:00:00.000000',100,200,2,2);
INSERT INTO show(show_id,show_time,availability,price,movie_id,theatre_id) values(7,'2023-02-26T17:00:00.000000',100,200,2,2);
INSERT INTO show(show_id,show_time,availability,price,movie_id,theatre_id) values(8,'2023-02-26T22:00:00.000000',100,200,2,2);

INSERT INTO show(show_id,show_time,availability,price,movie_id,theatre_id) values(9,'2023-02-26T09:30:00.000000',100,220,3,3);
INSERT INTO show(show_id,show_time,availability,price,movie_id,theatre_id) values(10,'2023-02-26T13:00:00.000000',100,220,3,3);
INSERT INTO show(show_id,show_time,availability,price,movie_id,theatre_id) values(11,'2023-02-26T17:00:00.000000',100,220,3,3);
INSERT INTO show(show_id,show_time,availability,price,movie_id,theatre_id) values(12,'2023-02-26T22:00:00.000000',100,220,3,3);

INSERT INTO show(show_id,show_time,availability,price,movie_id,theatre_id) values(13,'2023-02-26T09:30:00.000000',100,250,4,4);
INSERT INTO show(show_id,show_time,availability,price,movie_id,theatre_id) values(14,'2023-02-26T13:00:00.000000',100,250,4,4);
INSERT INTO show(show_id,show_time,availability,price,movie_id,theatre_id) values(15,'2023-02-26T17:00:00.000000',100,250,4,4);
INSERT INTO show(show_id,show_time,availability,price,movie_id,theatre_id) values(16,'2023-02-26T22:00:00.000000',100,250,4,4);