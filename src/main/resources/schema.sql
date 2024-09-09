create table PRODUCTS (
    id bigint primary key auto_increment,
    name varchar(50) not null,
    category enum('BREAD', 'DRINK', 'SWEET', 'OTHER'),
    price double not null,
    description varchar(255) not null
);