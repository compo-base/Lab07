package se331.lab.lab07.dao;

import java.util.List;

public interface EventDao<T> {
  Integer getEventSize();
  List<T> getEvents(Integer pageSize,Integer page);
  T getEvent(Long id);
}
