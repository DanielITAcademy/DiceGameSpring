package com.ITAcademy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ITAcademy.dto.Player;

public interface IPlayerDAO extends JpaRepository<Player,Long>  {

}
