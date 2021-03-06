select cpf_usu,id_usu, nome_inf, id_remetente_men, id_destinatario_men, 
hora_data_men, conteudo_men from usuario
inner join info_usuario on id_usu = id_inf
inner join mensagem on id_remetente_men=id_usu where 
(id_remetente_men='1' and id_destinatario_men='3') 
or (id_remetente_men='3' and id_destinatario_men='1') order by id_men asc;


insert into mensagem (id_remetente_men,id_destinatario_men, conteudo_men) 
values('3','1','conteudo 2');

-- Inserir Mensagem

id_remetente = select id_usu from usuario where cpf_usu = ?;
id_destinatario = select id_usu from usuario where cpf_usu = ?;

insert into mensagem (id_remetente_men, id_destinatario_men, hora_data_men, conteudo_men)
values(id_remetente, id_destinatario, ?, ?);

-- Buscar Mensagem

select (conteudo_men, hora_data_men) from mensagem where id_remetente_men = id_remetente and id_destinatario_men = id_destinatario ;
