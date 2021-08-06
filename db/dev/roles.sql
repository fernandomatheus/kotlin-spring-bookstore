CREATE ROLE bookstore_dev_rw WITH LOGIN PASSWORD 'dev_database_bookstore_pass';
GRANT ALL PRIVILEGES ON DATABASE bookstore_db TO bookstore_dev_rw;