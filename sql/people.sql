select ord.id_people, ord.name, als, ord.print, ord.print2, ord.plotter, ord.plotter2,  ord.dop, ord.dop2 as dops
from (select ryls.id_people,
	IFNULL((select sum(ordp.sum_all) from order_printer  ordp
    inner join orders ord on ord.id_orders=ordp.id_orders 
    where ord.id_client=ryls.id_people
    ),0) as als, 
	IFNULL((select sum(ordp.sum_all) from order_printer  ordp
    inner join orders ord on ord.id_orders=ordp.id_orders 
    where ord.id_operator=ryls.id_people
    ),0) as print,
    	(IFNULL((select sum(ordp.cost_sum_all) from order_printer  ordp
    inner join orders ord on ord.id_orders=ordp.id_orders 
    where ord.id_operator=ryls.id_people
    ),0))*0.1 as print2,
    	IFNULL((select sum(plo.sum_all) from order_plotter  plo
    inner join orders ord on ord.id_orders=plo.id_orders 
    where ord.id_printing=ryls.id_people
    ),0) as plotter,
        	(IFNULL((select sum(plo.prime_cost_sum_all) from order_plotter  plo
    inner join orders ord on ord.id_orders=plo.id_orders 
    where ord.id_printing=ryls.id_people
    ),0))*0.1 as plotter2,
	IFNULL((select sum(dop.sum_all) from order_dop dop
    inner join orders ord on ord.id_orders=dop.id_orders 
    where ord.id_printing=ryls.id_people
    ),0) as dop ,
	(IFNULL((select sum(dop.prime_cost_sum_all) from order_dop dop
    inner join orders ord on ord.id_orders=dop.id_orders 
    where ord.id_printing=ryls.id_people
    ),0))*0.5 as dop2 , ryls.name
from people ryls 
group by ryls.id_people
) as ord ;