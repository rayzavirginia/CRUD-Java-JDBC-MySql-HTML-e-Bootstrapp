package com.agenciaViagens;

import com.agenciaViagens.dao.ClienteDAO;
import com.agenciaViagens.model.Cliente;

public class Main {

	public static void main(String[] args) {
		
		
		
//-------------------CADASTRAR CLIENTE----------------------------
		
		ClienteDAO clienteDAO = new ClienteDAO();
		
	   Cliente cliente = new Cliente(0, null, null, null, null);
	   cliente.setNomeCliente("Antonia Maria");
	   cliente.setCpfCliente("000.008.000-05");
	   cliente.setEnderecoCliente("Rua 4 Teresina/PI");
	   cliente.setTelefoneCliente("9954-9988");
		
		clienteDAO.save(cliente);  
		 
	
//------- ----VIZUALIZAÇÃO DOS CLIENTES CADASTRADOS---------------
	/*	 ClienteDAO clienteDAO = new ClienteDAO();
		
		for(Cliente c : clienteDAO.getClientes()) {
			System.out.println("Cliente: " +c.getNomeCliente() + "  /  CPF: " +c.getCpfCliente() +
				"  /  Endereço: " + c.getEnderecoCliente() + "  /  Telefone: " + c.getTelefoneCliente());
		}   */ 
		
		 
		
		
//-------------------ATUALIZAR CLIENTE----------------------------
		
		/*ClienteDAO clienteDAO = new ClienteDAO();
		
		Cliente c1 = new Cliente(0, null, null, null, null);
		c1.setIdCliente(17);
		c1.setNomeCliente("José Nascimento");
		c1.setCpfCliente("888.777.484-20");
		c1.setEnderecoCliente("Rua 18, Fortaleza/CE");
		c1.setTelefoneCliente("7777-7777");
		 
		
		clienteDAO.update(c1); */
		
		
//-----------DELETAR CLIENTE PELO NÚMERO DO ID--------------------
		
		//ClienteDAO.deleteByIdCliente(18);
	}
}
