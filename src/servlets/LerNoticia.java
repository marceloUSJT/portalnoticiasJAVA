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
import model.Comentario;
import service.ComentarioService;

@WebServlet("/Noticia.do")
public class LerNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter saida = response.getWriter();
		
		NoticiaService serviceNoticia = new NoticiaService();
		Noticia noticia = serviceNoticia.consultarNoticia(Integer.parseInt(request.getParameter("id")));
		
		ComentarioService serviceComentario = new ComentarioService();
		ArrayList<Comentario> comentarios = serviceComentario.listarComentarios(noticia.getId());
		
		saida.println("<body style='background-color: #e5e5e5'>");
			saida.println("<div style='width: 800px; margin: 0 auto; background-color: #FFF; padding: 20px; box-sizing: border-box;'>");
				saida.println("<h1 style='margin-bottom: 0px'>REAL NEWS</h1>");
				saida.println("<hr>");
				saida.println("<h2 style='margin-top: 30px'>"+noticia.getTitulo()+"</h2>");
				saida.println("<p>"+noticia.getTexto()+"</p>");
				saida.println("<br>");
				saida.println("<a href='Excluir.do?id="+noticia.getId()+"'>Excluir</a>");
				saida.println("<a href='Alterar.do?id="+noticia.getId()+"'>Editar</a><br>");
				saida.println("<h2>Comentários</h2>");
				comentarios.forEach(c -> {
					saida.println("<div style=' border-bottom: 1px solid black'>");
						saida.println("<h4 style='margin: 0px; padding-top:0px'>"+c.getNome()+"</h4>");
						saida.println("<p style='margin-left:10px; padding-top: 0px'>"+c.getTexto()+"</p>");
					saida.println("</div>");
				});
				saida.println("<form action='CadastrarComentario.do' method='POST'style='margin-top: 10px'> ");
					saida.println("<fieldset>");
						saida.println("<legend style='font-weight: bold;'>Adicionar comentário</legend><br>");
						saida.println("Nome: <input type='text' name='nome' placeholder='Insira seu nome'><br><br	>");
						saida.println("Comentário: <textarea name='comentario' placeholder='Insira seu comentário'></textarea><br><br>");
						saida.println("<input type='hidden' value='" +noticia.getId()+"' name='idNoticia'>");
						saida.println("<input type='submit' value='Comentar'>");
					saida.println("</fieldset>");
				saida.println("</form>");
			saida.println("</div>");
		saida.println("</body>");
		
	}
}
