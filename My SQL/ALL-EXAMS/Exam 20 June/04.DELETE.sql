DELETE FROM clients
WHERE id not in(select client_id from courses);
