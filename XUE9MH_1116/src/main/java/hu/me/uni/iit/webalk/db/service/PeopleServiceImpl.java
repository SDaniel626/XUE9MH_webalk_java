package hu.me.uni.iit.webalk.db.service;

import hu.me.uni.iit.webalk.db.repository.PeopleRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    @Override
    public void delete(Long id) {
        try{
            peopleRepository.deleteById(id);
        } catch(EmptyResultDataAccessException ex){

        }
    }

    @Override
    public People getByID(Long id) {
        Optional<hu.me.uni.iit.webalk.db.repository.People> optionalPeople = peopleRepository.findById(id);
        if(optionalPeople.isEmpty()) {
            throw new NoSuchEntityException(id);
        }
        return new People(optionalPeople.get());
    }

    @Override
    public void save(People people) {
        Optional<hu.me.uni.iit.webalk.db.repository.People> optionalPeople = peopleRepository.findById(people.getId());
        if(optionalPeople.isEmpty()) {
            throw new NoSuchEntityException(people.getId());
        }
        peopleRepository.save(people.toEntity());
    }

    public Iterable<People> getAllPeople2() {
        return StreamSupport.stream(peopleRepository.findAll().spliterator(),false).map(People::new).collect(Collectors.toList());
    }

}