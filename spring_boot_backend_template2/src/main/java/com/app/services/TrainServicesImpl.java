package com.app.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.Tname;
import com.app.entity.Train;
import com.app.rep.TrainRepsitory;
@Service
@Transactional
public class TrainServicesImpl implements TrainServices {
@Autowired 
	 TrainRepsitory tres;
	@Override
	public String add(Train t) {
		tres.save(t);
		
		return "add suucessfuly";
	}
	@Override
	public String delete(Long Id) {
		// TODO Auto-generated method stub
		tres.deleteById(Id);
		return "delete suucessfuly";
	}
	@Override
	public List<Train> getdetails() {
		
		 return tres.findAll();
	}
	@Override
	public List<Train> searchBytnmae(Tname tname) {
		// TODO Auto-generated method stub
		return tres.findTrainByTname(tname);
	}
	@Override
	public List<Train> SortBytime() {
		// TODO Auto-generated method stub
		return tres.findAllByOrderByStimeAsc();
	}
	@Override
	public void delete(Tname tname) {
		tres.deleteAllByTname(tname);
		
	}
	@Override
	public String update(Train t) {
	 if(tres.existsById(t.getId())) {
		 tres.save(t);
		 
		 return "update successfuly";
		 
	 }
	return "not update";
		
	}

}
