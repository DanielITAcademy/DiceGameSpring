package com.ITAcademy.service;

import java.util.List;

import com.ITAcademy.dto.Player;

public interface IPlayerService {
	
	//Métodos del CRUD
	public List<Player> listPlayer();//Listar All player
	public Player savePlayer(Player player);//Guarda un Player CREATE
	public Player playerXID(Long idPlayer); //Leer datos de un player READ
	public Player updatePlayer(Player player);//Actualiza datos del Player UPDATE
	public void eliminatePlayer(Long idPlayer);//Elimina el player DELETE

}
