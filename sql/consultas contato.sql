-- insert
-- a ideia do insert foi fazer dois inserts, invertendo as entradas, isso facilitou nossa busca
-- em detrimento de uma redundancia nesta tabela
insert into contato values(?,?);

-- Atenção:
-- nesta tabela a chave primaria deveria ser composta, inicialmente colocamos apenas um ID auto_increment como chave,
-- porém, detectamos que era possível adicionar mais de uma vez o mesmo contato. Isso acontece pois a chave primaria
-- deveria ser (id_mensagem + cpf_remetente + cpf_destinatario). A


--delete
delete from contato where id_usu_a = ? and id_usu_b = ?;


--buscar todos usuarios para busca e adição como contato
SELECT * FROM usuario join info_usuario on id_usu = id_inf;


-- consulta de contato
select nome_inf, cpf_usu, id_usu from info_usuario
	inner join (select id_usu, cpf_usu from usuario 
		inner join(select id_usu_b from contato where id_usu_a = ?) as cont 
		on cont.id_usu_b = cpf_usu) as id_cont
	on id_inf = id_cont.id_usu;
    



