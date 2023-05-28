alter table doctors add column ativo tinyint;
update doctors set ativo = 1;