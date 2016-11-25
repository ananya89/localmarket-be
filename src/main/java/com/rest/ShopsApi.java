package com.rest;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Item;
import com.repo.ItemRepository;

@RestController
@RequestMapping("/api")
public class ShopsApi {
	@Autowired
	ItemRepository repo;
	
	@RequestMapping("/searchresult-items.json")
	public List<Item> findItems(){
		System.out.println("returning items ---");
		return repo.findAll();
	}
	
	@Transactional
	@RequestMapping("/create-item/{name}")
	public String createItem(@PathVariable("name")String name){
		Item item  = new Item();
		item.setItemName(name);
		repo.saveAndFlush(item);
		return "success";
	}
}
