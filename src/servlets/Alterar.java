package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noticia;
import service.NoticiaService;

@WebServlet("/Alterar.do")
public class Alterar extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		String texto = request.getParameter("texto");
		
		Noticia noticia = new Noticia(titulo, descricao, texto);
		noticia.setId(id);
		NoticiaService service = new NoticiaService();
		service.alterarNoticia(noticia);
		
		response.sendRedirect("Noticia.do?id="+id);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter saida = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		NoticiaService service = new NoticiaService();
		Noticia noticia = service.consultarNoticia(id);
		
		saida.println("<body style='background-color: #e5e5e5'>");
			saida.println("<div style='width: 800px; margin: 0 auto; background-color: #FFF; padding: 20px; box-sizing: border-box;'>");
				saida.println("<h1 style='margin-bottom: 0px'>REAL NEWS</h1>");
				saida.println("<hr>");
				saida.println("<form action='Alterar.do' method='POST'>");
					saida.println("<input type='hidden' value='"+id+"' name='id'>");
					saida.println("Titulo: <input type='text' value='"+noticia.getTitulo()+"' name='titulo'><br><br>");
					saida.println("Descrição: <textarea name='descricao'>"+noticia.getDescricao()+"</textarea><br><br>");
					saida.println("Texto: <textarea name='texto'>"+noticia.getTexto()+"</textarea><br>");
					saida.println("<input type='submit' value='Alterar'>");
				saida.println("</form>");
			saida.println("</div>");
		saida.println("</body>");
	}
}
