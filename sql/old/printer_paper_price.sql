SELECT ppp.idPrinter, prt.namePrinter, f.idFormat, f.nameFormat FROM copydrive.printer_paper_price ppp
inner join printer prt on prt.idPrinter=ppp.IdPrinter
inner join paper_price pp on pp.idPaperPrice=ppp.idPaperPrice
inner join format f on f.idFormat=pp.idFormat
inner join paper pap on pap.idPaper=pp.idPaper;