-- member 테이블 생성
CREATE TABLE carrotmatcat_member(
	member_id VARCHAR2(100) PRIMARY KEY,
	member_password VARCHAR2(100) NOT NULL,
	member_nickname VARCHAR2(100) NOT NULL
)

-- insert 회원 등록 (회원가입)
INSERT INTO carrotmatcat_member(member_id,member_password,member_nickname)
VALUES('yerin0110', '9697', '공주');
INSERT INTO carrotmatcat_member(member_id,member_password,member_nickname)
VALUES('chaeeunseo', '1111', '채콩그자체');
INSERT INTO carrotmatcat_member(member_id,member_password,member_nickname)
VALUES('zkxkckvk', '7777', '봉태식');
INSERT INTO carrotmatcat_member(member_id,member_password,member_nickname)
VALUES('hasense9410', 'babbab', '하센세');
INSERT INTO carrotmatcat_member(member_id,member_password,member_nickname)
VALUES('kimyunsooooo', '1234', '윤탱');

INSERT INTO carrotmatcat_member(member_id,member_password,member_nickname)
VALUES(?,?,?);

--update 회원 수정
-- member_id -> readonly
UPDATE carrotmatcat_member SET member_nickname='예린공주' WHERE member_nickname='공주';
UPDATE carrotmatcat_member SET member_nickname=?, member_password=? WHERE member_id=?;

-- delete 회원 삭제
DELETE FROM carrotmatcat_member WHERE member_id='yerin0110';
DELETE FROM carrotmatcat_member WHERE member_id=?;

--login
SELECT member_id,member_nickname FROM carrotmatcat_member WHERE member_id='yerin0110' AND member_password='9697';
SELECT member_id,member_nickname FROM carrotmatcat_member WHERE member_id=? AND member_password=?;

--checkDuplicateId
SELECT COUNT(*) FROM carrotmatcat_member WHERE member_id='yerin0110';
SELECT COUNT(*) FROM carrotmatcat_member WHERE member_id=?;

--checkDuplicateNickname
SELECT COUNT(*) FROM carrotmatcat_member WHERE member_nickname='예린공주';
SELECT COUNT(*) FROM carrotmatcat_member WHERE member_nickname=?

COMMIT;
SELECT * FROM carrotmatcat_member;