package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dto.Player;

public interface IPlayerDAO extends JpaRepository<Player,Long>  {

}
