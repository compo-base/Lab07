package se331.lab.lab07.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import se331.lab.lab07.entity.Event;

public interface EventRepository extends CrudRepository<Event,Long> {
  List<Event> findAll();

}
