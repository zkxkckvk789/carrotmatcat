-- 게시판 carrotmatcat_board 테이블 생성
CREATE TABLE carrotmatcat_board(
	article_no NUMBER PRIMARY KEY,
	article_title VARCHAR2(100) NOT NULL,
	article_content CLOB NOT NULL,
	article_food_category VARCHAR2(100) NOT NULL,
	article_store_name VARCHAR2(100) NOT NULL,
	article_time_posted DATE NOT NULL,
	article_hits NUMBER DEFAULT 0,
	member_id VARCHAR2(100) NOT NULL,
	CONSTRAINT board_fk FOREIGN KEY(member_id) REFERENCES carrotmatcat_member(member_id) 
)

-- 게시판 번호(article_no) 시퀀스 생성
CREATE SEQUENCE carrotmatcat_board_seq;
DROP SEQUENCE carrotmatcat_board_seq;

--board에 insert DML
INSERT INTO carrotmatcat_board(article_no, article_title, article_content,article_food_category,article_store_name,article_time_posted,article_image_name,member_id)
VALUES(carrotmatcat_board_seq.nextval, '콩나물국밥먹었어요', '내용1번', '한식', '숙아채콩나물국밥', SYSDATE,'yerin0110');

INSERT INTO carrotmatcat_board(article_no, article_title, article_content,article_food_category,article_store_name,article_time_posted,article_image_name,member_id)
VALUES(carrotmatcat_board_seq.nextval, '깨돌이먹었어요', '내용2번', '한식', '깨돌이김밥', SYSDATE,'chaeeunseo');

INSERT INTO carrotmatcat_board(article_no, article_title, article_content,article_food_category,article_store_name,article_time_posted,article_image_name,member_id)
VALUES(carrotmatcat_board_seq.nextval, '라이포차갔어요', '내용입니다', '한식', '라이포차', SYSDATE,'zkxkckvk');

INSERT INTO carrotmatcat_board(article_no, article_title, article_content,article_food_category,article_store_name,article_time_posted,article_image_name,member_id)
VALUES(carrotmatcat_board_seq.nextval, '샌드위치먹었어요~^^', '내용입니다2', '양식', '서브웨이', SYSDATE,'hasense9410');

INSERT INTO carrotmatcat_board(article_no, article_title, article_content,article_food_category,article_store_name,article_time_posted,article_image_name,member_id)
VALUES(carrotmatcat_board_seq.nextval, '간단하게 식사했어요', '내용', '일식', '유메노키친', SYSDATE,'kimyunsooooo');

ALTER TABLE carrotmatcat_board DROP COLUMN article_image_name;

--article_store_category이름 article_food_category로 변경
ALTER TABLE carrotmatcat_board RENAME COLUMN article_store_category TO article_food_category;

--상세글보기
SELECT cb.article_no, cb.article_title,cb.article_food_category, cm.member_nickname, TO_CHAR(cb.article_time_posted,'YYYY.MM.DD HH:MI:SS') 
AS article_time_posted, cb.article_store_name, cb.article_content, cb.article_hits
FROM carrotmatcat_board cb
INNER JOIN carrotmatcat_member cm ON cb.member_id=cm.member_id
WHERE cb.article_no=?;

--게시글 목록 조회용
SELECT cb.rnum,cb.article_no, cb.article_title,cb.article_store_name, cm.member_nickname, cb.article_time_posted, cb.article_hits
FROM(
SELECT ROW_NUMBER() OVER(ORDER BY article_no DESC) AS rnum,article_no,article_title,member_id,article_store_name,TO_CHAR(article_time_posted,'YYYY.MM.DD HH:MI:SS') 
AS article_time_posted,article_hits FROM carrotmatcat_board
) cb
INNER JOIN carrotmatcat_member cm ON cb.member_id = cm.member_id
WHERE rnum BETWEEN 1 AND 5
ORDER BY cb.article_no DESC;

SELECT * FROM carrotmatcat_board


