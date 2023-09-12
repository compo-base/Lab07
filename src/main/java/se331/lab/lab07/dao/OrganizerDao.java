package se331.lab.lab07.dao;

import java.util.List;
import se331.lab.lab07.entity.Organizer;

public interface OrganizerDao {
  Integer getEventSize();
  List<Organizer> getEvents(Integer pageSize,Integer page);
  Organizer getEvent(Long id);
  
}
