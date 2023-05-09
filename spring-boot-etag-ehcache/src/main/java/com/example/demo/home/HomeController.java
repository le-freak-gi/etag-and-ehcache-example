package com.example.demo.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.cache.CacheService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class HomeController {
	@Autowired
	CacheService cacheService;
	
	
    @RequestMapping("/")
    public String index(Model model) {
    	
    	Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    	String jsonBoardData = gson.toJson(cacheService.getAllBoardData());
        model.addAttribute("boardList", jsonBoardData);
    	
        return "index";
    }
}
