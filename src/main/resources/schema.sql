DROP TABLE IF EXISTS Segmentations;
DROP TABLE IF EXISTS Ads;

CREATE TABLE IF NOT EXISTS Segmentations (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	country VARCHAR(250),
	age VARCHAR(250),
	gender VARCHAR(250)
	);

CREATE TABLE IF NOT EXISTS Ads (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	printing_cost DOUBLE NOT NULL,
	max_printing_cost DOUBLE NOT NULL,
	end_date DATE NOT NULL,
	registered BOOLEAN NOT NULL,
	segmentation_id BIGINT,
	title VARCHAR(250) NOT NULL,
	description VARCHAR(250),
	FOREIGN KEY (segmentation_id) REFERENCES segmentations(id)
	);
	
--INSERT INTO Segmentations (id, country, age, gender) VALUES
--    (1, 'England', 38, 'Male'),
--    (2, 'Japan', 26, 'Male'),
--    (3, 'USA', 0, 'Male'),
--    (4, 'Poland', 5, 'Male'),
--    (5, 'Japan', 5, 'Male'),
--    (6, 'Japan', 3, 'Male');
--
--INSERT INTO Ads (id, printing_cost, max_printing_cost, end_date, registered, segmentation_id, title, description) VALUES
--    (1, 100, 150, '2020-10-25', true, 1, 'Football Manager 2020', 'Simulator'),
--    (2, 150, 200, CURRENT_TIMESTAMP, true, 2, 'Final Fantasy VI', 'RPG'),
--    (3, 300, 350, '2020-10-25', true, 3, 'Mafia Definitive Edition', 'Action-Adventure'),
--    (4, 500, 550, '2020-10-25', true, 4, 'The Witcher 3', 'Action RPG'),
--    (5, 1000, 1050, '2020-10-25', true, 5, 'Saint Seiya Soldier''s Soul', 'Fight'),
--    (6, 500, 600, '2020-10-25', false, null, 'Age of Empires Definitive Edition', 'RTS'),
--    (7, 700, 800, '2020-10-25', true, 6, 'Marvel vs Capcom: Infinite', 'Fight');