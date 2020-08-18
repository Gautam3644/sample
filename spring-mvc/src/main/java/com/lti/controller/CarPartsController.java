package com.lti.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lti.component.CarPartsInventory;
import com.lti.entity.CarPart;

@Controller
public class CarPartsController {

	@Autowired
	private CarPartsInventory carPartsInventory;

	@RequestMapping("/viewCarParts.req")
	public String getCarParts(Map<String, Object> model) {
		List<CarPart> list = carPartsInventory.getAvailableParts();
		model.put("listOfCarParts", list);
		return "viewCarParts.jsp";
	}
	
	
}
