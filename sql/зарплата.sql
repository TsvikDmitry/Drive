select id_orders, ord.id_operator,
	ord.data_create, ord.time_create, ord.data_end, ord.time_end,
    printer,
    printer*0.1,
    printer2,
	printer-pay_sum as dolg, 
    ord.name_status_order, ord.id_order_status, ord.text_description
from (select id_orders, 
	ords.data_create, ords.time_create, ords.data_end, ords.time_end,
	IFNULL((select sum(order_printer.sum_all) from order_printer  where order_printer.id_orders=ords.id_orders),0) as printer,
	IFNULL((select sum(order_printer.count*(order_printer.price_paper+order_printer.price_print)) from order_printer  where order_printer.id_orders=ords.id_orders),0) as printer2,
	IFNULL((select sum(order_pay.sum_pay) from order_pay  where order_pay.id_orders=ords.id_orders ),0) as pay_sum,
    orst.name_status_order, ords.id_order_status, ords.text_description, ords.id_operator
from orders ords 
	inner join order_status orst on orst.id_status_order=ords.id_order_status 
group by id_operator  order by id_operator desc) as ord ;