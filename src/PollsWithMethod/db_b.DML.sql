-- QUESTION 테이블에 데이터 삽입
INSERT INTO QUESTION (QUESTION, QUESTION_ID)
VALUES ('문항1', 'Q1'),
       ('문항2', 'Q2'),
       ('문항3', 'Q3');

-- ANSWER 테이블에 데이터 삽입
INSERT INTO ANSWER (ANSWER, ANSWER_ID, QUESTION_ID)
VALUES ('답항1', 'A1', 'Q1'),
       ('답항2', 'A2', 'Q1'),
       ('답항3', 'A3', 'Q2'),
       ('답항4', 'A4', 'Q2'),
       ('답항5', 'A5', 'Q3');

-- USER 테이블에 데이터 삽입
INSERT INTO USER (USER_NAME, USER_ID)
VALUES ('사용자1', 'U1'),
       ('사용자2', 'U2'),
       ('사용자3', 'U3');

-- SURVEY 테이블에 데이터 삽입
INSERT INTO SURVEY (QUESTION_ID, ANSWER_ID, SURVEY_ID, USER_ID)
VALUES ('Q1', 'A1', 'S1', 'U1'),
       ('Q2', 'A3', 'S2', 'U1'),
       ('Q1', 'A2', 'S3', 'U2'),
       ('Q2', 'A4', 'S4', 'U2'),
       ('Q3', 'A5', 'S5', 'U3');