-- Create the users table
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    user_password VARCHAR(255) NOT NULL,
    user_role VARCHAR(20) NOT NULL CHECK (user_role IN ('USER','ADMIN','MOD'))
);

-- Insert mock data
INSERT INTO users (username, user_password, user_role) VALUES
('alice01', 'password123', 'ADMIN'),
('bob_smith', 'securepass', 'USER'),
('charlie87', 'letmein', 'USER'),
('diana_k', 'passw0rd', 'MOD'),
('edwardL', 'qwerty!', 'USER'),
('fiona_dev', 'devPass42', 'ADMIN'),
('georgeM', 'helloWorld', 'USER'),
('hannah88', 'sunshine', 'USER'),
('ivan_admin', 'rootAccess', 'ADMIN'),
('juliaP', 'mypassword', 'USER'),
('kyleTech', 'techPass99', 'MOD'),
('lauraX', 'welcome123', 'USER'),
('michaelT', '12345', 'USER'),
('nina_support', 'supportMe', 'MOD'),
('oscarDev', 'devOps2024', 'ADMIN');