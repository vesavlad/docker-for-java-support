CREATE TABLE IF NOT EXISTS image
(
    id         INT PRIMARY KEY,
    image_name VARCHAR(255) NOT NULL
);

CREATE SEQUENCE IF NOT EXISTS image_seq
    AS INT
    INCREMENT BY 1
    OWNED BY image.id
;

CREATE TABLE IF NOT EXISTS container
(
    id             INT PRIMARY KEY,
    image_id       INT          NOT NULL,
    container_name VARCHAR(255) NOT NULL,
    FOREIGN KEY (image_id) REFERENCES image (id)
);

CREATE SEQUENCE IF NOT EXISTS container_seq
    AS INT
    INCREMENT BY 1
    OWNED BY container.id
;
