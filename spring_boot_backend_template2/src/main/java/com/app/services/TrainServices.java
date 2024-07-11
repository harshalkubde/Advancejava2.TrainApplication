package com.app.services;

import java.time.LocalDateTime;
import java.util.List;

import com.app.entity.Tname;
import com.app.entity.Train;

public interface TrainServices {
	
	String add(Train t);
	String delete(Long Id);
	List<Train> getdetails();
	List<Train> searchBytnmae(Tname tname);
	List<Train> SortBytime();
	void delete(Tname tname);
	String update(Train t);

}
