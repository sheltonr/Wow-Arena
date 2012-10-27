create table arenateam (
  realm varchar(30) NOT NULL,
  ranking int,
  rating int NOT NULL,
  teamsize int NOT NULL,
  name varchar(60) NOT NULL,
  gamesPlayed int,
  gamesWon int,
  gamesLost int,
  sessionGamesPlayed int,
  sessionGamesWon int,
  sessionGamesLost int,
  lastSessionRanking int,
  side varchar(20),
  currentWeekRanking int,
  PRIMARY KEY (name, realm));
  
create table characters (
	name varchar(60) NOT NULL,
	realm varchar(30) NOT NULL,
	battlegroup varchar(30),
	class varchar(30),
	race varchar(30),
	gender int,
	level int,
	achievementPoints int,
	thumbnail varchar(90),
	guild varchar(90),
	arenaname varchar(60) NOT NULL,
	PRIMARY KEY (name, realm),
	FOREIGN KEY (arenaname, realm) REFERENCES arenateam(name, realm));
	