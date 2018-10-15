CREATE TABLE todo(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR (255),
    status VARCHAR (255),
    due_date DATE,
    tags VARCHAR (255),
    user_id bigint
)engine=InnoDB DEFAULT CHARSET=gbk;




