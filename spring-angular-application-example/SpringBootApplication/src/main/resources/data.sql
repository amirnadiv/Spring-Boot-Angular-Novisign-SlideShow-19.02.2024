Create TABLE users (
    id INT NOT NULL AUTO_INCREMENT,
    FIRSTNAME VARCHAR(100) NOT NULL,
    LASTNAME VARCHAR(100) NOT NULL,
    USERNAME VARCHAR(100) NOT NULL,
    PASSWORD VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);
INSERT INTO users (ID,FIRSTNAME,LASTNAME,USERNAME, PASSWORD) VALUES (1,'amir','nadiv','amir',1);
INSERT INTO users (ID,FIRSTNAME,LASTNAME,USERNAME, PASSWORD) VALUES (2,'keren','nadiv','keren',1);
