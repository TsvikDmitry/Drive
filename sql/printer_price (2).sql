SELECT 
pf.id_printer_price, pf.id_printer, pf.id_format,pf.id_price,
pp.name_printer,  ff.nameFormat, pr.namePrice,
 pf.count_print, pf.cost_print,   pf.cost_prime_print, pf.visible
 FROM copydrive.printer_price pf
 inner join printer pp on pp.id_printer=pf.id_printer
 inner join format ff on ff.idFormat=pf.id_format
 inner join price pr on pr.idPrice=pf.id_price
 where pf.id_printer=3 and pf.id_format=1  and pf.count_print>1  
 group by pf.id_price;