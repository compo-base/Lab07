package se331.lab.lab07.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import jakarta.annotation.PostConstruct;
import se331.lab.lab07.entity.Event;

@Repository
public class EventDaoImpl implements EventDao{

  List<Event> eventList;

  @PostConstruct
  public void init(){
    eventList = new ArrayList<>();
    eventList.add(Event.builder()
    .id(1001L)
    .category("animal welfare")
    .title("Pat Adoption Day")
    .description("Fine your new Feline friend at this event.")
    .location("Meow Town")
    .date("January  28,2022")
    .time("12.00")
    .petAllowed(true)
    .organizer("Kat Laydee")
    .build());

    eventList.add(Event.builder()
    .id(1002L)
    .category("food")
    .title("Community Gardening")
    .description("Join us as we tendto the community edible ")
    .location("Flora City")
    .date("March 14,2022")
    .time("10.00")
    .petAllowed(true)
    .organizer("Fern Pollin")
    .build());

    eventList.add(Event.builder()
    .id(1003L)
    .category("sustainability")
    .title("Beach Cleanup")
    .description("Help pick up trash along the shore.")
    .location("Playa Del Carmen")
    .date("July 22, 2022")
    .time("11.00")
    .petAllowed(true)
    .organizer("Carey Wales")
    .build());

    eventList.add(Event.builder()
    .id(1004L)
    .category("animal welfare")
    .title(" Dog Adoption Day")
    .description("Find your new canine friend at this event.")
    .location("Woof Town")
    .date("August 28, 2022")
    .time("12.00")
    .petAllowed(true)
    .organizer("Dawg Dahd")
    .build());

    eventList.add(Event.builder()
    .id(1005L)
    .category("food")
    .title("Canned Food Drive")
    .description("Bring your canned food to donate to those in need.")
    .location("Tin City")
    .date("September 14, 2022")
    .time("3:00")
    .petAllowed(true)
    .organizer("Kahn Opiner")
    .build());

    eventList.add(Event.builder()
    .id(1006L)
    .category("sustainability")
    .title("Highway Cleanup")
    .description("Help pick up trash along the highway.")
    .location("Highway 50")
    .date("July 22, 2022")
    .time("11:00")
    .petAllowed(false)
    .organizer("Brody Kill")
    .build());

    eventList.add(Event.builder()
    .id(1007L)
    .category("music")
    .title("Jazz in the Park")
    .description("Enjoy an evening of soothing jazz music in Central Park.")
    .location("Central Park")
    .date("June 12, 2022")
    .time("7:00")
    .petAllowed(true)
    .organizer("Melody Makers")
    .build());

    eventList.add(Event.builder()
    .id(1008L)
    .category("charity")
    .title("Annual Charity Marathon")
    .description("Run for a cause in our annual charity marathon.")
    .location("Downtown City")
    .date("October 5, 2022")
    .time("6:00")
    .petAllowed(false)
    .organizer("Runners Club")
    .build());

    eventList.add(Event.builder()
    .id(1009L)
    .category("technology")
    .title("Tech Expo 2022")
    .description("Discover the latest in tech at our annual expo.")
    .location("Exhibition Center")
    .date("November 20, 2022")
    .time("9:00")
    .petAllowed(false)
    .organizer("Tech Innovators")
    .build());

  }

  @Override
  public Integer getEventSize(){
    return eventList.size();
  }

  @Override
  public List<Event> getEvents(Integer pageSize,Integer page){
    pageSize = pageSize == null ? eventList.size() : pageSize;
  // if true return eventList.size() but if false return pageSize
    page = page == null ? 1 : page;
    int firstIndex = (page-1)*pageSize;
    return eventList.subList(firstIndex, firstIndex+pageSize);
  }

  @Override
  public Event getEvent(Long id){
    return eventList.stream().filter(event->event.getId().equals(id)).findFirst().orElse(null);
  }



  
  
}
