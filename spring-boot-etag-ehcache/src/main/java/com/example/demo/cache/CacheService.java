package com.example.demo.cache;

import java.util.List;

import com.example.demo.board.BoardDto;

public interface CacheService {
	
	public List<BoardDto> getAllBoardData();
	public void saveBoardData(BoardDto boardDto);
	public void saveAllBoardData(List<BoardDto> boardList);
}
