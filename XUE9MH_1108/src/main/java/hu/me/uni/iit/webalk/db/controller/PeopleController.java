package hu.me.uni.iit.webalk.db.controller;

import java.util.ArrayList;
import java.util.List;

import hu.me.uni.iit.webalk.db.service.People;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.me.uni.iit.webalk.db.service.PeopleService;

@RestController
@RequestMapping("/people")
public class PeopleController {
    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        super();
        this.peopleService = peopleService;
    }

    @GetMapping
    public  Iterable<PeopleDto> getAllPeople(){
        List<PeopleDto> peopleDtoList = new ArrayList<>();
        for (People people : peopleService.getAllPeople()) {
            peopleDtoList.add(new PeopleDto(people));
        }
        return peopleDtoList;
    }

    public PeopleDto save(PeopleCreateDto peopleCreateDto){
        return new PeopleDto(peopleService.create(peopleCreateDto.toPeople()));
    }
}
