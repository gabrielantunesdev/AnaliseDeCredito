
public class Carro {

	
	private TipoCarro nome;
	private double preco;
	private double entrada;
	
	public double getEntrada() {
		return entrada;
	}
	public void setEntrada(double entrada) {
		this.entrada = entrada;
	}
	public TipoCarro getNome() {
		return nome;
	}
	public void setNome(TipoCarro tipo) {
		this.nome = tipo;
	}
	public double getPreco() {
		return preco;
	}
	public double setPreco(double preco) {
		return this.preco = preco;
	}
	@Override
	public String toString() {
		return String.format("Carro -> %s - Preço -> R$%.0f\n", nome, preco);
	}
	
	
}
