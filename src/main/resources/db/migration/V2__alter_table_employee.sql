DROP TABLE IF EXISTS employee;

CREATE TABLE IF NOT EXISTS employee (
    id UUID PRIMARY KEY NOT NULL,
    name VARCHAR(50),
    email VARCHAR(50),
    job_title VARCHAR(50),
    phone VARCHAR(50),
    image_url VARCHAR(50),
    employee_code VARCHAR(50)
);
