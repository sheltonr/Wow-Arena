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