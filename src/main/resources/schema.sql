create table PRODUCTS (
    id bigint primary key auto_increment,
    name varchar(50) not null,
    category enum('BREAD', 'DRINK', 'SWEET', 'OTHER') not null,
    price double not null,
    description varchar(255) not null
);

create table SHOPPING_CARTS (
    id bigint primary key auto_increment,
    session_id varchar(255) not null
);

create table SHOPPING_CART_ITEMS (
    id bigint primary key auto_increment,
    product_id bigint not null,
    amount bigint not null,
    shopping_cart_id bigint not null,
    constraint fk_product_id foreign key (product_id) references PRODUCTS(id),
    constraint fk_shopping_cart_id foreign key (shopping_cart_id) references SHOPPING_CARTS(id)
);