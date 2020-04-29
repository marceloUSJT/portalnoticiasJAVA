package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noticia;
import service.NoticiaService;

@WebServlet("/CadastrarNoticia.do")
public class CadastrarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		String texto = request.getParameter("texto");
		
		Noticia noticia = new Noticia(titulo, descricao, texto);
		NoticiaService service = new NoticiaService();
		service.cadastrarNoticia(noticia);
		
		response.sendRedirect("cadastrar.html");
	}

}
