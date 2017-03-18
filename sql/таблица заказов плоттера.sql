SELECT orpl.*, pl.name_plotter, plp.name_paper, orpl.sum_all-orpl.prime_cost_sum_all as profit FROM order_plotter orpl
inner join plotter pl on pl.id_plotter=orpl.id_plotter
inner join plotter_paper plp on plp.id_plotter_paper=orpl.id_plotter_paper