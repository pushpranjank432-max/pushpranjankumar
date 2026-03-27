-- 1. Users ki table
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    mobile VARCHAR(15) UNIQUE,
    password VARCHAR(255),
    address TEXT
);

-- 2. Products ki table
CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    p_name VARCHAR(255),
    p_price DECIMAL(10,2),
    p_image VARCHAR(255),
    p_desc TEXT
);

-- 3. Orders ki table (Google Maps aur Tracking ke liye)
CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    total_amount DECIMAL(10,2),
    lat VARCHAR(50), -- Google Map Latitude
    lng VARCHAR(50), -- Google Map Longitude
    status VARCHAR(50) DEFAULT 'Pending', -- Tracking Status
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
);
