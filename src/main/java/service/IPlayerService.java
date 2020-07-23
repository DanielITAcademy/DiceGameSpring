package service;

import java.util.List;

import dto.Player;

public interface IPlayerService {
	
	//Métodos del CRUD
	public List<Player> listPlayer();//Listar All player
	public Player savePlayer(Player player);//Guarda un Player CREATE
	public Player playerXID(Long id); //Leer datos de un player READ
	public Player updatePlayer(Player player);//Actualiza datos del Player UPDATE
	public void eliminatePlayer(Long id);//Elimina el player DELETE

}
