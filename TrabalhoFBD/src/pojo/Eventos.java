package pojo;

public class Eventos {
	private java.sql.Date dia;
	private int id;
	private String nome;
	private String cidade;
	private String atracao;
	
	public java.sql.Date getDia() {
		return dia;
	}
	public void setDia(java.sql.Date dia) {
		this.dia = dia;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getAtracao() {
		return atracao;
	}
	public void setAtracao(String atracao) {
		this.atracao = atracao;
	}
	public Eventos(java.sql.Date dia, int id, String nome, String cidade, String atracao) {
		super();
		this.dia = dia;
		this.id = id;
		this.nome = nome;
		this.cidade = cidade;
		this.atracao = atracao;
	}
	@Override
	public String toString() {
		return "Eventos [dia=" + dia + ", id=" + id + ", nome=" + nome + ", cidade=" + cidade + ", atracao=" + atracao
				+ "]";
	}
	
	
}
