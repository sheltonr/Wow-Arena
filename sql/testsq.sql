--realm should be changed to any realmname
--returns teams, ranking, rating by realm
--note that kel'thuzad requires special query
select a.name, a.rating, a.ranking
from arenateam a, characters c
where c.realm = 'Blackrock' and a.name = c.arenaname
Group by a.name, a.rating, a.ranking
;

--'whirlwind' should be changed to any bg names
--selects team, rating, ranking by battlegroup
select a.name, a.rating, a.ranking
from arenateam a, characters c
where c.battlegroup = 'Whirlwind' and a.name = c.arenaname
group by a.name, a.rating, a.ranking
order by a.ranking asc
limit 10
;

--Does not currently work, apparently we discarded player ratings
--Should show top <class> by rating
--select c.name, c.rating
--from characters c
--where c.class = 'rogue'
--group by c.name, c.rating
--order by c.rating asc
--limit 10
--;

--case sensitive in search
select count(c.class)
from characters c
where c.class = 'Mage'
;

--case sensitive in search ok this totally doesn't work
select count(c1.race), count(c2.race)
from characters c1, characters c2, arenateam a
where c1.race = 'Human' and c1.arenaname = a.name
;

--possible to have a search showing what class plays with other classes?  ex. shadowpriests play with a mage 90% of the time