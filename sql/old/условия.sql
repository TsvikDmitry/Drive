select case when (select sum(sum_pay) from order_pay 
where order_pay.id_orders=order_printer.id_orders)-sum(sum_all) = 0.00 then 'Оплачено' else ' Неоплачено' end
from order_printer group by id_orders