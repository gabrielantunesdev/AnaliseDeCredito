
  public class Cliente {
  private String nomeDeUsuario;
  private int idade;
  private int score;
  private final String CPF = "123.456.789";
  private double renda;
  private double valorDesejado;
  private boolean aprovado;
  private boolean validacao;
  private int escolha;
  private TipoCarro tipo; // Nao tem sentido get e set aqui!
  
  Cliente(){
	  
  }
  
  Cliente(String nome, int idade, int score, double renda, TipoCarro tipo){
	  this.nomeDeUsuario = nome;
	  this.idade = idade;
	  this.score = score;
	  this.renda = renda;
	  this.tipo = tipo;
  }
  
  
  
  public TipoCarro getTipo() {
	return tipo;
}

public void setTipo(TipoCarro tipo) {
	this.tipo = tipo;
}

public int getEscolha() {
	return escolha;
}
public void setEscolha(int escolha) {
	this.escolha = escolha;
}
public boolean isValidacao() {
	return validacao;
}
  public boolean setValidacao(boolean validacao) {
	return this.validacao = validacao;
}
public boolean isAprovado() {
	return aprovado;
}
public void setAprovado(boolean aprovado) {
	this.aprovado = aprovado;
}
  
  public String getNomeDeUsuario() {
	return nomeDeUsuario;
}
public void setNomeDeUsuario(String nomeDeUsuario) {
	this.nomeDeUsuario = nomeDeUsuario;
}
public int getIdade() {
	return idade;
}
public void setIdade(int idade) {
	this.idade = idade;
}

public int getScore() {
	return score;
}
public void setScore(int score) {
	this.score = score;
}
public double getRenda() {
	return renda;
}
public void setRenda(double renda) {
	this.renda = renda;
}

public double getValorDesejado() {
	return valorDesejado;
}
public void setValorDesejado(double valorDesejado) {
	this.valorDesejado = valorDesejado;
}
public String getCPF() {
	return CPF;
}

@Override
public String toString() {
	return "\nCliente -> Nome: " + nomeDeUsuario + ", idade: " + idade + ", score: " + score + ", CPF: " + CPF
			+ ", renda: " + renda + ", Carro: " + tipo;
}


}

  

