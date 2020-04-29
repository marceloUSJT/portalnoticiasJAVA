package service;

import model.Comentario;
import dao.ComentarioDAO;
import java.util.ArrayList;

public class ComentarioService {
	private ComentarioDAO comentarioDao;
	
	public ComentarioService() {
		this.comentarioDao = new ComentarioDAO();
	}
	
	public ArrayList<Comentario> listarComentarios(int idNoticia) {
		ArrayList<Comentario> lista = comentarioDao.listarComentarios(idNoticia);
		
		return lista;
	}
	
	public void cadastrarComentario(Comentario comentario) {
		comentarioDao.cadastrar(comentario);
	}
	
	public void excluirComentario(Comentario comentario) {
		comentarioDao.excluir(comentario);
	}

}
