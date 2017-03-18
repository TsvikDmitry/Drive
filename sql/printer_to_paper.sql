SELECT prt.id_printer, prt.name_printer, f.id_format, 
 f.name_format, pap.id_paper, pap.name_paper, pp.density_paper,  pp.cost_paper, pp.prime_cost_paper 
FROM printer_to_paper ppp
inner join printer prt on prt.id_printer=ppp.id_printer
inner join paper_price pp on pp.id_paper_price=ppp.id_paper_price
inner join format f on f.id_format=pp.id_format
inner join paper pap on pap.id_paper=pp.id_paper  where f.id_format=1 and prt.id_printer=2    and pp.density_paper=150;
