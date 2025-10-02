-- Tabla de Facturas (Invoices)
CREATE TABLE invoices (
    id SERIAL PRIMARY KEY,
    invoice_number VARCHAR(50) NOT NULL,
    customer_id INTEGER NOT NULL,
    date DATE NOT NULL,
    total DECIMAL(12,2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla de Líneas de Factura (Invoice Lines)
CREATE TABLE invoice_lines (
    id SERIAL PRIMARY KEY,
    invoice_id INTEGER NOT NULL REFERENCES invoices(id) ON DELETE CASCADE,
    product_id INTEGER NOT NULL,
    quantity INTEGER NOT NULL,
    unit_price DECIMAL(12,2) NOT NULL,
    subtotal DECIMAL(12,2) NOT NULL
);

-- Tabla de Existencias (Inventory Products)
CREATE TABLE inventory_products (
    id SERIAL PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    stock INTEGER NOT NULL DEFAULT 0,
    price DECIMAL(12,2) NOT NULL,
    supplier_id INTEGER
);

-- Tabla de Clientes (Clients)
CREATE TABLE clients (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    phone VARCHAR(30),
    address TEXT
);

-- Tabla de Proveedores (Suppliers)
CREATE TABLE suppliers (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    phone VARCHAR(30)
);

-- Tabla de Compras (Purchases)
CREATE TABLE purchases (
    id SERIAL PRIMARY KEY,
    supplier_id INTEGER NOT NULL REFERENCES suppliers(id),
    product_id INTEGER NOT NULL REFERENCES inventory_products(id),
    quantity INTEGER NOT NULL,
    purchase_date DATE NOT NULL,
    total_cost DECIMAL(12,2) NOT NULL
);
