SELECT prt.idPrinter, prt.namePrinter, f.idFormat, 
f.nameFormat, pap.idPaper, pap.namePaper, pp.densityPaperPrice, 
pp.pricePaperPrice, pp.priceCostPaperPrice 
FROM copydrive.printer_to_paper ppp
inner join printer prt on prt.idPrinter=ppp.IdPrinter
inner join paper_price pp on pp.idPaperPrice=ppp.idPaperPrice
inner join format f on f.idFormat=pp.idFormat
inner join paper pap on pap.idPaper=pp.idPaper
where f.idFormat=1 and prt.idPrinter=1 and pap.idPaper=1 and pp.densityPaperPrice=200;