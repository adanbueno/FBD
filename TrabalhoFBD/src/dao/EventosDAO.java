package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pojo.Eventos;
import jdbc.ConnectionFactory;

public class EventosDAO {
	
	private Connection connection;

	public EventosDAO() {
		
	}

	public boolean addEventos(Eventos eventos) {
		String sql = "INSERT INTO eventos(dia, id, nome, cidade, atracao) VALUES (?, ?, ?, ?, ?)";
		this.connection = new ConnectionFactory().getConnection();
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setDate(1, eventos.getDia());
			stmt.setInt(2, eventos.getId());
			stmt.setString(3, eventos.getNome());
			stmt.setString(4, eventos.getCidade());
			stmt.setString(5, eventos.getAtracao());

			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if (qtdRowsAffected > 0)
				return true;
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		return false;
	}
	
	public ArrayList<Eventos> getListEventos() {
		String sql = "SELECT * FROM eventos;";
		ArrayList<Eventos> listaEventos = new ArrayList<Eventos>();
		
		this.connection = new ConnectionFactory().getConnection();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				//int dia = String.parseInt(rs.getString("dia"));
				String data = rs.getString("dia");
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String cidade = rs.getString("cidade");
				String atracao = rs.getString("atracao");
				
				Eventos eventos = new Eventos(java.sql.Date.valueOf(data), id, nome, cidade, atracao);
				
				listaEventos.add(eventos);
			}
			stmt.close();
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaEventos;
	}
	
	public boolean deleteEventos(int id) {
		String sql = "DELETE FROM eventos WHERE id= ?  ";
		
		this.connection = new ConnectionFactory().getConnection();

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setInt(1, id);

			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if (qtdRowsAffected > 0)
				return true;
			return false;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean altera(Eventos eventos){
		
		String sql = "update eventos set dia=?, id = ?, nome=?, cidade=?, atracao = ?" + "where id= ?";
		this.connection = new ConnectionFactory().getConnection();
		
		try{
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			
			stmt.setDate(1, eventos.getDia());
			stmt.setInt(2, eventos.getId());
			stmt.setString(3, eventos.getNome());
			stmt.setString(4, eventos.getCidade());
			stmt.setString(5, eventos.getAtracao());
			stmt.setInt(6, eventos.getId());
			
			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			
			if (qtdRowsAffected > 0)
				return true;
			return false;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	public ArrayList<Eventos> getByCidade(String cidade) {
		String sql = "SELECT * FROM eventos where cidade = ?;";
		ArrayList<Eventos> eventos = new ArrayList<Eventos>();

		this.connection = new ConnectionFactory().getConnection();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
	        stmt.setString(1, cidade);
			
			ResultSet rs = stmt.executeQuery();
						
			String nome = null, atracao=null;
			String data=null;
			int id=0;
			while (rs.next()) {
				
				Eventos evento = new Eventos(java.sql.Date.valueOf(data), id, nome, cidade, atracao);

				
				//int dia = String.parseInt(rs.getString("dia"));
		        evento.setId(rs.getInt(0));
		        evento.setNome(rs.getString("nome"));
		        evento.setAtracao(rs.getString("atracao"));
				
		        
				eventos.add(evento);
			}
			stmt.close();
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return eventos;
	}
	
}
