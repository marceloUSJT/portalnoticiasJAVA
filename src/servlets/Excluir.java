package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NoticiaService;
import service.ComentarioService;
import model.Noticia;
import model.Comentario;

@WebServlet("/Excluir.do")
public class Excluir extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Noticia noticia = new Noticia();
		noticia.setId(id);
		Comentario comentario = new Comentario();
		comentario.setIdNoticia(id);
		
		ComentarioService comentarioService = new ComentarioService();
		comentarioService.excluirComentario(comentario);
		
		NoticiaService noticiaService = new NoticiaService();
		noticiaService.excluirNoticia(noticia);
		
		
		response.sendRedirect("Home.do");
	}
}
