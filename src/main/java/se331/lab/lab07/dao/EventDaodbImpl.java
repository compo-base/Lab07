package se331.lab.lab07.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;
import se331.lab.lab07.entity.Event;
import se331.lab.lab07.repository.EventRepository;

@Repository
@RequiredArgsConstructor
public class EventDaodbImpl implements EventDao<Event> {

  final EventRepository eventRepository;

  @Override
  public Integer getEventSize(){
    return Math.toIntExact(eventRepository.count());
  }

  @Override
  public List<Event> getEvents(Integer pageSize,Integer page){
    List<Event> events = eventRepository.findAll();
    pageSize = pageSize == null ? events.size() : pageSize;
    page = page == null ?1 :page;
    int firstIndex = (page -1)*pageSize;
    List<Event> output = events.subList(firstIndex, firstIndex+pageSize);
    return output;
  }

  @Override
  public Event getEvent(Long id){
    return eventRepository.findById(id).orElse(null);
  }
  
}
