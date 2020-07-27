package com.ITAcademy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ITAcademy.dto.Game;

public interface IGameDAO extends JpaRepository<Game,Long> {

}
