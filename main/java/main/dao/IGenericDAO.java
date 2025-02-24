package main.dao;

import java.io.Serializable;
import java.util.Collection;

import exception.DAOException;
import exception.MaisDeUmRegistroException;
import exception.TableException;
import exception.TipoChaveNaoEncontradaException;

public interface IGenericDAO<T extends Persistente, E extends Serializable> {

	public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

	public void excluir(T entity) throws DAOException;

	public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

	public T consultar(E id) throws MaisDeUmRegistroException, TableException, DAOException;

	public Collection<T> buscarTodos() throws DAOException;
}
