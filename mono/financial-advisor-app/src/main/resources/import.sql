create sequence expenses_sequence start with 1 increment by 1;
INSERT INTO Expenses(id) VALUES(nextval('expenses_sequence'));

create sequence trans_category_sequence start with 1 increment by 1;
INSERT INTO TransactionsCategory(id, name) VALUES (nextval('trans_category_sequence'), 'supermarket');
INSERT INTO TransactionsCategory(id, name) VALUES (nextval('trans_category_sequence'), 'restaurants');
INSERT INTO TransactionsCategory(id, name) VALUES (nextval('trans_category_sequence'), 'general');

create sequence transactions_sequence start with 1 increment by 1;
INSERT INTO Transactions(id, description, category_id, amount)
VALUES (nextval('transactions_sequence'), 'coffee', (select id from TransactionsCategory where name = 'restaurants'), 12);
INSERT INTO Transactions(id, description, category_id, amount)
VALUES (nextval('transactions_sequence'), 'amazon.com', (select id from TransactionsCategory where name = 'general'), 50);
INSERT INTO Transactions(id, description, category_id, amount)
VALUES (nextval('transactions_sequence'), 'bourbon', (select id from TransactionsCategory where name = 'supermarket'), 244);