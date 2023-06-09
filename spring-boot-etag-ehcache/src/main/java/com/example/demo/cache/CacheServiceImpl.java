package com.example.demo.cache;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.board.BoardDto;
import com.example.demo.board.BoardRepository;

@Service("cacheService")
public class CacheServiceImpl implements CacheService{

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Cacheable(value = "boardList")
	@Override
	public List<BoardDto> getAllBoardData() {
		return boardRepository.findAll();
	}
	
	@CacheEvict(value = "boardList", allEntries=true)
	@Override
	public void saveBoardData(BoardDto boardDto) throws IllegalArgumentException{
		Optional.ofNullable(boardDto)
				.ifPresentOrElse(o->{
					boardRepository.save(o);
				}, ()->{
					logger.error("CacheServiceImpl.saveBoardData null parameter value");
					throw new IllegalArgumentException();
				});
		
	}
	
	@CacheEvict(value = "boardList", allEntries=true)
	@Override
	public void saveAllBoardData(List<BoardDto> boardList) throws IllegalArgumentException{
		Optional.ofNullable(boardList)
				.ifPresentOrElse(list->{
					list.forEach(boardDto->{
						saveBoardData(boardDto);
					});
				}, ()->{
					logger.error("CacheServiceImpl.saveAllBoardData null parameter value");
					throw new IllegalArgumentException();
				});
	}
}
