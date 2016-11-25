package com.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Item;

public interface ItemRepository extends JpaRepository<Item,Integer>{
//	Item saveAndFlush(Item item);
	List<Item> findAll();
}
