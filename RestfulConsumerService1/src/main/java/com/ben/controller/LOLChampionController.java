package com.ben.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ben.model.LOLChampion;

@RestController
public class LOLChampionController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	/* Use this in Postman 
	 * http://localhost:6060/lolchampion?id=2
	 */
	@GetMapping("/lolchampion")
	public LOLChampion getLOLChampion(@PathParam(value = "id") long id) {
		ResponseEntity<LOLChampion> lolChampion = restTemplate.getForEntity("http://localhost:8080/leagueOfLegends/champions/" + id, LOLChampion.class);
		return lolChampion.getBody();
	}

}