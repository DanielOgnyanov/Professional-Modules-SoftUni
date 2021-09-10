DELIMITER $$
CREATE PROCEDURE udp_find_playmaker (min_dribble_points  INT , team_name VARCHAR(45))
BEGIN

SELECT concat (first_name , ' ', last_name) AS 'full_name',p.age, p.salary, sd.dribbling, sd.speed,
t.`name` AS 'team_name'
FROM teams AS t

JOIN players AS p
ON t.id = p.team_id

JOIN skills_data AS sd
ON sd.id = p.skills_data_id

WHERE sd.dribbling > min_dribble_points AND t.`name` = team_name
ORDER BY sd.speed DESC
LIMIT 1;

END $$
DELIMITER ;

