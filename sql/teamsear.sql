--TO SORT BY FACTION, ADD a.side = 'Horde' 'Alliance'

--SEARCH BY BATTLEGROUP
--RETURNS TEAM NAME, TEAM RATING, TEAM RANKING
--'whirlwind' should be changed to any bg names
--selects team, rating, ranking by battlegroup
--Remove limit to return all teams
SELECT a.name, a.rating, a.ranking
FROM arenateam a, characters c
WHERE c.battlegroup = 'Whirlwind' AND a.name = c.arenaname
GROUP BY a.name, a.rating, a.ranking
ORDER BY a.ranking ASC
LIMIT 10
;

--SEARCH BY REALM
--RETURNS TEAM NAME, TEAM RATING, TEAM RANKING
--'Doomhammer' should be changed to any bg names
--Note, Kel'Thuzad needs special characters
--selects team, rating, ranking by battlegroup
--Remove limit to return all teams
SELECT a.name, a.rating, a.ranking
FROM arenateam a, characters c
WHERE c.realm = 'Tichondrius' AND a.name = c.arenaname
GROUP BY a.name, a.rating, a.ranking
ORDER BY a.ranking ASC
LIMIT 10
;

--RATING SEARCH	(Range query for testing purposes, upper bound is ~3k)
--SEARCH BY BATTLEGROUP
--RETURNS TEAM NAME, TEAM RATING, TEAM RANKING
--'whirlwind' should be changed to any bg names
--selects team, rating, ranking by battlegroup
SELECT a.name, a.rating, a.ranking
FROM arenateam a, characters c
WHERE c.battlegroup = 'Whirlwind' AND a.name = c.arenaname AND a.rating > 1600 AND a.rating < 3000
GROUP BY a.name, a.rating, a.ranking
ORDER BY a.ranking ASC
LIMIT 10
;


--TO DO: TOP COMP by representation
--

--HORDE VS ALLIANCE TEAM SEARCH
SELECT DECIMAL(DECIMAL(count(horde))/DECIMAL(count(alliance)))
FROM arena a
WHERE side = 'Alliance' as alliance AND side = 'Horde' as horde
;

