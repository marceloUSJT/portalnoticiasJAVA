package model;

public class Comentario implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	private String texto;
	private int id_noticia;
	
	public Comentario() {
		
	}
	
	public Comentario(String nome, String texto, int id_noticia) {
		this.nome = nome;
		this.texto = texto;
		this.id_noticia = id_noticia;
	}
	
	//SET's
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public void setIdNoticia(int idNoticia) {
		this.id_noticia = idNoticia;
	}
	
	//GET's
	public int getId() {
		return this.id;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getTexto() {
		return this.texto;
	}
	
	public int getIdNoticia() {
		return this.id_noticia;
	}
}
