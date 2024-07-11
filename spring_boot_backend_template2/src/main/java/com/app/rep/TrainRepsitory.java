package com.app.rep;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Tname;
import com.app.entity.Train;

public interface TrainRepsitory extends JpaRepository<Train, Long> {
  List<Train > findTrainByTname(Tname tname);
  List<Train> findAllByOrderByStimeAsc();
  void deleteAllByTname(Tname tname);
}
