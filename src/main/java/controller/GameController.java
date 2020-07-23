package controller;

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

import dto.Game;
import service.GameServiceImpl;

@RestController
@RequestMapping("/api")
public class GameController {
	
	@Autowired
	GameServiceImpl gameServiceImpl;
	
	@GetMapping("/game")
	public List<Game> listGame(){
		return gameServiceImpl.listGame();
	}

	@PostMapping("/game")
	public Game saveGame(@RequestBody Game game) {
		return gameServiceImpl.saveGame(game);
	}
	
	@GetMapping("/game/{id}")
	public Game gameXID(@PathVariable(name="id")Long id) {
		Game game_xid= new Game();
		game_xid=gameServiceImpl.gameXID(id);
		System.out.println("Game XID: " +game_xid);
		return game_xid;
	}
	
	@PutMapping("/game/{id}")
	public Game updateGame(@PathVariable(name="id")Long id,@RequestBody Game game) {
		Game game_selected = new Game();
		Game game_updated = new Game();
		
		game_selected = gameServiceImpl.gameXID(id);
		
		game_selected.setDiceOne(game.getDiceOne());
		game_selected.setDiceTwo(game.getDiceTwo());
		game_selected.setScore(game.getScore());
		
		game_updated = gameServiceImpl.updateGame(game_selected);
		System.out.println("The game update is: "+ game_updated);
		return game_updated;
	}
	
	@DeleteMapping("/game/{id}")
	public void eliminateGame(@PathVariable(name="id")Long id) {
		gameServiceImpl.eliminateGame(id);
	}
}
