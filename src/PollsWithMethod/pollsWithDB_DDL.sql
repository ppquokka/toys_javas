
CREATE TABLE ANSWER
(
  ANSWER    VARCHAR(500) NOT NULL COMMENT '답항',
  ANSWER_ID VARCHAR(500) NOT NULL COMMENT '답항_id',
  PRIMARY KEY (ANSWER_ID)
) COMMENT '답항';

CREATE TABLE QUESTION
(
  QUESTION    VARCHAR(500) NOT NULL COMMENT '문항',
  QUESTION_ID VARCHAR(500) NOT NULL COMMENT '문항_id',
  PRIMARY KEY (QUESTION_ID)
) COMMENT '문항';

CREATE TABLE SURVEY
(
  QUESTION_ID VARCHAR(500) NOT NULL COMMENT '문항_id',
  ANSWER_ID   VARCHAR(500) NOT NULL COMMENT '답항_id',
  SURVEY_ID   VARCHAR(500) NOT NULL COMMENT '설문_id',
  USER_ID     VARCHAR(500) NOT NULL COMMENT '설문자_id',
  PRIMARY KEY (SURVEY_ID)
) COMMENT '설문';

CREATE TABLE USER
(
  USER_NAME VARCHAR(500) NOT NULL COMMENT '이름',
  USER_ID   VARCHAR(500) NOT NULL COMMENT '설문자_id',
  PRIMARY KEY (USER_ID)
) COMMENT '설문자';

ALTER TABLE SURVEY
  ADD CONSTRAINT FK_QUESTION_TO_SURVEY
    FOREIGN KEY (QUESTION_ID)
    REFERENCES QUESTION (QUESTION_ID);

ALTER TABLE SURVEY
  ADD CONSTRAINT FK_ANSWER_TO_SURVEY
    FOREIGN KEY (ANSWER_ID)
    REFERENCES ANSWER (ANSWER_ID);

ALTER TABLE SURVEY
  ADD CONSTRAINT FK_USER_TO_SURVEY
    FOREIGN KEY (USER_ID)
    REFERENCES USER (USER_ID);
