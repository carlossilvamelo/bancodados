--inserir docente
insert into usuario (login_usu, cpf_usu, email_usu, cep_usu, tipo_usu)
values();  

select id_usu from usuario where cpf_usu = ?;

insert into identificacao (id_ide, email_ide, senha_ide)
values(id_usu, ?, ?);

insert into endereco_usuario (id_usu_end, rua_end, cep_end, numero_end)
values(id_usu, ?, ?, ?);

insert into info_usuario(id_inf, curriculo_inf, data_nascimento_inf, nome_inf)
values(id_usu, ?, ?, ?);

insert into endereco_complemento (id_end_com, estado_com, rua_com)
values(id_usu, ?, ?);

insert into docente (id_usuario_dis)
values(id_usu);


-- buscar discente por cpf VIEW : view_discente
create view view_docente as
(select id_usu, login_usu, cpf_usu, email_usu, cep_usu, tipo_usu,
rua_end, numero_end, senha_ide, estado_com, curriculo_inf,
 data_nascimento_inf, nome_inf 
from (((((usuario 
inner join endereco_usuario on id_usu_end = id_usu)
inner join identificacao on id_ide = id_usu)
inner join endereco_complemento on id_end_com = id_usu)
inner join info_usuario on id_inf = id_usu)
inner join docente on id_usuario_doc = id_usu));



-- update discente
select id_usu from usuario where cpf_usu = ?;

UPDATE usuario
SET login_usu = ?, cpf_usu = ?, email_usu = ?, cep_usu = ?, tipo_usu = ?
WHERE id_usu = id_usu;

UPDATE endereco_usuario
SET id_usu_end = ?, rua_end = ?, cep_end = ?, numero_end = ?
WHERE id_usu_end = id_usu;

UPDATE endereco_complemento
SET  id_end_com = ?, estado_com =?, rua_com = ?
WHERE id_end_com = id_usu;

UPDATE identificacao
SET email_ide = ?, senha_ide = ?
WHERE id_ide = id_usu;

UPDATE info_usuario
SET curriculo_inf = ?, data_nascimento_inf = ?, nome_inf = ?
WHERE id_inf = id_usu;

UPDATE discente
SET matricula_dis = ?, reputacao_dis = ?
WHERE id_inf = id_usu;


