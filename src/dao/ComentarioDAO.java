package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Comentario;

import java.sql.ResultSet;

public class ComentarioDAO {
	
	private Connection conexao;
	
	public ComentarioDAO() {
		this.conexao = ConnectionFactory.conectar();
	}

	public void cadastrar(Comentario comentario) {
			
		String inserir = "INSERT INTO comentario "
				+ " (nome, texto, fk_noticia_id) "
				+ " VALUES (?, ?, ?) ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setString(1, comentario.getNome());
			pst.setString(2, comentario.getTexto());
			pst.setInt(3, comentario.getIdNoticia());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Comentario.");
			ex.printStackTrace();
			
		}
	}
	
	public void excluir(Comentario comentario) {
		
		String excluir = "DELETE FROM comentario "
				+ " WHERE fk_noticia_id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(excluir) ) {
			
			pst.setInt(1, comentario.getIdNoticia());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Comentario.");
			ex.printStackTrace();
		}
	}
	
	public ArrayList<Comentario> listarComentarios(int idNoticia) {
		
		String consultar = "SELECT * FROM comentario WHERE fk_noticia_id = ?";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(consultar) ) {
			
			pst.setInt(1, idNoticia);
			ResultSet resultado = pst.executeQuery();
			
			ArrayList<Comentario> lista = new ArrayList<>();
			while (resultado.next()) {
				Comentario p = new Comentario();
				p.setId(resultado.getInt("id"));
				p.setNome(resultado.getString("nome"));
				p.setTexto(resultado.getString("texto"));
				p.setIdNoticia(resultado.getInt("fk_noticia_id"));
				lista.add(p);
			}
			return lista;
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Comentario.");
			ex.printStackTrace();
			
			return null;
		}
	}

}