package com.example.dynamictable.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.dynamictable.model.ViewConfigEntity;

@Repository
public interface ViewConfigRepo extends CrudRepository<ViewConfigEntity, Integer> {

	public List<ViewConfigEntity> findAllByOrderByItemNumberAsc();
	
}
