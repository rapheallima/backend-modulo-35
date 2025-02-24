package main.dao;

import exception.DAOException;
import exception.TipoChaveNaoEncontradaException;
import main.Venda;

public interface IVendaDAO extends IGenericDAO<Venda, Long> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

	public Venda consultarComCollection(Long id);
}
