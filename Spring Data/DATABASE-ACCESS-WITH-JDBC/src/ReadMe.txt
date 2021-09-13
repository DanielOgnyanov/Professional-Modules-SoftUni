Здравейте,

преди да започнете да тествате задачите уверете се че имате чиста база.
Важно е да си импортнете тези две SQL ски процедури за да ви се изпулнчт правилно задачите.


create
    definer = root@localhost procedure usp_get_older(IN minion_id int)
BEGIN
    UPDATE minions
        SET age = age + 1
    WHERE id = minion_id;
end;

/////////////////////////////////////////////


create
    definer = root@localhost procedure set_age_and_name(IN minion_id int)
BEGIN
    UPDATE minions
    SET name = LOWER(name) , age = age + 1
    WHERE id = minion_id;
end;

//////////////////////////////////////////////