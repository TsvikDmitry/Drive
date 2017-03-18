use copydrive;
SELECT 
	ord.id_orders, 
    stat.name_status_order,
    	(select sum(sum_all) from order_printer where order_printer.id_orders=ord.id_orders) as b ,
	(select sum(sum_pay) from order_pay where order_pay.id_orders=ord.id_orders) as f, 
	case when (select sum(sum_pay) from order_pay where order_pay.id_orders=ord.id_orders)-(select sum(sum_all) from order_printer where order_printer.id_orders=ord.id_orders) >= 0 
    then 'Оплачено' else 'Неоплачено' end as status
from orders ord
	inner join order_status stat on stat.id_status_order=ord.id_order_status
	order by id_orders
    