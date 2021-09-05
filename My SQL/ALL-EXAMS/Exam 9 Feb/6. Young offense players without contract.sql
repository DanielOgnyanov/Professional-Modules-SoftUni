SELECT p.id, concat_ws(' ', first_name, last_name) AS 'Full_Name', age, position, hire_date
FROM players AS p
JOIN skills_data AS sd
ON sd.id = p.skills_data_id
WHERE hire_date IS NULL AND sd.strength > 50 AND age < 23 AND position = 'A'
ORDER BY salary , age;