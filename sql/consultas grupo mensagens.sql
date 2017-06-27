-- Inserir Mensagem

id_remetente = select id_usu from usuario where cpf_usu = ?;


insert into grupo_mensagem_conteudo (id_remetente_men, hora_data_men, conteudo_men)
values(id_remetente, ?, ?);

id_trabalho = select id_tra from trabalho where id_tra = ?;

insert into grupo_mensagem (id_trabalho_gru, hora_data_men)
values(id_trabalho, ?);


-- Buscar Mensagem

create view view_mensagem_grupo as
(select conteudo_men, hora_data_men 
from ((mensagem 
inner join grupo_mensagem_conteudo on id_trabalho_con = id_trabalho_gru)
inner join grupo_mensagem on id_trabalho_gru = id_tra)

);