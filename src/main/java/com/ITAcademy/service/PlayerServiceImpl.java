package com.ITAcademy.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ITAcademy.dao.IGameDAO;
import com.ITAcademy.dao.IPlayerDAO;
import com.ITAcademy.dto.Game;
import com.ITAcademy.dto.Player;




@Service
public class PlayerServiceImpl implements IPlayerService {
	
	//Utilizamos los métodos de la interface IPlayerDAO, es como si instanciaramos
	@Autowired
	IPlayerDAO iplayerDAO;
	@Autowired
	IGameDAO igameDAO;
	
	@Override
	public List<Player> listPlayer(){
		return iplayerDAO.findAll();
	}

	@Override
	public Player savePlayer(Player player) {
		return iplayerDAO.save(player);
	}
	
	@Override
	public Player playerXID(Long id) {
		return iplayerDAO.findById(id).get();
	}
	
	@Override
	public Player updatePlayer(Player player) {
		return iplayerDAO.save(player);
	}
	
	@Override
	public void eliminatePlayer(Long id) {
		iplayerDAO.deleteById(id);
	}

	//Devuelve el listado de jugadas por jugador
	
	public List<Game> playerIdgames(Long id) { //declaro el metodo
		List<Game> games = new ArrayList<Game>();//declaro lista games
		List<Game> allGamesPlayer = new ArrayList<Game>();//declaro la lista de todos los juegos de un solo jugador
		games = igameDAO.findAll();//le asigno el valor a la lista game de todos los juegos
		for(Game game: games) {// recorro lista juego a juego
			if(game.getPlayer().getid()==id) {//comparo el id del jugador con el id que le estoy pasando
				allGamesPlayer.add(game); // si se cumple empiezo a añadir en la lista
			}
		}
		return allGamesPlayer;	//devuelvo lista con los jugadores que cumplen la condición
	}

	// Método que devuelve el listado de todos los jugadores y su porcentaje medio de exitos
	public List<Player> listPlayeraverage() {
		double countgames;
		double countwingames;
		double countpoints;
		double average;
		List<Player> averageplayers=new ArrayList<Player>();
		List<Game> games= new ArrayList<Game>();
		averageplayers = iplayerDAO.findAll();
		games = igameDAO.findAll();
		for(Player player: averageplayers) {
			countgames = countwingames = countpoints = 0;
			for (Game game: games) {
				if(game.getPlayer().getid() == player.getid()) {
					countgames = countgames + 1;
					countpoints = countpoints + game.getScore();
					if((game.getone()+game.gettwo())== 7) {
						countwingames= countwingames+1;
					}
				} 
				
			} player.setTotalgames((int) countgames);//casteo para que me de una variable int
			  player.setWingames((int) countwingames);
			  player.setPoints((int) countpoints);
			  if(countgames==0) { //para que no divida por cero y me de un error 
				  player.setAverage(0); //seteo a cero
				  
			  }else {
			  	  average =(countwingames/countgames)/games.size()*100;
				   
				  player.setAverage(average);
				  System.out.println(countwingames);
				    System.out.println(countgames/games.size());
				  
			  }
			  savePlayer(player);//actualizo y guardo el valor en tabla
		} 
		
		
		
		return averageplayers;//devuelvo lista de jugadores con todos los campos
		
	}
	//Método que devuelve el ranking de todos los jugadores
	
	public List<Player> listPlayerranking() {
		int countRanking=0;
		List<Player>rankingPlayers = new ArrayList<>();
		rankingPlayers = listPlayeraverage();//aprovecho lista de average
		Collections.sort(rankingPlayers, Comparator.comparing(Player::getAverage).reversed());//ordeno de mayor a menor media (average)
		
		for(Player player: rankingPlayers) { //recorro mi lista ordenada
			countRanking= countRanking +1; // hago un contador 
			player.setRanking(countRanking);//asigno al valor de ranking 1,2...
			savePlayer(player);//actualizo en tabla cada jugador
		}
		
		return rankingPlayers;//devuelvo lista con el campo de ranking rellenado
	}
	
	//Método que devuelve el jugador con peor porcentaje de éxito
	public Player showLooser() {
		List<Player>rankingPlayers = new ArrayList<>();
		rankingPlayers = listPlayeraverage();
		Collections.sort(rankingPlayers, Comparator.comparing(Player::getAverage).reversed());
		
		return rankingPlayers.get(rankingPlayers.size()-1);//al estar ordenada cojo el último valor que es el de la media más baja
	}
	//Método que devuelve el jugador con mejor porcentaje de éxito
	public Player showWinner() {
		List<Player>rankingPlayers = new ArrayList<>();
		rankingPlayers = listPlayeraverage();
		Collections.sort(rankingPlayers, Comparator.comparing(Player::getAverage).reversed());
		
		return rankingPlayers.get(0);
		
	}

	public String eliminateroll(Long id) {
		String message="";
		List<Game>games=new ArrayList<>();
		games = igameDAO.findAll();
		for(Game game: games) {
		if(game.getPlayer().getid()== id) {
			igameDAO.deleteById(game.getid());
			message="We have eliminated all games of player with this id ... "+id;
		}else {
			message="This player with this id " +id  + " has not games";
		}
		
	}
		
	return message;
	} 
}
	
