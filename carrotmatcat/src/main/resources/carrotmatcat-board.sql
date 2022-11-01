-- 게시판 carrotmatcat_board 테이블 생성
CREATE TABLE carrotmatcat_board(
	article_no NUMBER PRIMARY KEY,
	article_title VARCHAR2(100) NOT NULL,
	article_content CLOB NOT NULL,
	article_store_category VARCHAR2(100) NOT NULL,
	article_store_name VARCHAR2(100) NOT NULL,
	article_time_posted DATE NOT NULL,
	article_hits NUMBER DEFAULT 0,
	article_image_name VARCHAR2(100),
	member_id VARCHAR2(100) NOT NULL,
	CONSTRAINT board_fk FOREIGN KEY(member_id) REFERENCES carrotmatcat_member(member_id) 
)

-- 게시판 번호(article_no) 시퀀스 생성
CREATE SEQUENCE carrotmatcat_board_seq;
DROP SEQUENCE carrotmatcat_board_seq;

--board에 insert DML
INSERT INTO carrotmatcat_board(article_no, article_title, article_content,article_store_category,article_store_name,article_time_posted,article_image_name,member_id)
VALUES(carrotmatcat_board_seq.nextval, '콩나물국밥먹었어요', '내용1번', '한식', '숙아채콩나물국밥', SYSDATE,'food.jfif','yerin0110');

INSERT INTO carrotmatcat_board(article_no, article_title, article_content,article_store_category,article_store_name,article_time_posted,article_image_name,member_id)
VALUES(carrotmatcat_board_seq.nextval, '깨돌이먹었어요', '내용2번', '한식', '깨돌이김밥', SYSDATE,'kimbab.jfif','chaeeunseo');

INSERT INTO carrotmatcat_board(article_no, article_title, article_content,article_store_category,article_store_name,article_time_posted,article_image_name,member_id)
VALUES(carrotmatcat_board_seq.nextval, '라이포차갔어요', '내용입니다', '한식', '라이포차', SYSDATE,'pocha.jfif','zkxkckvk');

INSERT INTO carrotmatcat_board(article_no, article_title, article_content,article_store_category,article_store_name,article_time_posted,article_image_name,member_id)
VALUES(carrotmatcat_board_seq.nextval, '샌드위치먹었어요~^^', '내용입니다2', '양식', '서브웨이', SYSDATE,'sandwich.jfif','hasense9410');

INSERT INTO carrotmatcat_board(article_no, article_title, article_content,article_store_category,article_store_name,article_time_posted,article_image_name,member_id)
VALUES(carrotmatcat_board_seq.nextval, '간단하게 식사했어요', '내용', '일식', '유메노키친', SYSDATE,'goodgood.jfif','kimyunsooooo');

SELECT * FROM carrotmatcat_board