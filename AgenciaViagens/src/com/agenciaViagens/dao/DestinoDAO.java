package com.agenciaViagens.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.agenciaViagens.database.DatabaseConnection;
import com.agenciaViagens.model.Destino;

public class DestinoDAO {

	/*
	 * CRUD
	 * C: CREATE
	 * R: READ
	 * U: UPDATE
	 * D: DELETE
	 */
	
//----------------------------------CREATE----------------------------------------------------

	public void save(Destino destino) {
	    String sql = "INSERT INTO destinos(nomeDestino, estadoDestino, paisDestino, dataDestino, precoDestino) "
	            + "VALUES (?, ?, ?, ?, ?)";
	    
	    Connection conn = null;
	    PreparedStatement pstm = null;
	    
	    try {
	        //criar uma conexão com o banco de dados
	        conn = DatabaseConnection.createConnectionToMySQL();
	        
	        //criamos uma PreparedStatement para executar uma query
	        pstm = conn.prepareStatement(sql);
	        //adicionar os valores que são esperados pela query
	        pstm.setString(1, destino.getNomeDestino());
	        pstm.setString(2, destino.getEstadoDestino());
	        pstm.setString(3, destino.getPaisDestino());
	        pstm.setString(4, destino.getDataDestino());
	        pstm.setString(5, destino.getPrecoDestino());
	        
	        //executar a query
	        pstm.execute();
	        
	        System.out.println("Destino criado com sucesso!");
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        //Fechar as conexões
	        try {
	            if (pstm != null) {
	                pstm.close();
	            }
	            
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}



//------------------------------------READ---------------------------------------------------	
	
		public List<Destino> getDestinos() {
		String sql = "SELECT * FROM destinos";
		
		List<Destino> Destino = new ArrayList<Destino>();
	
		Connection conn = null;
		PreparedStatement pstm = null;
		
		//classe que vai recuperar os dados do banco ***SELECT***
		ResultSet rset = null;
		
		try {
			conn = DatabaseConnection.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Destino destino = new Destino(0, sql, sql, sql, sql, sql);
				
				//recuperar o Id
				destino.setIdDestino(rset.getInt("idDestino"));
				//recuperar o nome
				destino.setNomeDestino(rset.getString("nomeDestino"));
				//recuperar estado
				destino.setEstadoDestino(rset.getString("estadoDestino"));
				//recuperar país
				destino.setPaisDestino(rset.getString("paisDestino"));
				//recuperar data
				destino.setDataDestino(rset.getString("dataDestino"));
				//recuperar preço
				destino.setPrecoDestino(rset.getString("precoDestino"));
				
				
				Destino.add(destino);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rset!=null) {
						rset.close();
					}
					
					if(pstm!=null) {
						pstm.close();
					}
					
					if(conn!=null) {
						conn.close();
					}
				}catch(Exception e) {
				e.printStackTrace();
			    }
			}
		return Destino;
	}
		 
	

//-----------------------------------UPDATE-----------------------------------------------	
	
	
	public void update(Destino destino) {
		String sql = "UPDATE destinos SET nomeDestino = ?, estadoDestino = ?, paisDestino = ?, dataDestino = ?, precoDestino = ? WHERE idDestino = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//criar conexão
			conn = DatabaseConnection.createConnectionToMySQL();
			
			//classe para executar a query
			pstm = conn.prepareStatement(sql);
			
			//adicionar os valores para atualizar
			pstm.setString(1, destino.getNomeDestino());
			pstm.setString(2, destino.getEstadoDestino());
			pstm.setString(3, destino.getPaisDestino());
			pstm.setString(4, destino.getDataDestino());
			pstm.setString(5, destino.getPrecoDestino());
			
			//Qual o id do registro que deseja atualizar
			pstm.setInt(6, destino.getIdDestino());
			
			//Executar a Query
			pstm.execute();
			
			System.out.println("Destino atualizado com sucesso!");
	        }catch (Exception e) {
		      e.printStackTrace();
	        }finally {
		      try {
		         if(pstm!=null) {
			         pstm.close();
		      }
		
		         if(conn!=null) {
			         conn.close();
		      }
	          
		      }catch (Exception e) {
		         e.printStackTrace();
	          }

             }
        }
   
	
	
//-----------------------------------DELETE-----------------------------------------------


	public static void deleteByIdDestino(int idDestino) {
		String sql = "DELETE FROM destinos WHERE idDestino = ?";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		try {
			conn = DatabaseConnection.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, idDestino);
			
			pstm.execute();
			
			System.out.println("Destino deletado com sucesso!");
			
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstm!=null) {
						pstm.close();
					}
					
					if(conn!=null) {
						conn.close();
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
		   }
	  }
}
	
	
	
	
	
	

