CREATE TABLE PRICES (
    ID VARCHAR(255) PRIMARY KEY,
    BRAND_ID INT NOT NULL,
    BRAND_NAME VARCHAR(255) NOT NULL,
    START_DATE TIMESTAMP NOT NULL,
    END_DATE TIMESTAMP NOT NULL,
    PRICE_LIST INT NOT NULL,
    PRODUCT_ID INT NOT NULL,
    PRIORITY INT NOT NULL,
    PRICE DECIMAL(10, 2) NOT NULL,
    CURRENCY VARCHAR(3) NOT NULL,
    CREATE_DATE TIMESTAMP NOT NULL,
    UPDATE_DATE TIMESTAMP NULL,
    STATE_REGISTER VARCHAR(3) NOT NULL
);