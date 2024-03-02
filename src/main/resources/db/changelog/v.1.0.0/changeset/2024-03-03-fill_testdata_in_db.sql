-- Добавление тестовых записей ву user_types
INSERT INTO user_types (type)
VALUES ('Admin'),
       ('User'),
       ('Guest'),
       ('Moderator'),
       ('Manager'),
       ('Editor'),
       ('Subscriber'),
       ('Customer'),
       ('Supervisor'),
       ('Analyst');

-- Добавление тестовых записей в таблицу user_roles
INSERT INTO user_roles (role)
VALUES ('Admin'),
       ('User'),
       ('Guest'),
       ('Moderator'),
       ('Manager'),
       ('Editor'),
       ('Subscriber'),
       ('Customer'),
       ('Supervisor'),
       ('Analyst');

-- Добавление тестовых записей в таблицу reasons_blocked
INSERT INTO reasons_blocked (reason)
VALUES ('Spam'),
       ('Abusive behavior'),
       ('Fraud'),
       ('Violation of terms'),
       ('Inappropriate content'),
       ('Harassment'),
       ('Scam'),
       ('Hate speech'),
       ('Impersonation'),
       ('Threats');

-- Добавление тестовых записей в таблицу users
INSERT INTO users (user_type_id, user_role_id, first_name, last_name, address, phone, email, login, password,
                   is_blocked, reason_blocked_id)
VALUES (1, 2, 'John', 'Doe', '123 Main St', '123-456-7890', 'john.doe@example.com', 'johndoe', 'password123', false,
        NULL),
       (2, 3, 'Jane', 'Smith', '456 Elm St', '987-654-3210', 'jane.smith@example.com', 'janesmith', 'password456',
        false, NULL),
       (3, 4, 'Michael', 'Johnson', '789 Oak St', '555-555-5555', 'michael.johnson@example.com', 'michaeljohnson',
        'password789', false, NULL),
       (4, 5, 'Emily', 'Brown', '321 Pine St', '111-222-3333', 'emily.brown@example.com', 'emilybrown', 'passwordabc',
        false, NULL),
       (5, 6, 'David', 'Miller', '654 Maple St', '444-444-4444', 'david.miller@example.com', 'davidmiller',
        'passworddef', false, NULL),
       (6, 7, 'Olivia', 'Wilson', '987 Cedar St', '777-888-9999', 'olivia.wilson@example.com', 'oliviawilson',
        'passwordghi', false, NULL),
       (7, 8, 'James', 'Anderson', '159 Birch St', '222-333-4444', 'james.anderson@example.com', 'jamesanderson',
        'passwordjkl', false, NULL),
       (8, 9, 'Sophia', 'Taylor', '753 Walnut St', '666-777-8888', 'sophia.taylor@example.com', 'sophiataylor',
        'passwordmno', false, NULL),
       (9, 10, 'Benjamin', 'Thomas', '852 Spruce St', '999-999-9999', 'benjamin.thomas@example.com', 'benjaminthomas',
        'passwordpqr', false, NULL),
       (10, 1, 'Emma', 'Robinson', '456 Oak St', '123-123-1234', 'emma.robinson@example.com', 'emmarobinson',
        'passwordstu', false, NULL);

-- Добавление тестовых записей в таблицу status_order
INSERT INTO status_order (status)
VALUES ('Pending'),
       ('Processing'),
       ('Shipped'),
       ('Delivered'),
       ('Cancelled'),
       ('Returned'),
       ('Refunded'),
       ('Completed'),
       ('On Hold'),
       ('Out for Delivery');

-- Добавление тестовых записей в таблицу payment_method
INSERT INTO payment_method (name)
VALUES ('Credit Card'),
       ('Debit Card'),
       ('PayPal'),
       ('Apple Pay'),
       ('Google Pay'),
       ('Venmo'),
       ('Cash'),
       ('Check'),
       ('Bank Transfer'),
       ('Cryptocurrency');

-- Добавление тестовых записей в таблицу orders
INSERT INTO orders (user_id, status_order_id, delivery_address, delivery_date)
VALUES (1, 2, '123 Main St', '2022-01-01'),
       (2, 3, '456 Elm St', '2022-01-02'),
       (3, 4, '789 Oak St', '2022-01-03'),
       (4, 5, '321 Pine St', '2022-01-04'),
       (5, 6, '654 Maple St', '2022-01-05'),
       (6, 7, '987 Cedar St', '2022-01-06'),
       (7, 8, '159 Birch St', '2022-01-07'),
       (8, 9, '753 Walnut St', '2022-01-08'),
       (9, 10, '852 Spruce St', '2022-01-09'),
       (10, 1, '456 Oak St', '2022-01-10');

-- Добавление тестовых записей в таблицу donations
INSERT INTO donations (user_id, payment_method_id, amount, date)
VALUES (1, 2, 100.00, '2022-01-01'),
       (2, 3, 50.00, '2022-01-02'),
       (3, 4, 25.00, '2022-01-03'),
       (4, 5, 75.00, '2022-01-04'),
       (5, 6, 200.00, '2022-01-05'),
       (6, 7, 150.00, '2022-01-06'),
       (7, 8, 50.00, '2022-01-07'),
       (8, 9, 1000.00, '2022-01-08'),
       (9, 10, 500.00, '2022-01-09'),
       (10, 1, 250.00, '2022-01-10');

-- Добавление тестовых записей в таблицу dishes
INSERT INTO dishes (name, description, price, is_available)
VALUES ('Pizza', 'Delicious pizza with various toppings', 10.99, true),
       ('Burger', 'Juicy burger with cheese and bacon', 8.99, true),
       ('Pasta', 'Classic pasta with marinara sauce', 12.99, true),
       ('Salad', 'Fresh salad with mixed greens and vegetables', 6.99, true),
       ('Steak', 'Tender steak cooked to perfection', 19.99, true),
       ('Sushi', 'Assorted sushi rolls with fresh fish', 15.99, true),
       ('Chicken Wings', 'Spicy chicken wings with dipping sauce', 9.99, true),
       ('Tacos', 'Authentic tacos with choice of meat', 7.99, true),
       ('Soup', 'Homemade soup with seasonal ingredients', 5.99, true),
       ('Sandwich', 'Classic sandwich with choice of fillings', 6.99, true);

-- Добавление тестовых записей в таблицу dishes_in_order
INSERT INTO dishes_in_order (dish_id, order_id, count)
VALUES (1, 1, 2),
       (2, 1, 1),
       (3, 5, 3),
       (4, 2, 1),
       (5, 4, 2),
       (6, 1, 2),
       (7, 4, 4),
       (8, 4, 2),
       (9, 5, 1),
       (10, 5, 1);