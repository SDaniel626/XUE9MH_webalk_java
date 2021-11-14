package hu.me.uni.iit.webalk.db.service;

import hu.me.uni.iit.webalk.db.repository.PeopleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService {

    private final PeopleRepository peopleRepository;

    public PeopleServiceImpl(PeopleRepository peopleRepository) {
        super();
        this.peopleRepository = peopleRepository;
    }

    @Override
    public Iterable<People> getAllPeople() {
        List<People> rv = new ArrayList<>();
        for (hu.me.uni.iit.webalk.db.repository.People people: peopleRepository.findAll()) {
            rv.add(new People(people));
        }
        return rv;
    }

    @Override
    public People create(People people) {
        return new People(peopleRepository.save(people.toEntity()));
    }

}