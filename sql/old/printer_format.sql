SELECT pp.id as PrintID, pp.name as PrintName, ff.id as FormatID, ff.name as FormatName, pf.visible  FROM copydrive.printer_format pf
inner join printer pp on pp.id=pf.id_printer
inner join format ff on ff.id=pf.id_format ;