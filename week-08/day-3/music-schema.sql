# MUSIC DATABASE

# TABLES
-- label
-- history
-- artist
-- album
-- song

# RELATIONSHIPS
-- label-to-label-history = one-to-one
-- label-to-artist = one-to-many
-- artist-to-album = many-to-many
-- album-to-song = one-to-many

# TABLE CREATION ORDER
-- you have to start with tables that DO NOT contain any foreign keys pointing to other tables
-- you can't create a foreign key pointing to another table that doesn't exist

CREATE SCHEMA `music`;

CREATE TABLE `music`.`label` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `label_name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `label_name_UNIQUE` (`label_name` ASC) VISIBLE);
  
CREATE TABLE `music`.`label_history` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `history` VARCHAR(1000) NOT NULL,
  `label_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `label_history_to_label_idx` (`label_id` ASC) VISIBLE,
  CONSTRAINT `label_history_to_label`
    FOREIGN KEY (`label_id`)
    REFERENCES `music`.`label` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
  
CREATE TABLE `music`.`artist` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `artist_name` VARCHAR(100) NOT NULL,
  `label_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `label_id1_idx` (`label_id` ASC) VISIBLE,
  CONSTRAINT `label_id1`
    FOREIGN KEY (`label_id`)
    REFERENCES `music`.`label` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE);

CREATE TABLE `music`.`album` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `album_name` VARCHAR(100) NOT NULL,
  `release_year` YEAR NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `music`.`song` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `song_name` VARCHAR(100) NOT NULL,
  `album_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `album_id1_idx` (`album_id` ASC) VISIBLE,
  CONSTRAINT `album_id1`
    FOREIGN KEY (`album_id`)
    REFERENCES `music`.`album` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `music`.`artist_albums_album` (
  `artist_id` INT NOT NULL,
  `album_id` INT NOT NULL,
  PRIMARY KEY (`artist_id`, `album_id`),
  INDEX `album_id2_idx` (`album_id` ASC) VISIBLE,
  CONSTRAINT `artist_id1`
    FOREIGN KEY (`artist_id`)
    REFERENCES `music`.`artist` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `album_id2`
    FOREIGN KEY (`album_id`)
    REFERENCES `music`.`album` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
INSERT INTO music.label (label_name) VALUES ('Connelly, Kilback and Lockman');
INSERT INTO music.label (label_name) VALUES ('Kemmer, Nicolas and Connelly');
INSERT INTO music.label (label_name) VALUES ('Parisian LLC');
INSERT INTO music.label (label_name) VALUES ('Waelchi, Lind and Monahan');
INSERT INTO music.label (label_name) VALUES ('McGlynn LLC');
INSERT INTO music.label (label_name) VALUES ('Ruecker-Mills');
INSERT INTO music.label (label_name) VALUES ('McDermott, Kautzer and Gislason');
INSERT INTO music.label (label_name) VALUES ('Kub-Senger');
INSERT INTO music.label (label_name) VALUES ('Kub and Sons');
INSERT INTO music.label (label_name) VALUES ('Bashirian, Schumm and Kautzer');

INSERT INTO music.label_history (history, label_id) VALUES ('Unspecified schizophrenia, subchronic', 1);
INSERT INTO music.label_history (history, label_id) VALUES ('Yaba monkey tumor virus', 2);
INSERT INTO music.label_history (history, label_id) VALUES ('Polyneuropathy due to other toxic agents', 3);
INSERT INTO music.label_history (history, label_id) VALUES ('Insect bite, nonvenomous of face, neck, and scalp except eye, without mention of infection', 4);
INSERT INTO music.label_history (history, label_id) VALUES ('Localized vascularization of cornea', 5);
INSERT INTO music.label_history (history, label_id) VALUES ('Toxic effect of unspecified gas, fume, or vapor', 6);
INSERT INTO music.label_history (history, label_id) VALUES ('Malignant neoplasm of palate, unspecified', 7);
INSERT INTO music.label_history (history, label_id) VALUES ('Satisfactory cervical smear but lacking transformation zone', 8);
INSERT INTO music.label_history (history, label_id) VALUES ('Tetanic cataract', 9);
INSERT INTO music.label_history (history, label_id) VALUES ('Multiple myeloma, in remission', 10);

INSERT INTO music.artist (artist_name, label_id) VALUES ('Toiboid Massingberd', 7);
INSERT INTO music.artist (artist_name, label_id) VALUES ('Shandra Abreheart', 7);
INSERT INTO music.artist (artist_name, label_id) VALUES ('Husain Maltman', 5);
INSERT INTO music.artist (artist_name, label_id) VALUES ('Valaria Haggarth', 8);
INSERT INTO music.artist (artist_name, label_id) VALUES ('Alayne Lovemore', 6);
INSERT INTO music.artist (artist_name, label_id) VALUES ('Dean Fillingham', 10);
INSERT INTO music.artist (artist_name, label_id) VALUES ('Juliana Stopps', 3);
INSERT INTO music.artist (artist_name, label_id) VALUES ('Alisa Oiseau', 9);
INSERT INTO music.artist (artist_name, label_id) VALUES ('Byran Thorneloe', 5);
INSERT INTO music.artist (artist_name, label_id) VALUES ('Rowan McLaggan', 2);
INSERT INTO music.artist (artist_name, label_id) VALUES ('Nial Ropartz', 6);
INSERT INTO music.artist (artist_name, label_id) VALUES ('Adriaens Rodgerson', 3);
INSERT INTO music.artist (artist_name, label_id) VALUES ('Delcine Darley', 1);
INSERT INTO music.artist (artist_name, label_id) VALUES ('Charmain Patriche', 6);
INSERT INTO music.artist (artist_name, label_id) VALUES ('Lisette MacTrustey', 7);
INSERT INTO music.artist (artist_name, label_id) VALUES ('Kirbie Seyers', 10);
INSERT INTO music.artist (artist_name, label_id) VALUES ('Rusty Fulkes', 9);
INSERT INTO music.artist (artist_name, label_id) VALUES ('Clareta Padly', 5);
INSERT INTO music.artist (artist_name, label_id) VALUES ('Tobit Wallage', 6);
INSERT INTO music.artist (artist_name, label_id) VALUES ('Allix Bellino', 1);

INSERT INTO music.album (album_name, release_year) VALUES ('Cloudswept Colicwood', 2009);
INSERT INTO music.album (album_name, release_year) VALUES ('Fox Grape', 2012);
INSERT INTO music.album (album_name, release_year) VALUES ('Red Mallee', 2008);
INSERT INTO music.album (album_name, release_year) VALUES ('Orcutt Grass', 1994);
INSERT INTO music.album (album_name, release_year) VALUES ('Porter''s Licorice-root', 2007);
INSERT INTO music.album (album_name, release_year) VALUES ('Seaside Joyweed', 2007);
INSERT INTO music.album (album_name, release_year) VALUES ('Athel Tamarisk', 2005);
INSERT INTO music.album (album_name, release_year) VALUES ('Hawai''i Scaleseed', 2009);
INSERT INTO music.album (album_name, release_year) VALUES ('Sweetclover', 1994);
INSERT INTO music.album (album_name, release_year) VALUES ('Queen Sago', 2009);
INSERT INTO music.album (album_name, release_year) VALUES ('Bog Cyrtandra', 2010);
INSERT INTO music.album (album_name, release_year) VALUES ('Aster', 1997);
INSERT INTO music.album (album_name, release_year) VALUES ('Hawai''i False Nettle', 1996);
INSERT INTO music.album (album_name, release_year) VALUES ('Hazel Alder', 1989);
INSERT INTO music.album (album_name, release_year) VALUES ('Swampmallow', 1994);
INSERT INTO music.album (album_name, release_year) VALUES ('Foothill Larkspur', 2009);
INSERT INTO music.album (album_name, release_year) VALUES ('Jamaican Goldback Fern', 1999);
INSERT INTO music.album (album_name, release_year) VALUES ('Bulrush', 2004);
INSERT INTO music.album (album_name, release_year) VALUES ('Waterhyssop', 1994);
INSERT INTO music.album (album_name, release_year) VALUES ('Dwarf Brodiaea', 1997);
INSERT INTO music.album (album_name, release_year) VALUES ('Stinking Milkvetch', 2003);
INSERT INTO music.album (album_name, release_year) VALUES ('Rim Lichen', 2007);
INSERT INTO music.album (album_name, release_year) VALUES ('Fissure Dot Lichen', 2011);
INSERT INTO music.album (album_name, release_year) VALUES ('Heath Teatree', 2012);
INSERT INTO music.album (album_name, release_year) VALUES ('Algarrobilla', 2009);
INSERT INTO music.album (album_name, release_year) VALUES ('Tundra Aster', 2012);
INSERT INTO music.album (album_name, release_year) VALUES ('Nadvornik''s Horsehair Lichen', 1999);
INSERT INTO music.album (album_name, release_year) VALUES ('Thick Ditch Crowngrass', 2008);
INSERT INTO music.album (album_name, release_year) VALUES ('Ocellularia Lichen', 1994);
INSERT INTO music.album (album_name, release_year) VALUES ('Milk-berry', 2007);
INSERT INTO music.album (album_name, release_year) VALUES ('Waianae Range Pepperwort', 2009);
INSERT INTO music.album (album_name, release_year) VALUES ('Plumed Rockcap Fern', 1988);
INSERT INTO music.album (album_name, release_year) VALUES ('Mountain Clearweed', 2002);
INSERT INTO music.album (album_name, release_year) VALUES ('Smith''s Draba', 2006);
INSERT INTO music.album (album_name, release_year) VALUES ('Jelutong', 1985);
INSERT INTO music.album (album_name, release_year) VALUES ('Balsam Of Peru', 2002);
INSERT INTO music.album (album_name, release_year) VALUES ('Cardinal Catchfly', 1995);
INSERT INTO music.album (album_name, release_year) VALUES ('St. Thomas Tree', 1970);
INSERT INTO music.album (album_name, release_year) VALUES ('Queen''s-delight', 1996);
INSERT INTO music.album (album_name, release_year) VALUES ('Field Restharrow', 2003);

INSERT INTO music.song (song_name, album_id) VALUES ('Snake, green vine', 23);
INSERT INTO music.song (song_name, album_id) VALUES ('Blue and yellow macaw', 4);
INSERT INTO music.song (song_name, album_id) VALUES ('Cape wild cat', 10);
INSERT INTO music.song (song_name, album_id) VALUES ('Dolphin, bottle-nose', 14);
INSERT INTO music.song (song_name, album_id) VALUES ('Cardinal, red-capped', 22);
INSERT INTO music.song (song_name, album_id) VALUES ('Bleeding heart monkey', 8);
INSERT INTO music.song (song_name, album_id) VALUES ('Common genet', 9);
INSERT INTO music.song (song_name, album_id) VALUES ('Southern boubou', 36);
INSERT INTO music.song (song_name, album_id) VALUES ('Raven, cape', 19);
INSERT INTO music.song (song_name, album_id) VALUES ('Monitor, water', 11);
INSERT INTO music.song (song_name, album_id) VALUES ('Gecko, tokay', 14);
INSERT INTO music.song (song_name, album_id) VALUES ('Lion, southern sea', 30);
INSERT INTO music.song (song_name, album_id) VALUES ('Cat, long-tailed spotted', 28);
INSERT INTO music.song (song_name, album_id) VALUES ('Possum, western pygmy', 13);
INSERT INTO music.song (song_name, album_id) VALUES ('Southern boubou', 14);
INSERT INTO music.song (song_name, album_id) VALUES ('Heron, little', 2);
INSERT INTO music.song (song_name, album_id) VALUES ('Azara''s zorro', 16);
INSERT INTO music.song (song_name, album_id) VALUES ('Steenbuck', 22);
INSERT INTO music.song (song_name, album_id) VALUES ('Asian openbill', 9);
INSERT INTO music.song (song_name, album_id) VALUES ('Green vine snake', 29);
INSERT INTO music.song (song_name, album_id) VALUES ('Field flicker', 40);
INSERT INTO music.song (song_name, album_id) VALUES ('Lizard, mexican beaded', 10);
INSERT INTO music.song (song_name, album_id) VALUES ('Springbok', 5);
INSERT INTO music.song (song_name, album_id) VALUES ('Adouri (unidentified)', 7);
INSERT INTO music.song (song_name, album_id) VALUES ('Bettong, brush-tailed', 28);
INSERT INTO music.song (song_name, album_id) VALUES ('South American puma', 34);
INSERT INTO music.song (song_name, album_id) VALUES ('Lava gull', 10);
INSERT INTO music.song (song_name, album_id) VALUES ('Eastern box turtle', 27);
INSERT INTO music.song (song_name, album_id) VALUES ('Red deer', 20);
INSERT INTO music.song (song_name, album_id) VALUES ('Rufous tree pie', 24);
INSERT INTO music.song (song_name, album_id) VALUES ('Bee-eater (unidentified)', 38);
INSERT INTO music.song (song_name, album_id) VALUES ('Baleen whale', 40);
INSERT INTO music.song (song_name, album_id) VALUES ('Red and blue macaw', 6);
INSERT INTO music.song (song_name, album_id) VALUES ('Great egret', 5);
INSERT INTO music.song (song_name, album_id) VALUES ('Prairie falcon', 12);
INSERT INTO music.song (song_name, album_id) VALUES ('Malagasy ground boa', 23);
INSERT INTO music.song (song_name, album_id) VALUES ('Steller''s sea lion', 31);
INSERT INTO music.song (song_name, album_id) VALUES ('Koala', 20);
INSERT INTO music.song (song_name, album_id) VALUES ('Nile crocodile', 9);
INSERT INTO music.song (song_name, album_id) VALUES ('Hyena, spotted', 7);
INSERT INTO music.song (song_name, album_id) VALUES ('Western bearded dragon', 33);
INSERT INTO music.song (song_name, album_id) VALUES ('Brown pelican', 24);
INSERT INTO music.song (song_name, album_id) VALUES ('African darter', 10);
INSERT INTO music.song (song_name, album_id) VALUES ('Bee-eater, carmine', 20);
INSERT INTO music.song (song_name, album_id) VALUES ('Great kiskadee', 15);
INSERT INTO music.song (song_name, album_id) VALUES ('White stork', 39);
INSERT INTO music.song (song_name, album_id) VALUES ('Dove, galapagos', 3);
INSERT INTO music.song (song_name, album_id) VALUES ('Green-winged macaw', 30);
INSERT INTO music.song (song_name, album_id) VALUES ('Brown brocket', 6);
INSERT INTO music.song (song_name, album_id) VALUES ('Water legaan', 4);
INSERT INTO music.song (song_name, album_id) VALUES ('Kangaroo, black-faced', 12);
INSERT INTO music.song (song_name, album_id) VALUES ('Euro wallaby', 9);
INSERT INTO music.song (song_name, album_id) VALUES ('Mongoose, javan gold-spotted', 13);
INSERT INTO music.song (song_name, album_id) VALUES ('Deer, savannah', 23);
INSERT INTO music.song (song_name, album_id) VALUES ('Rhesus macaque', 25);
INSERT INTO music.song (song_name, album_id) VALUES ('Hawk, ferruginous', 5);
INSERT INTO music.song (song_name, album_id) VALUES ('Spotted-tailed quoll', 19);
INSERT INTO music.song (song_name, album_id) VALUES ('Raven, white-necked', 22);
INSERT INTO music.song (song_name, album_id) VALUES ('Fat-tailed dunnart', 29);
INSERT INTO music.song (song_name, album_id) VALUES ('Kafue flats lechwe', 5);
INSERT INTO music.song (song_name, album_id) VALUES ('Cat, african wild', 11);
INSERT INTO music.song (song_name, album_id) VALUES ('Bee-eater, nubian', 28);
INSERT INTO music.song (song_name, album_id) VALUES ('Feathertail glider', 25);
INSERT INTO music.song (song_name, album_id) VALUES ('Giant otter', 18);
INSERT INTO music.song (song_name, album_id) VALUES ('Stork, white-necked', 18);
INSERT INTO music.song (song_name, album_id) VALUES ('Barrows goldeneye', 8);
INSERT INTO music.song (song_name, album_id) VALUES ('Asian water dragon', 16);
INSERT INTO music.song (song_name, album_id) VALUES ('Indian leopard', 4);
INSERT INTO music.song (song_name, album_id) VALUES ('Indian jackal', 19);
INSERT INTO music.song (song_name, album_id) VALUES ('Bear, polar', 28);
INSERT INTO music.song (song_name, album_id) VALUES ('Cuis', 23);
INSERT INTO music.song (song_name, album_id) VALUES ('Prairie falcon', 23);
INSERT INTO music.song (song_name, album_id) VALUES ('Flamingo, greater', 7);
INSERT INTO music.song (song_name, album_id) VALUES ('Beisa oryx', 32);
INSERT INTO music.song (song_name, album_id) VALUES ('Robin, kalahari scrub', 13);
INSERT INTO music.song (song_name, album_id) VALUES ('Black-tailed prairie dog', 26);
INSERT INTO music.song (song_name, album_id) VALUES ('Peccary, collared', 24);
INSERT INTO music.song (song_name, album_id) VALUES ('Cormorant, flightless', 5);
INSERT INTO music.song (song_name, album_id) VALUES ('Bleeding heart monkey', 21);
INSERT INTO music.song (song_name, album_id) VALUES ('Galapagos albatross', 35);
INSERT INTO music.song (song_name, album_id) VALUES ('Cape clawless otter', 27);
INSERT INTO music.song (song_name, album_id) VALUES ('Rhinoceros, square-lipped', 34);
INSERT INTO music.song (song_name, album_id) VALUES ('Rainbow lory', 7);
INSERT INTO music.song (song_name, album_id) VALUES ('Starling, greater blue-eared', 18);
INSERT INTO music.song (song_name, album_id) VALUES ('Red-winged blackbird', 29);
INSERT INTO music.song (song_name, album_id) VALUES ('Skua, long-tailed', 28);
INSERT INTO music.song (song_name, album_id) VALUES ('Armadillo, nine-banded', 38);
INSERT INTO music.song (song_name, album_id) VALUES ('Tokay gecko', 23);
INSERT INTO music.song (song_name, album_id) VALUES ('Bushpig', 10);
INSERT INTO music.song (song_name, album_id) VALUES ('Red-capped cardinal', 17);
INSERT INTO music.song (song_name, album_id) VALUES ('White stork', 29);
INSERT INTO music.song (song_name, album_id) VALUES ('Lion, asian', 28);
INSERT INTO music.song (song_name, album_id) VALUES ('Beaver, eurasian', 38);
INSERT INTO music.song (song_name, album_id) VALUES ('Red-tailed cockatoo', 29);
INSERT INTO music.song (song_name, album_id) VALUES ('Hyena, striped', 2);
INSERT INTO music.song (song_name, album_id) VALUES ('Seal, common', 3);
INSERT INTO music.song (song_name, album_id) VALUES ('Wild water buffalo', 36);
INSERT INTO music.song (song_name, album_id) VALUES ('Helmeted guinea fowl', 17);
INSERT INTO music.song (song_name, album_id) VALUES ('Stork, openbill', 18);
INSERT INTO music.song (song_name, album_id) VALUES ('Capuchin, brown', 6);
INSERT INTO music.song (song_name, album_id) VALUES ('Iguana, land', 35);
INSERT INTO music.song (song_name, album_id) VALUES ('Lizard, frilled', 32);
INSERT INTO music.song (song_name, album_id) VALUES ('Goldeneye, barrows', 27);
INSERT INTO music.song (song_name, album_id) VALUES ('Asiatic jackal', 14);
INSERT INTO music.song (song_name, album_id) VALUES ('Stork, saddle-billed', 30);
INSERT INTO music.song (song_name, album_id) VALUES ('Raccoon, crab-eating', 11);
INSERT INTO music.song (song_name, album_id) VALUES ('Weaver, lesser masked', 32);
INSERT INTO music.song (song_name, album_id) VALUES ('Columbian rainbow boa', 35);
INSERT INTO music.song (song_name, album_id) VALUES ('Coqui francolin', 11);
INSERT INTO music.song (song_name, album_id) VALUES ('Jackal, asiatic', 25);
INSERT INTO music.song (song_name, album_id) VALUES ('Emu', 3);
INSERT INTO music.song (song_name, album_id) VALUES ('Spotted wood sandpiper', 24);
INSERT INTO music.song (song_name, album_id) VALUES ('Amazon parrot (unidentified)', 22);
INSERT INTO music.song (song_name, album_id) VALUES ('Toucan, white-throated', 10);
INSERT INTO music.song (song_name, album_id) VALUES ('Eurasian hoopoe', 30);
INSERT INTO music.song (song_name, album_id) VALUES ('Parrot, hawk-headed', 39);
INSERT INTO music.song (song_name, album_id) VALUES ('Vulture, bengal', 21);
INSERT INTO music.song (song_name, album_id) VALUES ('Deer, roe', 8);
INSERT INTO music.song (song_name, album_id) VALUES ('Porcupine, tree', 9);
INSERT INTO music.song (song_name, album_id) VALUES ('Insect, stick', 6);
INSERT INTO music.song (song_name, album_id) VALUES ('Beaver, north american', 6);
INSERT INTO music.song (song_name, album_id) VALUES ('African elephant', 7);
INSERT INTO music.song (song_name, album_id) VALUES ('Little grebe', 7);
INSERT INTO music.song (song_name, album_id) VALUES ('Eagle, crowned', 20);
INSERT INTO music.song (song_name, album_id) VALUES ('Rhesus macaque', 32);
INSERT INTO music.song (song_name, album_id) VALUES ('Galapagos albatross', 33);
INSERT INTO music.song (song_name, album_id) VALUES ('Otter, oriental short-clawed', 31);
INSERT INTO music.song (song_name, album_id) VALUES ('Baboon, gelada', 19);
INSERT INTO music.song (song_name, album_id) VALUES ('Northern phalarope', 39);
INSERT INTO music.song (song_name, album_id) VALUES ('Bunting, crested', 32);
INSERT INTO music.song (song_name, album_id) VALUES ('Lizard, goanna', 18);
INSERT INTO music.song (song_name, album_id) VALUES ('Silver gull', 15);
INSERT INTO music.song (song_name, album_id) VALUES ('Sulfur-crested cockatoo', 7);
INSERT INTO music.song (song_name, album_id) VALUES ('Skua, great', 17);
INSERT INTO music.song (song_name, album_id) VALUES ('Goose, spur-winged', 13);
INSERT INTO music.song (song_name, album_id) VALUES ('Whale, killer', 21);
INSERT INTO music.song (song_name, album_id) VALUES ('Grant''s gazelle', 11);
INSERT INTO music.song (song_name, album_id) VALUES ('Blue-tongued lizard', 12);
INSERT INTO music.song (song_name, album_id) VALUES ('Richardson''s ground squirrel', 22);
INSERT INTO music.song (song_name, album_id) VALUES ('Fox, asian red', 27);
INSERT INTO music.song (song_name, album_id) VALUES ('Sage grouse', 5);
INSERT INTO music.song (song_name, album_id) VALUES ('Yellow mongoose', 15);
INSERT INTO music.song (song_name, album_id) VALUES ('Goose, snow', 22);
INSERT INTO music.song (song_name, album_id) VALUES ('Field flicker', 27);
INSERT INTO music.song (song_name, album_id) VALUES ('Campo flicker', 10);
INSERT INTO music.song (song_name, album_id) VALUES ('Brown hyena', 2);
INSERT INTO music.song (song_name, album_id) VALUES ('Giant armadillo', 12);
INSERT INTO music.song (song_name, album_id) VALUES ('Lesser flamingo', 1);
INSERT INTO music.song (song_name, album_id) VALUES ('Yellow-crowned night heron', 21);
INSERT INTO music.song (song_name, album_id) VALUES ('Crested bunting', 39);
INSERT INTO music.song (song_name, album_id) VALUES ('Swan, trumpeter', 23);
INSERT INTO music.song (song_name, album_id) VALUES ('White-necked raven', 37);
INSERT INTO music.song (song_name, album_id) VALUES ('Gecko, barking', 10);
INSERT INTO music.song (song_name, album_id) VALUES ('Cat, kaffir', 1);
INSERT INTO music.song (song_name, album_id) VALUES ('Stork, saddle-billed', 9);
INSERT INTO music.song (song_name, album_id) VALUES ('Euro wallaby', 8);
INSERT INTO music.song (song_name, album_id) VALUES ('Common zorro', 15);
INSERT INTO music.song (song_name, album_id) VALUES ('Bird, magnificent frigate', 13);
INSERT INTO music.song (song_name, album_id) VALUES ('Bulbul, black-fronted', 35);
INSERT INTO music.song (song_name, album_id) VALUES ('Galapagos albatross', 38);
INSERT INTO music.song (song_name, album_id) VALUES ('Kori bustard', 25);
INSERT INTO music.song (song_name, album_id) VALUES ('White-faced whistling duck', 35);
INSERT INTO music.song (song_name, album_id) VALUES ('Goose, cape barren', 18);
INSERT INTO music.song (song_name, album_id) VALUES ('Sociable weaver', 10);
INSERT INTO music.song (song_name, album_id) VALUES ('Porcupine, north american', 31);
INSERT INTO music.song (song_name, album_id) VALUES ('Bushpig', 31);
INSERT INTO music.song (song_name, album_id) VALUES ('Spoonbill, european', 28);
INSERT INTO music.song (song_name, album_id) VALUES ('Dolphin, bottle-nose', 6);
INSERT INTO music.song (song_name, album_id) VALUES ('Springbok', 1);
INSERT INTO music.song (song_name, album_id) VALUES ('Vine snake (unidentified)', 22);
INSERT INTO music.song (song_name, album_id) VALUES ('Water legaan', 6);
INSERT INTO music.song (song_name, album_id) VALUES ('Bird (unidentified)', 4);
INSERT INTO music.song (song_name, album_id) VALUES ('Cereopsis goose', 12);
INSERT INTO music.song (song_name, album_id) VALUES ('Cat, jungle', 3);
INSERT INTO music.song (song_name, album_id) VALUES ('Iguana, marine', 25);
INSERT INTO music.song (song_name, album_id) VALUES ('Aardwolf', 21);
INSERT INTO music.song (song_name, album_id) VALUES ('Little brown dove', 23);
INSERT INTO music.song (song_name, album_id) VALUES ('Rufous tree pie', 9);
INSERT INTO music.song (song_name, album_id) VALUES ('Cat, native', 29);
INSERT INTO music.song (song_name, album_id) VALUES ('Tortoise, burmese brown mountain', 15);
INSERT INTO music.song (song_name, album_id) VALUES ('Long-tailed spotted cat', 39);
INSERT INTO music.song (song_name, album_id) VALUES ('Baboon, savanna', 35);
INSERT INTO music.song (song_name, album_id) VALUES ('Gazelle, thomson''s', 36);
INSERT INTO music.song (song_name, album_id) VALUES ('Clark''s nutcracker', 23);
INSERT INTO music.song (song_name, album_id) VALUES ('Crow, house', 4);
INSERT INTO music.song (song_name, album_id) VALUES ('Peacock, indian', 7);
INSERT INTO music.song (song_name, album_id) VALUES ('Barasingha deer', 25);
INSERT INTO music.song (song_name, album_id) VALUES ('Stork, black-necked', 29);
INSERT INTO music.song (song_name, album_id) VALUES ('Savannah deer (unidentified)', 31);
INSERT INTO music.song (song_name, album_id) VALUES ('Crake, african black', 9);
INSERT INTO music.song (song_name, album_id) VALUES ('Gecko, bent-toed', 36);
INSERT INTO music.song (song_name, album_id) VALUES ('Carmine bee-eater', 30);
INSERT INTO music.song (song_name, album_id) VALUES ('Blackbird, red-winged', 36);
INSERT INTO music.song (song_name, album_id) VALUES ('Western lowland gorilla', 26);
INSERT INTO music.song (song_name, album_id) VALUES ('Colobus, black and white', 13);
INSERT INTO music.song (song_name, album_id) VALUES ('North American beaver', 29);
INSERT INTO music.song (song_name, album_id) VALUES ('Glider, squirrel', 4);
INSERT INTO music.song (song_name, album_id) VALUES ('Emu', 16);
INSERT INTO music.song (song_name, album_id) VALUES ('Roan antelope', 15);
INSERT INTO music.song (song_name, album_id) VALUES ('Crow, pied', 38);
INSERT INTO music.song (song_name, album_id) VALUES ('Puffin, horned', 8);
INSERT INTO music.song (song_name, album_id) VALUES ('Beaver, eurasian', 39);
INSERT INTO music.song (song_name, album_id) VALUES ('Toucan, white-throated', 29);
INSERT INTO music.song (song_name, album_id) VALUES ('Pocket gopher (unidentified)', 3);
INSERT INTO music.song (song_name, album_id) VALUES ('Brazilian otter', 7);
INSERT INTO music.song (song_name, album_id) VALUES ('Least chipmunk', 37);
INSERT INTO music.song (song_name, album_id) VALUES ('Green-winged trumpeter', 1);
INSERT INTO music.song (song_name, album_id) VALUES ('Snow goose', 37);
INSERT INTO music.song (song_name, album_id) VALUES ('Elephant, african', 4);
INSERT INTO music.song (song_name, album_id) VALUES ('Coqui francolin', 12);
INSERT INTO music.song (song_name, album_id) VALUES ('Hyrax', 9);
INSERT INTO music.song (song_name, album_id) VALUES ('Bleu, red-cheeked cordon', 9);
INSERT INTO music.song (song_name, album_id) VALUES ('Greylag goose', 36);
INSERT INTO music.song (song_name, album_id) VALUES ('Lion, steller''s sea', 15);
INSERT INTO music.song (song_name, album_id) VALUES ('Crane, sarus', 12);
INSERT INTO music.song (song_name, album_id) VALUES ('Goat, mountain', 20);
INSERT INTO music.song (song_name, album_id) VALUES ('Colobus, white-mantled', 6);
INSERT INTO music.song (song_name, album_id) VALUES ('Heron, yellow-crowned night', 39);
INSERT INTO music.song (song_name, album_id) VALUES ('Cormorant, pied', 32);
INSERT INTO music.song (song_name, album_id) VALUES ('Bahama pintail', 25);
INSERT INTO music.song (song_name, album_id) VALUES ('Long-tailed jaeger', 11);
INSERT INTO music.song (song_name, album_id) VALUES ('Yellow-throated sandgrouse', 12);
INSERT INTO music.song (song_name, album_id) VALUES ('American badger', 23);
INSERT INTO music.song (song_name, album_id) VALUES ('Sportive lemur', 5);
INSERT INTO music.song (song_name, album_id) VALUES ('Burchell''s gonolek', 10);
INSERT INTO music.song (song_name, album_id) VALUES ('White-throated robin', 6);
INSERT INTO music.song (song_name, album_id) VALUES ('Javan gold-spotted mongoose', 16);
INSERT INTO music.song (song_name, album_id) VALUES ('White stork', 26);
INSERT INTO music.song (song_name, album_id) VALUES ('Waterbuck, defassa', 17);
INSERT INTO music.song (song_name, album_id) VALUES ('Klipspringer', 23);
INSERT INTO music.song (song_name, album_id) VALUES ('Great kiskadee', 10);
INSERT INTO music.song (song_name, album_id) VALUES ('Lion, steller''s sea', 12);
INSERT INTO music.song (song_name, album_id) VALUES ('Porcupine, african', 29);
INSERT INTO music.song (song_name, album_id) VALUES ('Egyptian viper', 21);
INSERT INTO music.song (song_name, album_id) VALUES ('Cow, scottish highland', 33);
INSERT INTO music.song (song_name, album_id) VALUES ('Small Indian mongoose', 32);
INSERT INTO music.song (song_name, album_id) VALUES ('Brown hyena', 26);
INSERT INTO music.song (song_name, album_id) VALUES ('Meerkat, red', 30);
INSERT INTO music.song (song_name, album_id) VALUES ('African bush squirrel', 7);
INSERT INTO music.song (song_name, album_id) VALUES ('Black-capped capuchin', 15);
INSERT INTO music.song (song_name, album_id) VALUES ('Frilled lizard', 19);
INSERT INTO music.song (song_name, album_id) VALUES ('White-eye, cape', 8);
INSERT INTO music.song (song_name, album_id) VALUES ('Turkey, wild', 37);
INSERT INTO music.song (song_name, album_id) VALUES ('Egyptian vulture', 22);
INSERT INTO music.song (song_name, album_id) VALUES ('Common duiker', 32);
INSERT INTO music.song (song_name, album_id) VALUES ('Bottle-nose dolphin', 18);
INSERT INTO music.song (song_name, album_id) VALUES ('Pelican, great white', 10);
INSERT INTO music.song (song_name, album_id) VALUES ('Australian brush turkey', 29);
INSERT INTO music.song (song_name, album_id) VALUES ('Red-tailed phascogale', 9);
INSERT INTO music.song (song_name, album_id) VALUES ('Puku', 39);
INSERT INTO music.song (song_name, album_id) VALUES ('Grenadier, purple', 4);
INSERT INTO music.song (song_name, album_id) VALUES ('Magnificent frigate bird', 26);
INSERT INTO music.song (song_name, album_id) VALUES ('Greater kudu', 30);
INSERT INTO music.song (song_name, album_id) VALUES ('Eastern diamondback rattlesnake', 5);
INSERT INTO music.song (song_name, album_id) VALUES ('Greater rhea', 1);
INSERT INTO music.song (song_name, album_id) VALUES ('Darter, african', 6);
INSERT INTO music.song (song_name, album_id) VALUES ('Puna ibis', 21);
INSERT INTO music.song (song_name, album_id) VALUES ('Bald eagle', 7);
INSERT INTO music.song (song_name, album_id) VALUES ('Booby, blue-footed', 8);
INSERT INTO music.song (song_name, album_id) VALUES ('Snowy owl', 16);
INSERT INTO music.song (song_name, album_id) VALUES ('Black swan', 8);
INSERT INTO music.song (song_name, album_id) VALUES ('Hornbill, red-billed', 2);
INSERT INTO music.song (song_name, album_id) VALUES ('Iguana, land', 2);
INSERT INTO music.song (song_name, album_id) VALUES ('Rhesus macaque', 3);
INSERT INTO music.song (song_name, album_id) VALUES ('Stanley crane', 11);
INSERT INTO music.song (song_name, album_id) VALUES ('Tenrec, tailless', 27);
INSERT INTO music.song (song_name, album_id) VALUES ('Flightless cormorant', 31);
INSERT INTO music.song (song_name, album_id) VALUES ('Burchell''s gonolek', 30);
INSERT INTO music.song (song_name, album_id) VALUES ('Spurfowl, yellow-necked', 28);
INSERT INTO music.song (song_name, album_id) VALUES ('Antelope, roan', 24);
INSERT INTO music.song (song_name, album_id) VALUES ('American buffalo', 13);
INSERT INTO music.song (song_name, album_id) VALUES ('Ferruginous hawk', 23);
INSERT INTO music.song (song_name, album_id) VALUES ('Jackal, indian', 35);
INSERT INTO music.song (song_name, album_id) VALUES ('Lion, mountain', 30);
INSERT INTO music.song (song_name, album_id) VALUES ('Shrike, crimson-breasted', 27);
INSERT INTO music.song (song_name, album_id) VALUES ('Vulture, griffon', 32);
INSERT INTO music.song (song_name, album_id) VALUES ('Heron, giant', 3);
INSERT INTO music.song (song_name, album_id) VALUES ('Wolf spider', 22);
INSERT INTO music.song (song_name, album_id) VALUES ('Tern, white-winged', 22);
INSERT INTO music.song (song_name, album_id) VALUES ('Euro wallaby', 5);
INSERT INTO music.song (song_name, album_id) VALUES ('Cook''s tree boa', 33);
INSERT INTO music.song (song_name, album_id) VALUES ('Marmot, hoary', 35);
INSERT INTO music.song (song_name, album_id) VALUES ('Fox, blue', 38);
INSERT INTO music.song (song_name, album_id) VALUES ('Musk ox', 7);
INSERT INTO music.song (song_name, album_id) VALUES ('North American red fox', 18);
INSERT INTO music.song (song_name, album_id) VALUES ('Cardinal, black-throated', 18);
INSERT INTO music.song (song_name, album_id) VALUES ('Snake, green vine', 12);
INSERT INTO music.song (song_name, album_id) VALUES ('Blue-faced booby', 3);
INSERT INTO music.song (song_name, album_id) VALUES ('Dusky gull', 33);
INSERT INTO music.song (song_name, album_id) VALUES ('Ring dove', 28);
INSERT INTO music.song (song_name, album_id) VALUES ('Kangaroo, eastern grey', 1);
INSERT INTO music.song (song_name, album_id) VALUES ('Turaco, violet-crested', 37);
INSERT INTO music.song (song_name, album_id) VALUES ('Indian giant squirrel', 37);
INSERT INTO music.song (song_name, album_id) VALUES ('Bird, pied butcher', 39);
INSERT INTO music.song (song_name, album_id) VALUES ('Skunk, western spotted', 39);
INSERT INTO music.song (song_name, album_id) VALUES ('Snake, carpet', 27);
INSERT INTO music.song (song_name, album_id) VALUES ('White-winged tern', 31);
INSERT INTO music.song (song_name, album_id) VALUES ('Turtle, snake-necked', 31);
INSERT INTO music.song (song_name, album_id) VALUES ('Woolly-necked stork', 37);
INSERT INTO music.song (song_name, album_id) VALUES ('Crane, black-crowned', 8);
INSERT INTO music.song (song_name, album_id) VALUES ('Great egret', 28);
INSERT INTO music.song (song_name, album_id) VALUES ('Black-throated butcher bird', 10);
INSERT INTO music.song (song_name, album_id) VALUES ('Red and blue macaw', 20);
INSERT INTO music.song (song_name, album_id) VALUES ('Burmese brown mountain tortoise', 36);
INSERT INTO music.song (song_name, album_id) VALUES ('Fox, cape', 1);
INSERT INTO music.song (song_name, album_id) VALUES ('Short-beaked echidna', 35);
INSERT INTO music.song (song_name, album_id) VALUES ('Fox, pampa gray', 33);
INSERT INTO music.song (song_name, album_id) VALUES ('Large-eared bushbaby', 2);
INSERT INTO music.song (song_name, album_id) VALUES ('Lemur, ring-tailed', 5);
INSERT INTO music.song (song_name, album_id) VALUES ('Raccoon, common', 28);
INSERT INTO music.song (song_name, album_id) VALUES ('Jackal, silver-backed', 21);
INSERT INTO music.song (song_name, album_id) VALUES ('Giant armadillo', 30);
INSERT INTO music.song (song_name, album_id) VALUES ('Waved albatross', 15);
INSERT INTO music.song (song_name, album_id) VALUES ('Skunk, striped', 1);
INSERT INTO music.song (song_name, album_id) VALUES ('Eurasian beaver', 7);
INSERT INTO music.song (song_name, album_id) VALUES ('Black-backed magpie', 10);
INSERT INTO music.song (song_name, album_id) VALUES ('Black-throated cardinal', 40);
INSERT INTO music.song (song_name, album_id) VALUES ('Civet cat', 15);
INSERT INTO music.song (song_name, album_id) VALUES ('Verreaux''s sifaka', 35);
INSERT INTO music.song (song_name, album_id) VALUES ('Pied butcher bird', 26);
INSERT INTO music.song (song_name, album_id) VALUES ('Armadillo, common long-nosed', 1);
INSERT INTO music.song (song_name, album_id) VALUES ('Turtle, snake-necked', 27);
INSERT INTO music.song (song_name, album_id) VALUES ('Common boubou shrike', 34);
INSERT INTO music.song (song_name, album_id) VALUES ('Waterbuck, defassa', 20);
INSERT INTO music.song (song_name, album_id) VALUES ('Bear, black', 23);
INSERT INTO music.song (song_name, album_id) VALUES ('Slender loris', 6);
INSERT INTO music.song (song_name, album_id) VALUES ('Little grebe', 13);
INSERT INTO music.song (song_name, album_id) VALUES ('Spotted hyena', 10);
INSERT INTO music.song (song_name, album_id) VALUES ('Snake-necked turtle', 18);
INSERT INTO music.song (song_name, album_id) VALUES ('Golden eagle', 16);
INSERT INTO music.song (song_name, album_id) VALUES ('Greater sage grouse', 40);
INSERT INTO music.song (song_name, album_id) VALUES ('Langur, hanuman', 3);
INSERT INTO music.song (song_name, album_id) VALUES ('Otter, north american river', 20);
INSERT INTO music.song (song_name, album_id) VALUES ('Badger, honey', 25);
INSERT INTO music.song (song_name, album_id) VALUES ('Salmon pink bird eater tarantula', 30);
INSERT INTO music.song (song_name, album_id) VALUES ('Native cat', 38);
INSERT INTO music.song (song_name, album_id) VALUES ('Cardinal, red-capped', 36);
INSERT INTO music.song (song_name, album_id) VALUES ('Heron, goliath', 39);
INSERT INTO music.song (song_name, album_id) VALUES ('Capuchin, weeper', 12);
INSERT INTO music.song (song_name, album_id) VALUES ('Sungazer, yellow-brown', 9);
INSERT INTO music.song (song_name, album_id) VALUES ('Tsessebe', 18);
INSERT INTO music.song (song_name, album_id) VALUES ('Stork, european', 25);
INSERT INTO music.song (song_name, album_id) VALUES ('Owl, madagascar hawk', 30);
INSERT INTO music.song (song_name, album_id) VALUES ('Southern white-crowned shrike', 35);
INSERT INTO music.song (song_name, album_id) VALUES ('Viper, egyptian', 32);
INSERT INTO music.song (song_name, album_id) VALUES ('Woodrat (unidentified)', 35);
INSERT INTO music.song (song_name, album_id) VALUES ('American bison', 6);
INSERT INTO music.song (song_name, album_id) VALUES ('Glider, feathertail', 39);
INSERT INTO music.song (song_name, album_id) VALUES ('Hare, arctic', 12);
INSERT INTO music.song (song_name, album_id) VALUES ('Heron, grey', 22);
INSERT INTO music.song (song_name, album_id) VALUES ('Osprey', 7);
INSERT INTO music.song (song_name, album_id) VALUES ('Canadian river otter', 9);
INSERT INTO music.song (song_name, album_id) VALUES ('Common wallaroo', 18);
INSERT INTO music.song (song_name, album_id) VALUES ('American racer', 22);
INSERT INTO music.song (song_name, album_id) VALUES ('Southern elephant seal', 27);
INSERT INTO music.song (song_name, album_id) VALUES ('Black-winged stilt', 38);
INSERT INTO music.song (song_name, album_id) VALUES ('Kalahari scrub robin', 26);
INSERT INTO music.song (song_name, album_id) VALUES ('Seven-banded armadillo', 23);
INSERT INTO music.song (song_name, album_id) VALUES ('Red meerkat', 31);
INSERT INTO music.song (song_name, album_id) VALUES ('Springbok', 2);
INSERT INTO music.song (song_name, album_id) VALUES ('Squirrel, malabar', 6);
INSERT INTO music.song (song_name, album_id) VALUES ('Crested barbet', 11);
INSERT INTO music.song (song_name, album_id) VALUES ('Great egret', 23);
INSERT INTO music.song (song_name, album_id) VALUES ('Western spotted skunk', 1);
INSERT INTO music.song (song_name, album_id) VALUES ('Brown and yellow marshbird', 19);
INSERT INTO music.song (song_name, album_id) VALUES ('Galapagos albatross', 7);
INSERT INTO music.song (song_name, album_id) VALUES ('Cockatoo, roseate', 6);
INSERT INTO music.song (song_name, album_id) VALUES ('Jungle kangaroo', 16);
INSERT INTO music.song (song_name, album_id) VALUES ('Crane, brolga', 17);
INSERT INTO music.song (song_name, album_id) VALUES ('Antechinus, brown', 38);
INSERT INTO music.song (song_name, album_id) VALUES ('Deer, white-tailed', 18);
INSERT INTO music.song (song_name, album_id) VALUES ('Bandicoot, long-nosed', 37);
INSERT INTO music.song (song_name, album_id) VALUES ('Striped dolphin', 16);
INSERT INTO music.song (song_name, album_id) VALUES ('Colobus, white-mantled', 20);
INSERT INTO music.song (song_name, album_id) VALUES ('Egyptian viper', 20);
INSERT INTO music.song (song_name, album_id) VALUES ('Two-toed tree sloth', 37);
INSERT INTO music.song (song_name, album_id) VALUES ('Trotter, lily', 24);
INSERT INTO music.song (song_name, album_id) VALUES ('Vulture, griffon', 17);
INSERT INTO music.song (song_name, album_id) VALUES ('Greater flamingo', 33);
INSERT INTO music.song (song_name, album_id) VALUES ('Waxbill, violet-eared', 21);
INSERT INTO music.song (song_name, album_id) VALUES ('Water monitor', 5);
INSERT INTO music.song (song_name, album_id) VALUES ('Mexican beaded lizard', 21);
INSERT INTO music.song (song_name, album_id) VALUES ('Salmon, sockeye', 7);
INSERT INTO music.song (song_name, album_id) VALUES ('Kaffir cat', 36);
INSERT INTO music.song (song_name, album_id) VALUES ('Lizard (unidentified)', 18);
INSERT INTO music.song (song_name, album_id) VALUES ('Creeper, black-tailed tree', 39);
INSERT INTO music.song (song_name, album_id) VALUES ('Goose, spur-winged', 40);
INSERT INTO music.song (song_name, album_id) VALUES ('Hanuman langur', 40);
INSERT INTO music.song (song_name, album_id) VALUES ('Eurasian beaver', 8);
INSERT INTO music.song (song_name, album_id) VALUES ('Kaffir cat', 17);
INSERT INTO music.song (song_name, album_id) VALUES ('Brown hyena', 30);
INSERT INTO music.song (song_name, album_id) VALUES ('African red-eyed bulbul', 34);
INSERT INTO music.song (song_name, album_id) VALUES ('Stork, jabiru', 36);
INSERT INTO music.song (song_name, album_id) VALUES ('Miner''s cat', 12);
INSERT INTO music.song (song_name, album_id) VALUES ('Mexican beaded lizard', 39);
INSERT INTO music.song (song_name, album_id) VALUES ('Skink, blue-tongued', 23);
INSERT INTO music.song (song_name, album_id) VALUES ('Lark, horned', 9);
INSERT INTO music.song (song_name, album_id) VALUES ('Puku', 23);
INSERT INTO music.song (song_name, album_id) VALUES ('Cat, long-tailed spotted', 4);
INSERT INTO music.song (song_name, album_id) VALUES ('Frogmouth, tawny', 23);

INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (10, 36);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (19, 31);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (11, 5);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (19, 3);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (5, 17);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (19, 7);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (1, 24);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (6, 15);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (12, 40);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (10, 11);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (7, 7);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (17, 19);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (6, 3);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (13, 1);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (9, 29);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (18, 21);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (19, 15);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (8, 39);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (8, 40);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (12, 39);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (12, 3);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (11, 6);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (8, 3);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (16, 36);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (2, 20);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (2, 24);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (4, 12);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (4, 11);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (9, 26);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (1, 15);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (2, 38);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (3, 23);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (16, 4);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (10, 25);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (6, 25);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (17, 36);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (3, 33);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (11, 31);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (8, 15);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (11, 21);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (16, 30);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (6, 28);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (3, 37);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (10, 30);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (13, 39);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (7, 18);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (6, 23);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (10, 34);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (5, 10);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (16, 2);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (9, 32);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (20, 37);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (13, 16);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (3, 6);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (2, 1);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (6, 13);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (16, 9);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (5, 5);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (19, 35);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (15, 14);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (16, 8);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (7, 10);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (10, 1);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (10, 28);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (8, 26);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (14, 31);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (6, 24);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (10, 15);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (11, 28);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (7, 19);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (4, 25);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (13, 22);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (6, 1);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (11, 15);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (9, 3);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (14, 20);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (12, 35);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (1, 37);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (2, 11);
INSERT INTO music.artist_albums_album (artist_id, album_id) VALUES (7, 38);