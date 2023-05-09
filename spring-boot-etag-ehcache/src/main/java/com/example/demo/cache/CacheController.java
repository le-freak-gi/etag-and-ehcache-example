package com.example.demo.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.board.BoardDto;

@Controller
@RequestMapping("/cache")
public class CacheController {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CacheService cacheService;

	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public ResponseEntity<Object> getData() {
		return ResponseEntity.ok(cacheService.getAllBoardData());
	}
	
	@ETagAndEHcache(ehcacheName="boardList")
	@RequestMapping(value = "/etag", method = RequestMethod.GET)
	public ResponseEntity<Object> getEtagData() {
		return ResponseEntity.ok(cacheService.getAllBoardData());
	}
    
	@ETagAndEHcache(ehcacheName="boardList")
	@RequestMapping(value = "/post-etag", method = RequestMethod.POST)
	public ResponseEntity<Object> getEtagDataWithPost() {
		return ResponseEntity.ok(cacheService.getAllBoardData());
	}
    
	@RequestMapping(value = "/new-data", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> setData(@RequestBody List<BoardDto> boardList) {
		cacheService.saveAllBoardData(boardList);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("data", cacheService.getAllBoardData());
		return new ResponseEntity<>(result, HttpStatus.valueOf(200));
	}
}
