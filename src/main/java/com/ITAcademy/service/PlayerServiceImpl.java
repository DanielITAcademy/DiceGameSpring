package com.ITAcademy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ITAcademy.dao.IPlayerDAO;
import com.ITAcademy.dto.Player;


@Service
public class PlayerServiceImpl implements IPlayerService {
	
	//Utilizamos los métodos de la interface IPlayerDAO, es como si instanciaramos
	@Autowired
	IPlayerDAO iplayerDAO;
	
	@Override
	public List<Player> listPlayer(){
		return iplayerDAO.findAll();
	}

	@Override
	public Player savePlayer(Player player) {
		return iplayerDAO.save(player);
	}
	
	@Override
	public Player playerXID(Long idPlayer) {
		return iplayerDAO.findById(idPlayer).get();
	}
	
	@Override
	public Player updatePlayer(Player player) {
		return iplayerDAO.save(player);
	}
	
	@Override
	public void eliminatePlayer(Long idPlayer) {
		iplayerDAO.deleteById(idPlayer);
	}
}
