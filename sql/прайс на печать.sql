SELECT ppr.id_printer_price, pp.name_printer, ff.nameFormat, pri.namePrice,
ppr.cost_print,ppr.cost_prime_print FROM `copydrive.v2`.printer_price ppr
inner join printer pp on pp.id_printer=ppr.id_printer 
inner join format ff on ff.idFormat=ppr.id_format
inner join price pri on pri.idPrice=ppr.id_price
order by name_printer;