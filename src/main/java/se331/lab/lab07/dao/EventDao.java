package se331.lab.lab07.dao;

import java.util.List;

import se331.lab.lab07.entity.Event;

public interface EventDao {
  Integer getEventSize();
  List<Event> getEvents(Integer pageSize,Integer page);
  Event getEvent(Long id);
}
