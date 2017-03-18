use copydrive; 
select *, 
case when a.a - a.b = 0 then 'Оплачено' else case when a.a - a.b > 0 then 'Переплата' else 'Неоплачено' end end as status 
from (select id_orders, sum(sum_all) as a, (select sum(sum_pay) from order_pay 
where order_pay.id_orders=order_printer.id_orders)-sum(sum_all) as b from order_printer 
group by id_orders) as a 
where a.b>='0';