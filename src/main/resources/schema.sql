create table PRODUCTS (
    id bigint primary key auto_increment,
    name varchar(50) not null,
    product_type enum('FOOD', 'CLOTHES', 'ELECTRONICS'),
    price double not null,
    description varchar(255) not null
);