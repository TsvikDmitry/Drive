SELECT op.id_orders, sum(op.sum_all), sum(pay.sum_pay) FROM copydrive.order_printer op 
left join orders ord on op.id_orders=ord.id_orders 
left join order_pay pay on pay.id_orders=op.id_orders
group by id_orders order by id_orders DESC 
