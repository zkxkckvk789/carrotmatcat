CREATE TABLE carrotmatcat_likes(
	article_no NUMBER NOT NULL,
	member_id VARCHAR2(100) NOT NULL,
	CONSTRAINT likes_article_no_fk FOREIGN KEY (article_no) REFERENCES carrotmatcat_board(article_no) ON DELETE CASCADE,
    CONSTRAINT likes_member_id_fk FOREIGN KEY (member_id) REFERENCES carrotmatcat_member(member_id) ON DELETE CASCADE,
    CONSTRAINT carrotmatcat_likes_pk PRIMARY KEY (article_no, member_id)
)

DROP TABLE carrotmatcat_likes;

-- 좋아요 추가
INSERT INTO carrotmatcat_likes VALUES(101, 'yerin0110');
INSERT INTO carrotmatcat_likes VALUES(6, 'yerin0110');
INSERT INTO carrotmatcat_likes VALUES(200, 'yerin0110');


-- 좋아요 삭제
DELETE FROM carrotmatcat_likes WHERE article_no='1' AND member_id='javaking';

--
SELECT COUNT(*) FROM carrotmatcat_likes WHERE member_id='hasense9410';

--
SELECT cl.article_no
FROM carrotmatcat_likes cl
LEFT JOIN carrotmatcat_board cb
ON cl.article_no=cb.article_no
WHERE cl.member_id='yerin0110';

--총 좋아요 수 조회
SELECT COUNT(*) FROM carrotmatcat_likes WHERE article_no=1;

SELECT article_no FROM carrotmatcat_likes
WHERE member_id='yerin0110' AND article_no=101;

SELECT * FROM carrotmatcat_likes;

