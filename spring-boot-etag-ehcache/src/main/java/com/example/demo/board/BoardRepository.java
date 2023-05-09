package com.example.demo.board;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<BoardDto, Integer>{
	
	@Override
	List<BoardDto> findAll();
}
