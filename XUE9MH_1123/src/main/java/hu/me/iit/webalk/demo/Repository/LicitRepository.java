package hu.me.iit.webalk.demo.Repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface LicitRepository extends PagingAndSortingRepository<Licit, Long> {

	Optional<Licit> findTopByOrderByLicitDesc();

	Optional<Licit> findTopByUserIdOrderByLicitDesc(Integer userid);
	
}
