package hu.me.iit.webalk.demo.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import hu.me.iit.webalk.demo.Repository.Licit;
import hu.me.iit.webalk.demo.Repository.LicitRepository;

@Service
public class LicitServiceImpl implements LicitService {
	private final LicitRepository licitRepository;
	
	public LicitServiceImpl(LicitRepository licitRepository) {
	    this.licitRepository = licitRepository;
	}
	
	@Override
	public int getHighest() {
		Optional<Licit> result = licitRepository.findTopByOrderByLicitDesc();
		if(result.isEmpty()) {
			return 0;
		}
		return result.get().getLicit();
	}

	@Override
	public int getHighestForUser(int userId) {
		Optional<Licit> result = licitRepository.findTopByUseridAndOrderByLicitDesc(userId);
		if(result.isEmpty()) {
			return 0;
		}
		return result.get().getLicit();
	}

	@Override
	public void saveNewLicit(int licit, int userId) {
		licitRepository.save(new Licit(licit, userId));
	}

}
