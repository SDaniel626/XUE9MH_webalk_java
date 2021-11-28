package hu.me.uni.iit.webalk.db.controller;

import java.util.ArrayList;
import java.util.List;

import hu.me.uni.iit.webalk.db.service.People;
import org.springframework.web.bind.annotation.*;

import hu.me.uni.iit.webalk.db.service.PeopleService;

import javax.validation.Valid;

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

    @PostMapping(consumes = "application/json")
    public PeopleDto save(@RequestBody @Valid PeopleCreateDto peopleCreateDto){
        return new PeopleDto(peopleService.create(peopleCreateDto.toPeople()));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        peopleService.delete(id);
    }

    @GetMapping("/{id}")
    public PeopleDto getById(@PathVariable("id") Long id) {
        return new PeopleDto(peopleService.getByID(id));
    }

    @PutMapping
    void save(@RequestBody @Valid PeopleDto peopleDto){
        peopleService.save(peopleDto.toPeople());
    }

    /*@GetMapping("/findByAgeGt")
    Iterable<PeopleDto> findAdultPeople(@RequestParam("")){

    }*/

    //HF PATCH
}
