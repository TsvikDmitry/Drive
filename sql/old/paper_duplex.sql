SELECT pd.idPaper, pd.idDuplex, d.nameDuplex FROM copydrive.paper_duplex pd
inner join paper p on p.idPaper=pd.idPaper
inner join duplex d on d.idDuplex=pd.idDuplex
where p.idPaper=3;