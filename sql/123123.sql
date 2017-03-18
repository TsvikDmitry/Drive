select id_orders,
	ord.data_create, ord.time_create, ord.data_end, ord.time_end,
	case when pay_sum = 0 then 'Не оплачен' 
	else case when order_sum= pay_sum then 'Оплачено' 
	else case when  order_sum>pay_sum then 'Задолженность' 
	else  case when  order_sum<pay_sum then 'Переплата' end  end end end as status_pay,
    plotter,printer, dop, order_sum,pay_sum,
	order_sum-pay_sum as dolg, 
    ord.name_status_order, ord.id_order_status, ord.text_description
from (select id_orders, 
	ords.data_create, ords.time_create, ords.data_end, ords.time_end,
	IFNULL((select sum(order_plotter.sum_all) from order_plotter  where order_plotter.id_orders=ords.id_orders ),0) as plotter,
	IFNULL((select sum(order_printer.sum_all) from order_printer  where order_printer.id_orders=ords.id_orders),0) as printer,
    	IFNULL((select sum(order_dop.sum_all) from order_dop  where order_dop.id_orders=ords.id_orders),0) as dop,
	IFNULL((select sum(order_plotter.sum_all) from order_plotter  where order_plotter.id_orders=ords.id_orders ),0)+
    IFNULL((select sum(order_printer.sum_all) from order_printer  where order_printer.id_orders=ords.id_orders),0) as order_sum,
	IFNULL((select sum(order_pay.sum_pay) from order_pay  where order_pay.id_orders=ords.id_orders ),0) as pay_sum,
    orst.name_status_order, ords.id_order_status, ords.text_description
from orders ords 
	inner join order_status orst on orst.id_status_order=ords.id_order_status 
group by id_orders order by id_orders desc) as ord ;

