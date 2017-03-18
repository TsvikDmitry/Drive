SELECT op.id_orders, sum(op.sum_all) FROM copydrive.order_printer op 
right join orders ord on op.id_orders=ord.id_orders
group by id_orders order by id_orders DESC  