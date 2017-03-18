use copydrive;
select id_orders,
case when ord.plotter > 0 then plotter else 0 end as plotter,
case when ord.printer > 0 then printer else 0 end as printer,
(case when ord.plotter > 0 then plotter else 0 end)+(case when ord.printer > 0 then printer else 0 end) as sum,
case when ord.pay > 0 then pay else 0 end as pay
from (select id_orders, 
(select sum(order_plotter.sum_all) from order_plotter  where order_plotter.id_orders=orders.id_orders ) as plotter,
(select sum(order_printer.sum_all) from order_printer  where order_printer.id_orders=orders.id_orders ) as printer,
(select sum(order_pay.sum_pay) from order_pay  where order_pay.id_orders=orders.id_orders ) as pay,
(select case when orders.plotter > 0 then plotter else 0 end as plotter) as d
from orders 
group by id_orders) as ord
