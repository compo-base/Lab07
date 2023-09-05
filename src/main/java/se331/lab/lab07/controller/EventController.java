package se331.lab.lab07.controller;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import jakarta.annotation.PostConstruct;
import se331.lab.lab07.entity.Event;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;
@Controller
public class EventController {
  List<Event> eventList;

  @PostConstruct
  public void init(){
    eventList = new ArrayList<>();
    eventList.add(Event.builder()
    .id(123L)
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
    .id(456L)
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
    .id(789L)
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
    .id(1001L)
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
    .id(1002L)
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
    .id(1003L)
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
    .id(1004L)
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
    .id(1005L)
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
    .id(1006L)
    .category("technology")
    .title("Tech Expo 2022")
    .description("Discover the latest in tech at our annual expo.")
    .location("Exhibition Center")
    .date("November 20, 2022")
    .time("9:00")
    .petAllowed(false)
    .organizer("Tech Innovators")
    .build());

    eventList.add(Event.builder()
    .id(1007L)
    .category("art")
    .title("Artists' Showcase")
    .description("Explore diverse art forms from local artists.")
    .location("City Art Gallery")
    .date("August 15, 2022")
    .time("10:00")
    .petAllowed(true)
    .organizer("Art Enthusiasts Group")
    .build());
  }

  @GetMapping("events")
  public ResponseEntity<?> getEventLists(@RequestParam(value = "_limit",required = false)
  Integer perPage,@RequestParam(value = "_page",required = false)Integer page){
  perPage = perPage == null?eventList.size():perPage;
  page = page == null?1:page;
  Integer firstIndex = (page-1)*perPage;
  List<Event> output = new ArrayList<>();
  
  HttpHeaders responseHeaders = new HttpHeaders();
  responseHeaders.set("x-total-count",String.valueOf(eventList.size()));
  try {
    for (int i = firstIndex; i < firstIndex + perPage; i++) {
      output.add(eventList.get(i));
  }
    return new ResponseEntity<>(output, responseHeaders, HttpStatus.OK);
}catch (IndexOutOfBoundsException ex) {
    return new ResponseEntity<>(output, responseHeaders, HttpStatus.OK);
   }
 }

 @GetMapping("events/{id}")
  public ResponseEntity<?> getEvent(@PathVariable("id")Long id){
    Event output = null;
    for(Event event : eventList){
      if(event.getId().equals(id)){
        output = event;
        break;
      }
    }
    if(output != null){
      return ResponseEntity.ok(output);
    }else{
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "the given id is not found");
    }
  }


}
  