package main;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PRODUTO_QUANTIDADE")
public class ProdutoQuantidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_produto_fk", nullable = false)
	private Produto produto;

	@ManyToOne(cascade = CascadeType.ALL) // Cascata aplicada aqui
	@JoinColumn(name = "id_venda_fk", nullable = false)
	private Venda venda;

	@Column(name = "quantidade", nullable = false)
	private Integer quantidade = 0;

	@Column(name = "valor_total", nullable = false)
	private BigDecimal valorTotal = BigDecimal.ZERO;

	public void adicionar(Integer quantidade) {
		if (quantidade <= 0) {
			throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
		}

		this.quantidade += quantidade;
		this.valorTotal = this.valorTotal.add(produto.getValor().multiply(BigDecimal.valueOf(quantidade)));
	}

	public void remover(Integer quantidade) {
		if (quantidade <= 0) {
			throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
		}

		this.quantidade -= quantidade;
		if (this.quantidade < 0) {
			this.quantidade = 0;
		}

		this.valorTotal = this.valorTotal.subtract(produto.getValor().multiply(BigDecimal.valueOf(quantidade)));
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
