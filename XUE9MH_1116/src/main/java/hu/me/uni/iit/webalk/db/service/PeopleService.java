package hu.me.uni.iit.webalk.db.service;

public interface PeopleService {
    Iterable<People> getAllPeople();

    People create(People toPeople);

    void delete(Long id);

    People getByID(Long id);

    void save(People people);
}
