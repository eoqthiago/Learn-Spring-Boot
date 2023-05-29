alter table patients add column ativo tinyint;
update patients set ativo = 1;