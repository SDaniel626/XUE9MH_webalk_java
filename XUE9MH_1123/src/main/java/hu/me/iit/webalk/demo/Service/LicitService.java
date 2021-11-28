package hu.me.iit.webalk.demo.Service;

public interface LicitService {

	int getHighest();
	
	int getHighestForUser(int userId);

	void saveNewLicit(int licit, int userId);
	

}
