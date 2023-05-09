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
	public void saveBoardData(BoardDto boardDto) throws NullPointerException{
		Optional.of(boardDto)
				.ifPresent(o->{
					boardRepository.save(o);
				});
	}
	
	@CacheEvict(value = "boardList", allEntries=true)
	@Override
	public void saveAllBoardData(List<BoardDto> boardList) throws NullPointerException{
		Optional.of(boardList)
				.ifPresent(list->{
					list.forEach(boardDto->{
						boardRepository.save(boardDto);
					});
				});
	}
}
