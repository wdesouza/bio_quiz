DROP TABLE IF EXISTS quiz.quiz_questao;
DROP TABLE IF EXISTS quiz.quiz;
DROP TABLE IF EXISTS quiz.jogador;
DROP TABLE IF EXISTS quiz.alternativa;
DROP TABLE IF EXISTS quiz.questao;
DROP SCHEMA IF EXISTS quiz;

CREATE SCHEMA quiz;

-- -----------------------------------------------------
-- Table quiz.questao
-- -----------------------------------------------------

CREATE TABLE quiz.questao (
  id_questao INTEGER NOT NULL ,
  descricao TEXT NOT NULL ,
  PRIMARY KEY (id_questao) 
);

-- -----------------------------------------------------
-- Table quiz.alternativa
-- -----------------------------------------------------

CREATE TABLE quiz.alternativa (
  id_alternativa INTEGER NOT NULL ,
  ref_questao INTEGER NOT NULL ,
  descricao TEXT NOT NULL ,
  verdade INTEGER NOT NULL,
  comentario TEXT NULL ,
  PRIMARY KEY (id_alternativa) ,
  CONSTRAINT fk_alternativa_questao
    FOREIGN KEY (ref_questao )
    REFERENCES quiz.questao (id_questao )
);

-------------------------------------------------------
-- Table quiz.jogador
-------------------------------------------------------


CREATE TABLE quiz.jogador (
  email character varying(100) NOT NULL ,
  nome character varying(100) NOT NULL ,
  PRIMARY KEY (email) 
);

-- -----------------------------------------------------
-- Table quiz.quiz
-- -----------------------------------------------------


CREATE TABLE quiz.quiz (
  id_quiz INTEGER NOT NULL ,
  ref_jogador CHARACTER VARYING(100) NOT NULL ,
  data_quiz DATE NOT NULL ,
  tempo INTEGER NOT NULL, 
  PRIMARY KEY (id_quiz) ,
  CONSTRAINT fk_quiz_jogador1
    FOREIGN KEY (ref_jogador )
    REFERENCES quiz.jogador (email )
);


-- -----------------------------------------------------
-- Table quiz.quiz_questao
-- -----------------------------------------------------

CREATE  TABLE quiz.quiz_questao (
  ref_quiz INTEGER NOT NULL ,
  ref_questao INTEGER NOT NULL ,
  alternativa_selecionada INTEGER NOT NULL ,
  PRIMARY KEY (ref_quiz, ref_questao) ,
  CONSTRAINT fk_quiz_questao_quiz1
    FOREIGN KEY (ref_quiz )
    REFERENCES quiz.quiz (id_quiz )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_quiz_questao_questao1
    FOREIGN KEY (ref_questao )
    REFERENCES quiz.questao (id_questao )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_quiz_questao_alternativa1
    FOREIGN KEY (alternativa_selecionada )
    REFERENCES quiz.alternativa (id_alternativa )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);


DROP SEQUENCE IF EXISTS quiz.seq_alternativa;
DROP SEQUENCE IF EXISTS quiz.seq_quiz;

CREATE SEQUENCE quiz.seq_alternativa
   INCREMENT 1
   START 1
   MAXVALUE 999999999;

CREATE SEQUENCE quiz.seq_quiz
   INCREMENT 1
   START 1
   MAXVALUE 999999999;