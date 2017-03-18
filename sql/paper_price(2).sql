SELECT pp.idPaperPrice, pp.idPaper, pa.namePaper, fpp.nameFormat, pp.densityPaperPrice, pp.pricePaperPrice, pp.priceCostPaperPrice FROM `copydrive.v2`.paper_price pp
inner  join paper pa on pa.idPaper=pp.idPaper
inner  join format fpp on fpp.idFormat=pp.idFormat 
order by pp.idPaper;