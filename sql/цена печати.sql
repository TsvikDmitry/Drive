SELECT ordp.*, pp.name_printer, p.name_price, ff.name_format, dup.name_duplex, pap.name_paper, ordp.sum_one-ordp.prime_cost_sum_all as profit
 FROM order_printer ordp
inner join price p on p.id_price=ordp.id_price
inner join format ff on ff.id_format=ordp.id_format
inner join duplex dup on dup.id_duplex=ordp.id_duplex
inner join paper pap on pap.id_paper=ordp.id_paper
inner join printer pp on pp.id_printer=ordp.id_printer