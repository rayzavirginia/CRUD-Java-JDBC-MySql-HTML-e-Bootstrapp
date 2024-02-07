package com.agenciaViagens;
import com.agenciaViagens.dao.DestinoDAO;
import com.agenciaViagens.model.Destino;

public class MainDestino {
	
public static void main(String[] args) {
		
		
		
//-------------------CADASTRAR DESTINO----------------------------
		
		DestinoDAO destinoDAO = new DestinoDAO();
		
	    Destino destino = new Destino(0, null, null, null, null, null);
	    
		destino.setNomeDestino("Campos do Jordão");
		destino.setEstadoDestino("São Paulo");
		destino.setPaisDestino("Brasil");
		destino.setDataDestino("01/10/24 a 09/10/24");
		destino.setPrecoDestino("R$ 889,00");
		
		destinoDAO.save(destino);  
		 
	
//------- ----VIZUALIZAÇÃO DOS DESTINOS CADASTRADOS---------------
	
	/*	DestinoDAO destinoDAO = new DestinoDAO();
		
		for(Destino d : destinoDAO.getDestinos()) {
			System.out.println("Destino: " +d.getNomeDestino() + "  /  Estado: " +d.getEstadoDestino() +
				"  /  País: " + d.getPaisDestino() + "  /  Data: " + d.getDataDestino() + "  /  Preço: " + d.getPrecoDestino());
		}  */
		
		 
		
		
//-------------------ATUALIZAR DESTINO----------------------------
		
	/*	DestinoDAO destinoDAO = new DestinoDAO();
			
		Destino d1 = new Destino(0, null, null, null, null, null);
		d1.setIdDestino(3);
		d1.setNomeDestino("Lençois Maranhenses");
		d1.setEstadoDestino("Maranhão");
		d1.setPaisDestino("Brasil");
		d1.setDataDestino("05/10/23 a 09/10/23");
		d1.setPrecoDestino("R$ 500,00");
		
		destinoDAO.update(d1);   */
		
		
//-----------DELETAR DESTINO PELO NÚMERO DO ID--------------------
		
		//DestinoDAO.deleteByIdDestino(4);
		
	}
}
	

