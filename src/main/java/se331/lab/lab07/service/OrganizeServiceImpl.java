package se331.lab.lab07.service;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import se331.lab.lab07.dao.OrganizerDao;
import se331.lab.lab07.entity.Organizer;

@Service
@RequiredArgsConstructor
public class OrganizeServiceImpl implements OrganizerService{

  final OrganizerDao eventDao;

  @Override
  public Integer getEventSize(){
    return eventDao.getEventSize();
  }

  @Override
  public List<Organizer> getEvents(Integer pageSize,Integer page){
    return eventDao.getEvents(pageSize, page);
  }

  @Override
  public Organizer getEvent(Long id){
    return eventDao.getEvent(id);
  }
  
}
