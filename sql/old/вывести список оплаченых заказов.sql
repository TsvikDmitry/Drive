SELECT op.id_orders, data_create, sum(op.sum_all), time_create, time_end, name_status_order FROM copydrive.order_printer op
inner join orders ord on op.id_orders=ord.id_orders
inner join order_status stat on stat.id_status_order=ord.id_order_status
group by id_orders order by id_orders DESC;
