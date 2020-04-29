package model;

public class Noticia implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String titulo;
	private String descricao;
	private String texto;
	
	public Noticia() {
		
	}
	
	public Noticia(String titulo, String descricao, String texto) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.texto = texto;
	}
	
	//SET's
	public void setId(int id) {
		this.id = id;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	//GET's
	public int getId() {
		return this.id;
	}
	public String getTitulo() {
		return this.titulo;
	}
	public String getDescricao() {
		return this.descricao;
	}
	public String getTexto() {
		return this.texto;
	}
	
}
