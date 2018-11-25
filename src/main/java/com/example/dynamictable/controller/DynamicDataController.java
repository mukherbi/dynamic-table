package com.example.dynamictable.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dynamictable.model.MenuDto;
import com.example.dynamictable.model.QueryResultDetails;
import com.example.dynamictable.model.SubMenuDto;
import com.example.dynamictable.model.ViewConfigEntity;
import com.example.dynamictable.repository.QueryDetailsRepository;
import com.example.dynamictable.repository.ViewConfigRepo;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DynamicDataController {

	@Autowired
	private QueryDetailsRepository repository;

	@Autowired
	private ViewConfigRepo viewRepo;

	@GetMapping("/data")

	@Transactional()
	public QueryResultDetails getData(@RequestParam(required = false) boolean getAllData) {
		return repository.getData(getAllData);
	}

	@GetMapping("/menu")
	@Transactional()
	public List<MenuDto> getMenu() {
		List<MenuDto> menuDtos = new ArrayList<>();
		Iterable<ViewConfigEntity> configs = viewRepo.findAllByOrderByItemNumberAsc();
		Map<Integer, MenuDto> dtoMap = new HashMap<>();

		for (ViewConfigEntity config : configs) {
			Integer switchBoard = config.getSwitchBoard();
			Integer itemNumber = config.getItemNumber();
			if (999 != switchBoard && 0 == itemNumber) {
				MenuDto parentMenu = new MenuDto();
				parentMenu.setId(config.getId());
				parentMenu.setItemNumber(itemNumber);
				parentMenu.setSwitchBoard(switchBoard);
				parentMenu.setMenuLabel(config.getMenuLabel());
				parentMenu.setSubMenus(new ArrayList<>());
				dtoMap.put(switchBoard, parentMenu);
			} else {
				SubMenuDto subMenu = new SubMenuDto();
				subMenu.setId(config.getId());
				subMenu.setItemNumber(itemNumber);
				subMenu.setSwitchBoard(switchBoard);
				subMenu.setMenuLabel(config.getMenuLabel());
				subMenu.setViewId(config.getViewId());

				MenuDto menuDto = dtoMap.get(switchBoard);
				if(menuDto != null)
				menuDto.getSubMenus().add(subMenu);
			}
		}

		menuDtos.addAll(dtoMap.values());
		return menuDtos;

	}

}
