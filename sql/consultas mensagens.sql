select cpf_usu,id_usu, nome_inf, id_remetente_men, id_destinatario_men, 
hora_data_men, conteudo_men from usuario
inner join info_usuario on id_usu = id_inf
inner join mensagem on id_remetente_men=id_usu where 
(id_remetente_men='1' and id_destinatario_men='3') 
or (id_remetente_men='3' and id_destinatario_men='1');id_destinatario ;


insert into mensagem (id_remetente_men,id_destinatario_men, conteudo_men) 
values('3','1','conteudo 2');