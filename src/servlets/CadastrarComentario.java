package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Comentario;
import service.ComentarioService;

@WebServlet("/CadastrarComentario.do")
public class CadastrarComentario extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		String nome = request.getParameter("nome");
		String texto = request.getParameter("comentario");
		int idNoticia= Integer.parseInt(request.getParameter("idNoticia"));
		
		Comentario comentario = new Comentario(nome, texto, idNoticia);
		ComentarioService service = new ComentarioService();
		service.cadastrarComentario(comentario);
		
		
		response.sendRedirect("Noticia.do?id="+comentario.getIdNoticia());
	}

}
