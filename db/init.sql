CREATE DATABASE 'projet fullstack';
CREATE USER 'fullstackuser'@'localhost' IDENTIFIED BY 'Formation123';
GRANT ALL PRIVILEGES ON 'projet fullstack' TO 'fullstackuser'@'localhost';
FLUSH PRIVILEGES;