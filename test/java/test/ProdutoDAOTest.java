package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import exception.DAOException;
import exception.MaisDeUmRegistroException;
import exception.TableException;
import exception.TipoChaveNaoEncontradaException;
import main.Produto;
import main.dao.IProdutoDAO;
import main.dao.ProdutoDAO;

public class ProdutoDAOTest {

	private IProdutoDAO produtoDao;

	public ProdutoDAOTest() {
		this.produtoDao = new ProdutoDAO();
	}

	@After
	public void end() throws DAOException {
		Collection<Produto> list = produtoDao.buscarTodos();
		list.forEach(cli -> {
			try {
				produtoDao.excluir(cli);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	@Test
	public void pesquisar()
			throws MaisDeUmRegistroException, TableException, DAOException, TipoChaveNaoEncontradaException {
		Produto produto = criarProduto("A1");
		Assert.assertNotNull(produto);
		Produto produtoDB = this.produtoDao.consultar(produto.getId());
		Assert.assertNotNull(produtoDB);
	}

	@Test
	public void salvar() throws TipoChaveNaoEncontradaException, DAOException {
		Produto produto = criarProduto("A2");
		Assert.assertNotNull(produto);
	}

	@Test
	public void excluir()
			throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
		Produto produto = criarProduto("A3");
		Assert.assertNotNull(produto);
		this.produtoDao.excluir(produto);
		Produto produtoBD = this.produtoDao.consultar(produto.getId());
		assertNull(produtoBD);
	}

	@Test
	public void alterarCliente()
			throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
		Produto produto = criarProduto("A4");
		produto.setNome("Raphael Lima");
		produtoDao.alterar(produto);
		Produto produtoBD = this.produtoDao.consultar(produto.getId());
		assertNotNull(produtoBD);
		Assert.assertEquals("Raphael Lima", produtoBD.getNome());
	}

	@Test
	public void buscarTodos() throws DAOException, TipoChaveNaoEncontradaException {
		criarProduto("A5");
		criarProduto("A6");
		Collection<Produto> list = produtoDao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 2);

		for (Produto prod : list) {
			this.produtoDao.excluir(prod);
		}

		list = produtoDao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 0);

	}

	private Produto criarProduto(String codigo) throws TipoChaveNaoEncontradaException, DAOException {
		Produto produto = new Produto();
		produto.setCodigo(codigo);
		produto.setDescricao("Monitor 1");
		produto.setNome("Monitor 1");
		produto.setValor(BigDecimal.TEN);
		produtoDao.cadastrar(produto);
		return produto;
	}
}
