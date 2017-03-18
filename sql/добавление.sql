BEGIN;
INSERT INTO `copydrive`.`orders` (`id_order_status`,`data_create`,`time_create`,`data_end`)
VALUES ('1', '2017-02-23','10:11','2017-02-23');
SELECT LAST_INSERT_ID() as LastIdOrders;
COMMIT;