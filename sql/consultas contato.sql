insert into contato values(id_a,id_b);
insert into contato values(id_b,id_a);

select * from usuario;

select (nome_usu, id_usu_a, id_usu_b) from contato 
join usuario  on id_usu = id_usu_a or id_usu = id_usu_b;



-- consulta de contato
--part 1
select nome_inf, cpf_usu, id_usu from info_usuario
	inner join (select id_usu, cpf_usu from usuario 
		inner join(select id_usu_b from contato where id_usu_a = '09006369470') as cont 
		on cont.id_usu_b = cpf_usu) as id_cont
	on id_inf = id_cont.id_usu;
    



