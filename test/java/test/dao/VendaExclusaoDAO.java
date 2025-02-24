package test.dao;

import exception.DAOException;
import exception.TipoChaveNaoEncontradaException;
import main.Venda;
import main.dao.GenericDAO;
import main.dao.IVendaDAO;

public class VendaExclusaoDAO extends GenericDAO<Venda, Long> implements IVendaDAO {

	public VendaExclusaoDAO() {
		super(Venda.class);
	}

	@Override
	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	public Venda consultarComCollection(Long id) {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

}
