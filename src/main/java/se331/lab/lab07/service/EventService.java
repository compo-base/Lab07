package se331.lab.lab07.service;

import java.util.List;

public interface EventService<T> {
  Integer getEventSize();
  List<T> getEvents(Integer pageSize,Integer page);
  T getEvent(Long id);
}
