package com.ITAcademy.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ITAcademy.dto.Dice;
import com.ITAcademy.dto.Game;
import com.ITAcademy.dto.Player;
import com.ITAcademy.service.GameServiceImpl;
import com.ITAcademy.service.PlayerServiceImpl;

@RestController
@RequestMapping("/api")
public class PlayerController {

	@Autowired
	PlayerServiceImpl playerServiceImpl;
	@Autowired
	GameServiceImpl gameServiceImpl;
	
	// POST: /players : crea un jugador
	@PostMapping("/players")
	public Player savePlayer(@RequestBody Player player) {
		return playerServiceImpl.savePlayer(player);
	}
	
	
	// PUT /players : modifica el nom del jugador
	@PutMapping("players/{id}")
	public Player updatePlayer(@PathVariable(name="id")Long id,@RequestBody Player player) {
		Player player_selected = new Player();
		Player player_updated = new Player();
		
		player_selected = playerServiceImpl.playerXID(id);
		
		player_selected.setname(player.getname());
		player_selected.setdate(player.getDate());
		
		player_updated = playerServiceImpl.updatePlayer(player_selected);
		
		System.out.println("Player update is: " + player_updated);
		
		return player_updated;
		
	}
	
	// POST /players/{id}/games/ : un jugador específic realitza una tirada dels daus.
	
		@PostMapping("/players/{id}/games")
		public String diceplay(@PathVariable(name = "id")Long id) {
			Dice diceone = new Dice();
			Dice dicetwo = new Dice();
			String sms = "";
			int score = 0;
		
			Player player = new Player();
			Game game = new Game();
			
			player=playerServiceImpl.playerXID(id);
			game.setPlayer(player);
			
			List <Game> games = new ArrayList<>();// declaro lista games
			
			game.setone(diceone.getRoll());//modificamos set cada vez que recorro el bucle
			game.settwo(dicetwo.getRoll());
			game.setScore(diceone.getRoll()+dicetwo.getRoll());
			score=diceone.getRoll()+dicetwo.getRoll();
			
			gameServiceImpl.saveGame(game);//mando objeto game modificado para que lo actualize en la tabla
			
			if(score==7) {//comparativa
				sms="you are the best";
			} else {
				sms="Try again";
			}
		
			return "Dice one "+diceone.getRoll()+ " Dice two " + dicetwo.getRoll() + "The score is "+ score + sms; //devuelve valores
			
		}
		
	//DELETE /players/{id}/games: elimina les tirades del jugador.
		
		@DeleteMapping("/players/{id}/games")
		public String deletegames(@PathVariable(name="id")Long id) {
		return playerServiceImpl.eliminateroll(id);
		
		} 
	// GET /players/: retorna el llistat de tots els jugadors del sistema amb el seu percentatge mig d’èxits 
	
		@GetMapping("/players")
		public List<Player>listPlayeraverage(){ //declaro el metodo de mi lista y si voy a recibir parametros
			List<Player>averageplayers=new ArrayList<>(); // declaro lista y creo lista
			averageplayers = playerServiceImpl.listPlayeraverage(); //asigno valor que me devuelve los campos con las medias
			Collections.sort(averageplayers, Comparator.comparing(Player::getAverage).reversed()); //ordeno del más grande al más pequeño
		return averageplayers; //devuelvo la lista
	}
	
	
	// GET /players/{id}/games: retorna el llistat de jugades per un jugador.
	
		@GetMapping("/players/{id}/games")
		public List <Game> playerIdgames(@PathVariable(name = "id")Long id) {
			
			List <Game> games = new ArrayList<>();
			games = playerServiceImpl.playerIdgames(id);
			return games;
		}
	
	// GET /players/ranking: retorna el ranking mig de tots els jugadors del sistema. És a dir, el percentatge mig d’èxits. 
		
		@GetMapping("/players/ranking")
		public List<Player> listPlayerranking(){
			List<Player>rankingplayers=new ArrayList<>();
			rankingplayers = playerServiceImpl.listPlayerranking();
			Collections.sort(rankingplayers, Comparator.comparing(Player::getRanking));
			return rankingplayers;
		}
			
	//GET /players/ranking/loser: retorna el jugador amb pitjor percentatge d’èxit.
	
	@GetMapping("/players/ranking/looser")
	public Player showLooser() {
		return playerServiceImpl.showLooser();
	}
	
	//GET /players/ranking/winner: retorna el jugador amb pitjor percentatge d’èxit.
	
	@GetMapping("/players/ranking/winner")
	public Player showWinner() {
		return playerServiceImpl.showWinner();
	}
	
	@GetMapping("/players/byid")
	public List<Player>listPlayer(){
		return playerServiceImpl.listPlayer();
	}

	
	
	@GetMapping("/players/{id}")
	public Player playerXID(@PathVariable(name = "id")Long id) {
		Player player_xid = new Player();
		player_xid = playerServiceImpl.playerXID(id);
		System.out.println("Player XID: "+ player_xid);
		return player_xid;
	}
	
	
	
	
	
	@DeleteMapping("/players/{id}")
	public void eliminatePlayer(@PathVariable(name="id")Long id) {
		playerServiceImpl.eliminatePlayer(id);
	}
	
}