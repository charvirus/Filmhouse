package ac.kr.hoseo.fh.movie;

	
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Integer>{
	

	List<Movie> list();
	
	List<Movie> findAll(Pageable page);
	
	List<Movie> findByNameContains(String name,Pageable page);
	
	Movie findById(int id);
	
	List<Movie> findByGenreContains(String genre,Pageable page);
	
	List<Movie> findByMadeCon(String madeCon,Pageable page);
	
	List<Movie> findByDirector(String director,Pageable page);
	
	List<Movie> findBymainActor(String mainActor,Pageable page);


}
