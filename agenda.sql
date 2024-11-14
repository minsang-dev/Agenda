// 일정 테이블 생성
CREATE TABLE agenda
(
    id          INT         NOT NULL AUTO_INCREMENT,
    author_id   INT         NOT NULL,
    user_name   VARCHAR(25) NOT NULL,
    title       VARCHAR(25) NOT NULL,
    contentS    VARCHAR(50) NULL,
    createDate DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updateDate DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    primary key (id),
    foreign key (author_id) references author(id)
);

// 작성자 테이블 생성
CREATE TABLE author
(
    id          INT        NOT NULL,
    agenda_id   INT        NOT NULL AUTO_INCREMENT,
    user_name   VARCHAR(25) NOT NULL,
    password    VARCHAR(25) NOT NULL,
    email       VARCHAR(50) NULL,
    createDate DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updateDate DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    primary key (id)
);

INSERT INTO author (user_name, email, password)
    VALUES ("zzanggu", "qwer@gmail.com", "1234");

// 작성자 조회
SELECT *
FROM author
WHERE agenda_id = 1;

// 작성자 삭제
DELETE
FROM author
WHERE agenda_id = 1;


INSERT INTO agenda (user_name, title, contents)
VALUES ("user_name", "title", "contents");

// 전체 일정 조회
SELECT *
FROM agenda
WHERE author_id = 1;

// 선택 일정 조회
SELECT *
FROM agenda
WHERE author_id = 1;

// 선택한 일정 수정
UPDATE agenda
SET content = '들숨날숨 쉬기'
WHERE author_id = 1;

// 선택한 일정 삭제
DELETE
from agenda
WHERE id = 1;