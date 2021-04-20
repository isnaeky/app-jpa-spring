package com.isnaeky.demo.app.models.dao;

import java.util.List;
import com.isnaeky.demo.app.models.entity.Cliente;

/*
 * Interface para crear los metodos que se implementaran
 * para crear un metodo abstracto solo se declara como si fuera un metodo pero son codigo dentro
 */
public interface IClienteDao {
	
	public List<Cliente> findAll();
	
	public void save(Cliente cliente);

	public Cliente findOne(Long id);
	
	public void delete(Long id);
}
