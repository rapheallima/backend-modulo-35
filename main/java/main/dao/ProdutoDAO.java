package main.dao;

import main.Produto;

public class ProdutoDAO extends GenericDAO<Produto, Long> implements IProdutoDAO {

	public ProdutoDAO() {
		super(Produto.class);
	}

}
