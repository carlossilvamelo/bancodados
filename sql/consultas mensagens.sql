-- Inserir Mensagem

id_remetente = select id_usu from usuario where cpf_usu = ?;
id_destinatario = select id_usu from usuario where cpf_usu = ?;

insert into mensagem (id_remetente_men, id_destinatario_men, hora_data_men, conteudo_men)
values(id_remetente, id_destinatario, ?, ?);

-- Buscar Mensagem

select (conteudo_men, hora_data_men) from mensagem where id_remetente_men = id_remetente and id_destinatario_men = id_destinatario ;