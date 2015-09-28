USE test;
DROP TABLE IF EXISTS user_t;
DROP TABLE IF EXISTS user_photo;

/**
 *  user table definition
 */

CREATE TABLE user_t (
  id INT (11) NOT NULL AUTO_INCREMENT COMMENT 'Unique registry identifier',
  user_name VARCHAR (40) NOT NULL,
  password VARCHAR (255) NOT NULL COMMENT 'Password hash code',
  age INT (4) NOT NULL,
  email VARCHAR (255) NOT NULL,
  photo VARCHAR (1024),
  PRIMARY KEY (id)
) ENGINE = INNODB AUTO_INCREMENT = 2 DEFAULT CHARSET = utf8;

 /**
 * user photo table definition
 */
CREATE TABLE
    user_photo
    (
        -- Common:
        id      INTEGER        NOT NULL AUTO_INCREMENT  COMMENT 'Unique registry identifier',
        active  BOOLEAN        NOT NULL DEFAULT TRUE    COMMENT 'Virtual deletion flag',
        PRIMARY KEY (id),
        -- /Common

        content mediumblob            NOT NULL,
        content_type VARCHAR(64)      NOT NULL,
        user_id INTEGER               NOT NULL,

        -- Constraints
        FOREIGN KEY (user_id) REFERENCES user_t (id),
        UNIQUE (active, user_id)
    )
    -- do not use MyIsam coz it does not support transactions
    ENGINE=InnoDB CHARACTER SET latin1 COLLATE latin1_general_ci,
    COMMENT='Stores user photo.';
  
  
