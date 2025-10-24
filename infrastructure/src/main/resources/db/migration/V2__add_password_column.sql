ALTER TABLE users ADD COLUMN password VARCHAR(255);
UPDATE users SET password = 'temp123';
ALTER TABLE users ALTER COLUMN password SET NOT NULL;