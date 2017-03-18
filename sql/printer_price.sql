SELECT pf.id_printer_price, pp.idPrinter, pp.namePrinter, ff.idFormat, ff.nameFormat, 
 pf.print_count, pf.print_cost, pf.id_price, pr.namePrice FROM printer_price pf
inner join printer pp on pp.idPrinter=pf.id_printer
inner join format ff on ff.idFormat=pf.id_format
inner join price pr on pr.idPrice=pf.id_price
 where pf.id_printer=2 and pf.id_format=1  and pf.print_count>1
group by pf.id_price;
