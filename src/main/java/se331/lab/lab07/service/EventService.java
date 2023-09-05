package se331.lab.lab07.service;

import java.util.List;

import se331.lab.lab07.entity.Event;

public interface EventService {
  Integer getEventSize();
  List<Event> getEvents(Integer pageSize,Integer page);
  Event getEvent(Long id);
}
