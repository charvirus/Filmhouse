package ac.kr.hoseo.fh.actor;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import ac.kr.hoseo.fh.movie.Movie;

public interface ActorRepository extends CrudRepository<Actor, Integer>{
	List<Actor> findByMovie(Movie name, Pageable page);
}
