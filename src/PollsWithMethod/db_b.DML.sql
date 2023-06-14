-- QUESTION 테이블에 데이터 삽입
INSERT INTO QUESTION (QUESTION, QUESTION_ID)
VALUES
('1. 교수는 수업 전 강의 목표를 명확히 제시하였습니까?', 'Q-01'),
('2. 강의의 내용은 체계적이고 성의있게 구성되었는가?', 'Q-02'),
('3. 교수는 강의 내용에 대해 전문적 지식이 있었는가?', 'Q-03'),
('4. 강의 진행 속도는 적절하였는가?', 'Q-04');

-- ANSWER 테이블에 데이터 삽입
INSERT INTO ANSWER (ANSWER, ANSWER_ID)
VALUES 
('(1) 전혀 아니다.', 'A-01'),
('(2) 아니다.', 'A-02'),
('(3) 그렇다.', 'A-03'),
('(4) 매우그렇다.', 'A-04');

-- QNA_ID 테이블에 데이터 삽입
INSERT INTO QNA_ID (QUESTION_ID, ANSWER_ID)
VALUES 
('Q-01', 'A-01'),
('Q-02', 'A-02'),
('Q-03', 'A-03'),
('Q-04', 'A-04');

-- USER 테이블에 데이터 삽입
INSERT INTO USER (USER_NAME, USER_ID)
VALUES 
('홍길동', 'P-01'),
('장길산', 'P-02'),
('신사임당', 'P-03'),
('이순신', 'P-04');

-- SURVEY 테이블에 데이터 삽입
INSERT INTO SURVEY (QUESTION_ID, ANSWER_ID, SURVEY_ID, USER_ID)
VALUES 
('Q-01', 'A-01', 'S-01', 'P-01'),
('Q-02', 'A-03', 'S-02', 'P-01'),
('Q-01', 'A-02', 'S-03', 'P-02'),
('Q-02', 'A-04', 'S-04', 'P-02'),
('Q-03', 'A-03', 'S-05', 'P-03');
