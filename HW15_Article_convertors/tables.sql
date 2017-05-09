
CREATE TABLE users(
    id BIGSERIAL PRIMARY KEY,
    login VARCHAR(128) NOT NULL,
    password VARCHAR(128) NOT NULL,
    email VARCHAR(128),
    name VARCHAR(128),
    lastname VARCHAR(128),
    sex INTEGER
);



CREATE TABLE languages(
    id BIGSERIAL PRIMARY KEY,
    system_name VARCHAR(16),
    name VARCHAR(64)
);

CREATE TABLE articles(
    id BIGSERIAL PRIMARY KEY,
    slug VARCHAR(128),
    title VARCHAR(128),
    content TEXT,
    language_id BIGINT,
    user_id BIGINT,
    CONSTRAINT fk_articles_languages FOREIGN KEY (language_id) REFERENCES languages(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_articles_users FOREIGN KEY (user_id) REFERENCES users(id)
);

INSERT INTO users (login, password, email, name, lastname, sex) VALUES ('admin', '25d55ad283aa400af464c76d713c07ad', 'admin@gamil.com', 'admin', 'super', 1);
