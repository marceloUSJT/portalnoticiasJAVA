package service;

import model.Noticia;
import dao.NoticiaDAO;
import java.util.ArrayList;

public class NoticiaService {
	private NoticiaDAO noticiaDao;
	
	public NoticiaService() {
		this.noticiaDao = new NoticiaDAO();
	}
	
	public ArrayList<Noticia> listarNoticias() {
		ArrayList<Noticia> lista = noticiaDao.listarNoticias();
		
		return lista;
	}
	
	public void cadastrarNoticia(Noticia noticia) {
		noticiaDao.cadastrar(noticia);
	}
	
	public void alterarNoticia(Noticia noticia) {
		noticiaDao.alterar(noticia);
	}
	
	public Noticia consultarNoticia(int id) {
		Noticia noticia = noticiaDao.consultar(id);
		return noticia;
	}
	
	public void excluirNoticia(Noticia noticia) {
		noticiaDao.excluir(noticia);
	}
	
}
