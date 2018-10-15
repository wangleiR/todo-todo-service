CREATE TABLE tag(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id bigint,
    value VARCHAR (255),
    label VARCHAR (255)
)engine=InnoDB DEFAULT CHARSET=gbk;

