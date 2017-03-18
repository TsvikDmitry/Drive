select * from (select id_orders, sum(sum_all), (select sum(sum_pay) from order_pay 
where order_pay.id_orders=order_printer.id_orders)-sum(sum_all) as YOUR_FIELD   from order_printer 
group by id_orders) as a 
where a.YOUR_FIELD>='0'
