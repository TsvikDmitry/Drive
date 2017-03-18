SELECT pf.idPrinter, pp.namePrinter, ff.idFormat, pp.namePrinter FROM copydrive.printer_format pf
inner join printer pp on pp.idPrinter=pf.idPrinter
inner join format ff on ff.idFormat=pf.idFormat ;