use copydrive;
select *,
case when a.b > 0 then a.b else 0 end as status
from 
(select id_orders, 
(select sum(order_plotter.sum_all) from order_plotter  where order_plotter.id_orders=orders.id_orders ) 
as b from orders group by id_orders) as a ;