CREATE TABLE users (
    user_id CHAR(36) PRIMARY KEY,
    first_name VARCHAR(10) NOT NULL,
    last_name VARCHAR(40) NOT NULL,
    cpf CHAR(11) NOT NULL,
    phone CHAR(11) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at DATETIME NOT NULL,
    updated_at DATETIME,
    deleted_at DATETIME,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    deleted_by VARCHAR(255),
    is_active TINYINT(1) NOT NULL DEFAULT 1,
    user_type VARCHAR(32) NOT NULL,
    CONSTRAINT uq_users_email UNIQUE (email),
    CONSTRAINT uq_users_cpf UNIQUE (cpf)
);