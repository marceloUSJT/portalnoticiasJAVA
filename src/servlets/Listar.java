package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noticia;
import service.NoticiaService;

@WebServlet("/Home.do")
public class Listar extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter saida = response.getWriter();
		
		NoticiaService service = new NoticiaService();
		ArrayList<Noticia> lista = service.listarNoticias();
		
		saida.println("<body style='background-color: #e5e5e5'>");
			saida.println("<div style='width: 800px; margin: 0 auto; background-color: #FFF; padding: 20px; box-sizing: border-box;'>");
			saida.println("<h1 style='text-align: center; margin-bottom: 50px'>REAL NEWS</h1>");
			lista.forEach(p -> {
				saida.println("<h3 style='margin-bottom: 0px'>"+p.getTitulo()+"</h3>");
				saida.println("<p style='margin-top: 5px'>"+p.getDescricao()+" 	...<a href='Noticia.do?id="+p.getId()+"'>Leia mais</a></p>");
				saida.println("<hr>");
			});
			saida.println("<br>");
			saida.println("<a href='cadastrar.html' style='background-color: #707070; color: #FFF; padding: 10px; text-decoration: none;'>PUBLICAR NOTICIAS</a>");
			saida.println("</div>");
		saida.println("</body>");
		
	}
}
