package com.ITAcademy.service;

import java.util.List;

import com.ITAcademy.dto.Game;



public interface IGameService {
	//Métodos del CRUD
		public List<Game> listGame();//Listar All games
		public Game saveGame(Game game);//Guarda un game CREATE
		public Game gameXID(Long id); //Leer datos de un game READ
		public Game updateGame (Game game);//Actualiza datos del game UPDATE
		public void eliminateGame(Long id);//Elimina el juego DELETE

}
