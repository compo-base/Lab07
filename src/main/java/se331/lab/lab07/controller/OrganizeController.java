package se331.lab.lab07.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import lombok.RequiredArgsConstructor;
import se331.lab.lab07.entity.Organizer;
import se331.lab.lab07.service.OrganizerService;

@Controller
@RequiredArgsConstructor
public class OrganizeController {
    
  final OrganizerService eventService;

  @GetMapping("organizer")
  public ResponseEntity<?> getEventLists(@RequestParam(value = "_limit",required = false)
  Integer perPage,@RequestParam(value = "_page",required = false)Integer page){
  List<Organizer> output = null;
  Integer eventSize = eventService.getEventSize();
  HttpHeaders responseHeaders = new HttpHeaders();
  responseHeaders.set("x-total-count",String.valueOf(eventSize));
  try {
    output = eventService.getEvents(perPage,page);
    return new ResponseEntity<>(output, responseHeaders, HttpStatus.OK);
}catch (IndexOutOfBoundsException ex) {
    return new ResponseEntity<>(output, responseHeaders, HttpStatus.OK);
   }
 }

  
}
