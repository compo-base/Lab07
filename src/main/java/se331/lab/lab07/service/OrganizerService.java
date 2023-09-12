package se331.lab.lab07.service;

import java.util.List;
import se331.lab.lab07.entity.Organizer;

public interface OrganizerService {
  Integer getEventSize();
  List<Organizer> getEvents(Integer pageSize,Integer page);
  Organizer getEvent(Long id);
}
