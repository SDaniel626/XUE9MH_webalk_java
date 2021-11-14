package hu.me.uni.iit.webalk.db.repository;

import hu.me.uni.iit.webalk.db.repository.People;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PeopleRepository extends PagingAndSortingRepository<People, Long> {
}
