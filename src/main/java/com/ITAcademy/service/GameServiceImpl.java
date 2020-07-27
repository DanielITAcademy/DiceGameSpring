package com.ITAcademy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ITAcademy.dao.IGameDAO;
import com.ITAcademy.dto.Game;

@Service
public class GameServiceImpl implements IGameService{
	
	//Utilizamos los métodos de la interface IGameDAO
	@Autowired
	IGameDAO igameDAO;
	
	@Override
	public List<Game> listGame(){
		return igameDAO.findAll();
	}
	
	@Override
	public Game saveGame(Game game) {
		return igameDAO.save(game);
	}

	@Override
	public Game gameXID(Long idGame) {
		return igameDAO.findById(idGame).get();
		
	}
	
	@Override
	public Game updateGame(Game game) {
		return igameDAO.save(game);
	}
	
	@Override
	public void eliminateGame(Long idGame) {
		igameDAO.deleteById(idGame);
	}
}
