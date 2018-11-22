INSERT INTO TIP (id,title,author,description,url,created) VALUES (1,'Testaus', 'Alex Samurin', 'Any test that passed in unit testing can fail in system testing.', 'extremesoftwaretesting.com/Humor/SoftwareTestingJokes2.html',TO_DATE('07/02/2018', 'DD/MM/YYYY'));

INSERT INTO TIP (id,title,author,description,url,created) VALUES (2, 'If it hurts, do it more often', 'Matti', 'Adding manpower to a late software project makes it later!', 'https://fullstack-hy.github.io/',TO_DATE('17/11/2018', 'DD/MM/YYYY'));
INSERT INTO TIP (id,title,author,description,url,created) VALUES (3,'TIETOKANTAAN TALLENNETTAVAT OLIOT ELI ENTITEETIT', 'Arto', 'Luokat, joista tehdyt oliot voidaan tallentaa tietokantaan, tulee annotoida @Entity-annotaatiolla.', 'http://web-palvelinohjelmointi.github.io/osa1.html',TO_DATE('01/08/2018', 'DD/MM/YYYY'));
INSERT INTO TIP (id,title,author,description,url,created) VALUES (4,'INTERNETIN PERUSOSAT', 'Arto', 'Internetin peruskomponentit ovat (1) palveluiden, palvelinohjelmistojen ja resurssien yksilöintiin käytetyt merkkijonomuotoiset osoitteet (URI...', 'http://web-palvelinohjelmointi.github.io/osa2.html',TO_DATE('11/09/2018', 'DD/MM/YYYY'));
INSERT INTO TIP (id,title,author,description,url,created) VALUES (5,'HTTP: SELAINTEN JA PALVELINTEN VÄLINEN KOMMUNIKAATIOPROTOKOLLA', 'Arto', 'HTTP (HyperText Transfer Protocol) on TCP/IP -protokolla...', 'http://web-palvelinohjelmointi.github.io/osa2.html',TO_DATE('10/11/2018', 'DD/MM/YYYY'));
INSERT INTO TIP (id,title,author,description,url,created) VALUES (6,'HTTP-VIESTIN RAKENNE PALVELIMELTA SAAPUVA VASTAUS', 'Arto', 'Palvelimelle tehtyyn pyyntöön saadaan aina jonkinlainen vastaus.', 'http://web-palvelinohjelmointi.github.io/osa2.html',TO_DATE('10/10/2018', 'DD/MM/YYYY'));
INSERT INTO TIP (id,title,author,description,url,created) VALUES (7,'The first 90 percent of the code accounts for the first 90 percent of the development time...The remaining 10 percent of the code accounts for the other 90 percent of the development time.', 'Matti', 'Any fool can write code that a computer can understand. Good programmers write code that humans can understand.', 'https://fullstack-hy.github.io/',TO_DATE('11/10/2015', 'DD/MM/YYYY'));
INSERT INTO TIP (id,title,author,description,url,created) VALUES (8,'Premature optimization is the root of all evil.', 'Matti', 'Debugging is twice as hard as writing the code in the first place. Therefore, if you write the code as cleverly as possible, you are, by definition, not smart enough to debug it.', 'https://fullstack-hy.github.io/',TO_DATE('12/10/2017', 'DD/MM/YYYY'));
INSERT INTO TIP (id,title,author,description,url,created) VALUES (9,'Model-view-controller', 'Wikipedia','Diagram of interactions within the MVC pattern.
Model–view–controller is an architectural pattern commonly used for developing user interfaces that divides an application into three interconnected parts.', 'https://en.wikipedia.org/wiki/Model-view-controller',TO_DATE('17/12/2015', 'DD/MM/YYYY'));
INSERT INTO TIP (id,title,author,description,url,created) VALUES (10,'asddasdas', 'asddasdas', 'asddas', 'http://www.google.fi',TO_DATE('17/12/2016', 'DD/MM/YYYY'));

INSERT INTO TAG(id,name) VALUES (1, 'Wepa');
INSERT INTO TAG(id,name) VALUES (2, 'Fullstack');
INSERT INTO TAG(id,name) VALUES (3, 'Anecdotes');

INSERT INTO TIP_TAGS(tip_id, tag_id) VALUES(1,1);
INSERT INTO TIP_TAGS(tip_id, tag_id) VALUES(1,2);
INSERT INTO TIP_TAGS(tip_id, tag_id) VALUES(1,3);
INSERT INTO TIP_TAGS(tip_id, tag_id) VALUES(2,3);
INSERT INTO TIP_TAGS(tip_id, tag_id) VALUES(3,1);
INSERT INTO TIP_TAGS(tip_id, tag_id) VALUES(4,1);
INSERT INTO TIP_TAGS(tip_id, tag_id) VALUES(5,1);
INSERT INTO TIP_TAGS(tip_id, tag_id) VALUES(6,2);
INSERT INTO TIP_TAGS(tip_id, tag_id) VALUES(7,2);
INSERT INTO TIP_TAGS(tip_id, tag_id) VALUES(8,3);
INSERT INTO TIP_TAGS(tip_id, tag_id) VALUES(9,1);
INSERT INTO TIP_TAGS(tip_id, tag_id) VALUES(9,2);
