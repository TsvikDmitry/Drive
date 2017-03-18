select *
from (select ryls.id_people,ryls.name,
	IFNULL((select sum(ordp.sum_all) from order_printer  ordp
    inner join orders ord on ord.id_orders=ordp.id_orders 
    where ord.id_operator=ryls.id_people),0) as operator_print,
    
	IFNULL((select sum(dop.sum_all) from order_dop dop
    inner join orders ord on ord.id_orders=dop.id_orders 
    where ord.id_operator=ryls.id_people),0) as operator_dop,
    
    	IFNULL((select sum(ordp.sum_all) from order_printer  ordp
    inner join orders ord on ord.id_orders=ordp.id_orders 
    where ord.id_printing=ryls.id_people),0) as printing_print, 

	
    IFNULL((select sum(dop.sum_all) from order_dop dop
    inner join orders ord on ord.id_orders=dop.id_orders 
    where ord.id_pezchick=ryls.id_people),0) as pezchick_dop

from people ryls 

) as ord ;