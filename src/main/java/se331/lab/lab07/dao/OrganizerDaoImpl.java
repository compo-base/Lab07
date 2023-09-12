package se331.lab.lab07.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import jakarta.annotation.PostConstruct;
import se331.lab.lab07.entity.Organizer;

@Repository
public class OrganizerDaoImpl implements OrganizerDao{

  List<Organizer> organizerList;

  @PostConstruct
  public void init(){
    organizerList = new ArrayList<>();

    organizerList.add(Organizer.builder()
    .id(1001L)
    .name("Art Enthusiasts")
    .address("Street: Modern Art Lane, Apartment: 3B 10 West 91st Street")
    .description("Engage in modern art exhibitions and discussions.")
    .build());

    organizerList.add(Organizer.builder()
    .id(1002L)
    .name("Tech Innovators")
    .address("Street: Silicon Boulevard, Apartment: 7A 34 North 45th Street")
    .description("Showcase of the latest tech innovations.")
    .build());

    organizerList.add(Organizer.builder()
    .id(1003L)
    .name("Green Planet Advocates")
    .address("Street: Eco Avenue, Apartment: 2C 22 South 23rd Street")
    .description("Promotion of eco-friendly practices and green energy.")
    .build());


    organizerList.add(Organizer.builder()
    .id(1004L)
    .name("Culinary Masters")
    .address("Street: Gourmet Way, Apartment: 5D 15 East 50th Street")
    .description("Showcasing world cuisines and culinary techniques.")
    .build());

    organizerList.add(Organizer.builder()
    .id(1005L)
    .name("Book Lovers Club")
    .address("Street: Literature Lane, Apartment: 9E 101 West 15th Street")
    .description("Book readings, author discussions, and more.")
    .build());

    organizerList.add(Organizer.builder()
    .id(1006L)
    .name("Science Explorers")
    .address("Street: Quantum Road, Apartment: 1F 66 North 67th Street")
    .description("Explore the wonders of science, from atoms to galaxies.")
    .build());

    organizerList.add(Organizer.builder()
    .id(1007L)
    .name("Fitness Fanatics")
    .address("Street: Active Alley, Apartment: 4G 30 East 30th Street")
    .description("Yoga, aerobics, and other fitness events.")
    .build());

    organizerList.add(Organizer.builder()
    .id(1008L)
    .name("History Buffs")
    .address("Street: Time Travel Trail, Apartment: 8H 88 West 88th Street")
    .description("Diving deep into historical events and eras.")
    .build());

    organizerList.add(Organizer.builder()
    .id(1009L)
    .name("Cinema Critics")
    .address("Street: Film Fest Boulevard, Apartment: 6I 55 South 55th Street")
    .description("Screenings and discussions on world cinema.")
    .build());

  }

  @Override
  public Integer getEventSize(){
    return organizerList.size();
  }

  @Override
  public List<Organizer> getEvents(Integer pageSize,Integer page){
    pageSize = pageSize == null ? organizerList.size() : pageSize;
  // if true return eventList.size() but if false return pageSize
    page = page == null ? 1 : page;
    int firstIndex = (page-1)*pageSize;
    return organizerList.subList(firstIndex, firstIndex+pageSize);
  }

  @Override
  public Organizer getEvent(Long id){
    return organizerList.stream().filter(event->event.getId().equals(id)).findFirst().orElse(null);
  }

  
}
