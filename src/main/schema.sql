CREATE TABLE category
(
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    category_name VARCHAR(255)
);
CREATE TABLE hall
(
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    is_active BIT,
    name VARCHAR(255),
    xlength INT,
    ylength INT
);
CREATE TABLE movie
(
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    is_active BIT,
    description VARCHAR(255),
    filmweb_grade REAL,
    length INT,
    minimum_age INT,
    title VARCHAR(255),
    viewers_grade REAL,
    category_id BIGINT
);
CREATE TABLE reservation
(
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    email VARCHAR(255),
    is_finalized BIT,
    name VARCHAR(255),
    phone VARCHAR(255),
    reservation_state VARCHAR(255),
    seat_count INT,
    surname VARCHAR(255),
    show_id BIGINT
);
CREATE TABLE seat
(
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    row_number INT,
    seat_number INT,
    xposition INT,
    yposition INT,
    hall_id BIGINT
);
CREATE TABLE seatreservation
(
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    reservation_id BIGINT,
    seat_id BIGINT,
    show_id BIGINT
);
CREATE TABLE showing
(
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    show_date DATETIME,
    show_hour TIME,
    hall_id BIGINT,
    movie_id BIGINT
);
CREATE TABLE user
(
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    email VARCHAR(255),
    login VARCHAR(255),
    name VARCHAR(255),
    password VARCHAR(255),
    surname VARCHAR(255)
);

CREATE UNIQUE INDEX UK_lroeo5fvfdeg4hpicn4lw7x9b ON category (category_name);
ALTER TABLE movie ADD FOREIGN KEY (category_id) REFERENCES category (id);
CREATE INDEX FK_dwm65tb1coltr8gwc6at24jrm ON movie (category_id);
ALTER TABLE reservation ADD FOREIGN KEY (show_id) REFERENCES showing (id);
CREATE INDEX FK_r6pumwbrecqq72uojd6o556bk ON reservation (show_id);
ALTER TABLE seat ADD FOREIGN KEY (hall_id) REFERENCES hall (id);
CREATE INDEX FK_3v9gef03uuss9g253pb5tkxh0 ON seat (hall_id);
ALTER TABLE seatreservation ADD FOREIGN KEY (show_id) REFERENCES showing (id);
ALTER TABLE seatreservation ADD FOREIGN KEY (reservation_id) REFERENCES reservation (id);
ALTER TABLE seatreservation ADD FOREIGN KEY (seat_id) REFERENCES seat (id);
CREATE INDEX FK_47v6kq42y4klognpn1y786xhe ON seatreservation (reservation_id);
CREATE INDEX FK_880vuoveo65twd9ywcby8l41 ON seatreservation (show_id);
CREATE INDEX FK_eaaky9boy4sxjj6u6bd8ycinf ON seatreservation (seat_id);
ALTER TABLE showing ADD FOREIGN KEY (movie_id) REFERENCES movie (id);
ALTER TABLE showing ADD FOREIGN KEY (hall_id) REFERENCES hall (id);
CREATE INDEX FK_9qrnaycjlyfti4lc36rpju9ah ON showing (movie_id);
CREATE INDEX FK_kl9a4aylv4s4scvhmwc605rj5 ON showing (hall_id);
