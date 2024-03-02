CREATE TABLE IF NOT EXISTS orders
(
    id_order         BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    user_id          BIGINT NOT NULL,
    status_order_id  BIGINT NOT NULL,
    delivery_address VARCHAR(1000),
    delivery_date    DATE,
    PRIMARY KEY (id_order),
    FOREIGN KEY (user_id) REFERENCES users (id_user),
    FOREIGN KEY (status_order_id) REFERENCES status_order (id_status_order)
);

CREATE TABLE IF NOT EXISTS status_order
(
    id_status_order BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    status          VARCHAR,
    PRIMARY KEY (id_status_order)
);

CREATE TABLE IF NOT EXISTS donations
(
    id_donation       BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    user_id           BIGINT NOT NULL,
    payment_method_id BIGINT NOT NULL,
    amount            DOUBLE PRECISION,
    date              DATE,
    PRIMARY KEY (id_donation),
    FOREIGN KEY (user_id) REFERENCES users (id_user),
    FOREIGN KEY (payment_method_id) REFERENCES payment_method (id_payment_method)
);

CREATE TABLE IF NOT EXISTS payment_method
(
    id_payment_method BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    name              VARCHAR(200),
    PRIMARY KEY (id_payment_method)
);

CREATE TABLE IF NOT EXISTS dishes_in_order
(
    id_dishes_in_order BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    dish_id            BIGINT NOT NULL,
    order_id           BIGINT NOT NULL,
    count              INTEGER,
    PRIMARY KEY (id_dishes_in_order),
    FOREIGN KEY (dish_id) REFERENCES dishes (id_dish),
    FOREIGN KEY (order_id) REFERENCES orders (id_order)
);

CREATE TABLE IF NOT EXISTS dishes
(
    id_dish      BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    name         VARCHAR(500),
    description  VARCHAR(2000),
    price        DOUBLE PRECISION,
    is_available BOOLEAN,
    PRIMARY KEY (id_dish)
);

CREATE TABLE IF NOT EXISTS user_roles
(
    id_user_role BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    role         VARCHAR(200),
    PRIMARY KEY (id_user_role)
);

CREATE TABLE IF NOT EXISTS reasons_blocked
(
    id_reason_blocked BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    reason            VARCHAR(200),
    PRIMARY KEY (id_reason_blocked)
);

CREATE TABLE IF NOT EXISTS users
(
    id_user           BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    user_type_id      BIGINT NOT NULL,
    user_role_id      BIGINT NOT NULL,
    first_name        VARCHAR(100),
    last_name         VARCHAR(200),
    address           VARCHAR(1000),
    phone             VARCHAR(20),
    email             VARCHAR(200),
    login             VARCHAR(100),
    password          VARCHAR(100),
    is_blocked        BOOLEAN DEFAULT FALSE,
    reason_blocked_id BIGINT,
    PRIMARY KEY (id_user),
    FOREIGN KEY (user_type_id) REFERENCES user_types (id_user_type),
    FOREIGN KEY (user_role_id) REFERENCES user_roles (id_user_role),
    FOREIGN KEY (reason_blocked_id) REFERENCES reasons_blocked (id_reason_blocked)
);

CREATE TABLE IF NOT EXISTS user_types
(
    id_user_type BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    type         VARCHAR,
    PRIMARY KEY (id_user_type)
);