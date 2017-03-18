SELECT plp.id_plotter_price, plp.visible as visible_plotter_price, plc.cost_print+plpc.cost_paper as cost,  plpc.prime_cost_paper+plc.prime_cost_print as prime_cost,

pl.name_plotter,pl.name_plotter_eng, pl.visible as visible_plotter, 

plc.id_plotter, plc.fill, plc.prime_cost_print, plc.visible as visible_plotter_cost,  plc.cost_print,

plpp.name_paper, plpp.name_paper_eng, plpp.visible as visible_paper, 

plpc.id_plotter_paper, plpc.width, plpc.density, plpc.cost_paper, plpc.prime_cost_paper, plpc.visible as visible_paper_cost

FROM plotter_price plp
inner join plotter_cost plc on plc.id_plotter_cost=plp.id_plotter_cost
inner join plotter pl on pl.id_plotter=plc.id_plotter
inner join plotter_paper_cost plpc on plpc.id_plotter_paper_cost=plp.id_plotter_paper_cost
inner join plotter_paper plpp on plpp.id_plotter_paper=plpc.id_plotter_paper

