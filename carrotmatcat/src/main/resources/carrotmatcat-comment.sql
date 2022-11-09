-- carrotmatcat_comment 댓글 테이블 생성
CREATE TABLE carrotmatcat_comment(
	comment_no NUMBER PRIMARY KEY,
	comment_content CLOB NOT NULL,
	comment_time_posted DATE NOT NULL,
	article_no NUMBER NOT NULL,
	member_id VARCHAR2(100) NOT NULL,
	CONSTRAINT comment_article_no_fk FOREIGN KEY(article_no) REFERENCES carrotmatcat_board(article_no),
	CONSTRAINT comment_member_id_fk FOREIGN KEY(member_id) REFERENCES carrotmatcat_member(member_id)
)

--테이블 제약조건 수정(이미 생성된 CONSTRAINT 삭제 후 새로운 CONSTRAINT 생성)
ALTER TABLE carrotmatcat_comment DROP CONSTRAINT comment_article_no_fk;
ALTER TABLE carrotmatcat_comment ADD CONSTRAINT comment_article_no_fk foreign KEY (article_no) REFERENCES carrotmatcat_board(article_no) ON DELETE CASCADE;

CREATE SEQUENCE carrotmatcat_comment_seq;
DROP SEQUENCE carrotmatcat_comment_seq;

-- 댓글 등록
INSERT INTO carrotmatcat_comment(comment_no, comment_content, comment_time_posted, article_no, member_id)
VALUES(carrotmatcat_comment_seq.nextval, '공감합니다', SYSDATE, 39, 'chaeeunseo');

INSERT INTO carrotmatcat_comment(comment_no, comment_content, comment_time_posted, article_no, member_id)
VALUES(carrotmatcat_comment_seq.nextval, '맛있겠어요', SYSDATE, 2, 'hasense9410');

commit

SELECT * FROM carrotmatcat_comment

-- 댓글 보여줄때 조회
SELECT cc.comment_no,cm.member_nickname, cc.comment_content, TO_CHAR(cc.comment_time_posted,'YYYY.MM.DD HH:MM') AS comment_time_posted
FROM carrotmatcat_comment  cc
INNER JOIN carrotmatcat_member cm ON cc.member_id = cm.member_id
INNER JOIN carrotmatcat_board cb ON cb.article_no = cc.article_no
WHERE cc.article_no='1';

--댓글 삭제
DELETE FROM carrotmatcat_comment;

-- 댓글 수정
UPDATE carrotmatcat_comment SET comment_content='공감하지않습니다' WHERE comment_no=1;


