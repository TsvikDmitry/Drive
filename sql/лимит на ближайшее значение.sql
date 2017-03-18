SELECT * FROM binding_work bw
inner join binding_format bf on bf.id_binding_format=bw.id_binding_format
where bw.id_binding_format=1 and bw.sheet_work>66 order by sheet_work limit 1