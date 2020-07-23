package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dto.Game;

public interface IGameDAO extends JpaRepository<Game,Long> {

}
