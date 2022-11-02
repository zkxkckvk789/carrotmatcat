CREATE TABLE carrotmatcat_likes(
	article_no NUMBER NOT NULL,
	member_id VARCHAR2(100) NOT NULL,
	CONSTRAINT likes_article_no_fk FOREIGN KEY (article_no) REFERENCES carrotmatcat_board(article_no),
    CONSTRAINT likes_member_id_fk FOREIGN KEY (member_id) REFERENCES carrotmatcat_member(member_id),
    CONSTRAINT carrotmatcat_likes_pk PRIMARY KEY (article_no, member_id)
)

INSERT INTO carrotmatcat_likes VALUES(1, 'yerin0110');

<<<<<<< HEAD
=======
SELECT * FROM carrotmatcat_likes;
>>>>>>> refs/heads/model-VO-ces1102
