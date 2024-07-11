package com.app.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Tname;
import com.app.entity.Train;
import com.app.services.TrainServices;
@RestController
@RequestMapping("/tarin")
public class TrainController {
	@Autowired
	private TrainServices tservices;
	@PostMapping
	public ResponseEntity<?> add(@RequestBody Train t){
		if(t!=null) {
			tservices.add(t);
			return ResponseEntity.status(200).body("successfully add");
		}
		
		return ResponseEntity.status(402).body("successfully add");
	}
	@DeleteMapping
	public String delete(Long Id) {
		tservices.delete(Id);
		return "delete succesfully";
	}
	@GetMapping
	public List<Train> display(){
		return tservices.getdetails();
	}
	@GetMapping("{search}")
	public List<Train> searchdbyname(Tname tname){
		return tservices.searchBytnmae(tname);
	}
	@GetMapping("/sort")
	public List<Train> sortbyTime(){
		return tservices.SortBytime();
	}
	@DeleteMapping("/{delete}")
	public void delete (Tname tname ) {
		tservices.delete(tname);
	}
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Train t)
	{
		if(t!=null) {
			return ResponseEntity.status(200).body(tservices.add(t));
		}
		return ResponseEntity.status(402).body(tservices.add(t));
	}


}
