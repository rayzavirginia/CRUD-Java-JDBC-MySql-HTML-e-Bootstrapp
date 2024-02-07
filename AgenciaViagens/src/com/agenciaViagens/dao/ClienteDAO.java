package com.agenciaViagens.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.agenciaViagens.database.DatabaseConnection;
import com.agenciaViagens.model.Cliente;

public class ClienteDAO {

	/*
	 * CRUD
	 * C: CREATE
	 * R: READ
	 * U: UPDATE
	 * D: DELETE
	 */
	
//----------------------------------CREATE----------------------------------------------------

	public void save(Cliente cliente) {
		String sql = "INSERT INTO Cliente(nomeCliente, cpfCliente, enderecoCliente, telefoneCliente) "
				+ "VALUES (?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//criar uma conexão com o banco de dados
			conn = DatabaseConnection.createConnectionToMySQL();
			
			//criamos uma PreparedStatement para executar uma query
			pstm = conn.prepareStatement(sql);
			//adicionar os valores que são esperados pela query
			pstm.setString(1, cliente.getNomeCliente());
			pstm.setString(2, cliente.getCpfCliente());
			pstm.setString(3, cliente.getEnderecoCliente());
			pstm.setString(4, cliente.getTelefoneCliente());
			
			//executar a query
			pstm.execute();
			System.out.println("Cliente criado com sucesso!");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			//Fechar as conexões
			try {
				if (pstm!= null) {
					pstm.close();
				}
				
				if(conn!= null ) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

	}


	
	
//------------------------------------READ---------------------------------------------------	
	
		public List<Cliente> getClientes() {
		String sql = "SELECT * FROM cliente";
		
		List<Cliente> Cliente = new ArrayList<Cliente>();
	
		Connection conn = null;
		PreparedStatement pstm = null;
		
		//classe que vai recuperar os dados do banco ***SELECT***
		ResultSet rset = null;
		
		try {
			conn = DatabaseConnection.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Cliente cliente = new Cliente(0, sql, sql, sql, sql);
				
				//recuperar o Id
				cliente.setIdCliente(rset.getInt("idCliente"));
				//recuperar o nome
				cliente.setNomeCliente(rset.getString("nomeCliente"));
				//recuperar cpf
				cliente.setCpfCliente(rset.getString("cpfCliente"));
				//recuperar endereço
				cliente.setEnderecoCliente(rset.getString("enderecoCliente"));
				//recuperar telefone
				cliente.setTelefoneCliente(rset.getString("telefoneCliente"));
				
				Cliente.add(cliente);
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
		return Cliente;
	}
		 
	

//-----------------------------------UPDATE-----------------------------------------------	
	
	
	public void update(Cliente cliente) {
		String sql = "UPDATE cliente SET nomeCliente = ?, cpfCliente = ?, enderecoCliente = ?, telefoneCliente = ? WHERE idCliente = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//criar conexão
			conn = DatabaseConnection.createConnectionToMySQL();
			
			//classe para executar a query
			pstm = conn.prepareStatement(sql);
			
			//adicionar os valores para atualizar
			pstm.setString(1, cliente.getNomeCliente());
			pstm.setString(2, cliente.getCpfCliente());
			pstm.setString(3, cliente.getEnderecoCliente());
			pstm.setString(4, cliente.getTelefoneCliente());
			
			//Qual o id do registro que deseja atualizar
			pstm.setInt(5, cliente.getIdCliente());
			
			//Executar a Query
			pstm.execute();
			
			System.out.println("Cliente atualizado com sucesso!");
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


	public static void deleteByIdCliente(int idCliente) {
		String sql = "DELETE FROM Cliente WHERE idCliente = ?";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		try {
			conn = DatabaseConnection.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, idCliente);
			
			pstm.execute();
			
			System.out.println("Cliente deletado com sucesso!");
			
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
	
	
	
	
	
	

