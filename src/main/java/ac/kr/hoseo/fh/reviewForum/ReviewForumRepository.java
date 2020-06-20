package ac.kr.hoseo.fh.reviewForum;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ReviewForumRepository extends CrudRepository<ReviewForum, Integer>{
	List <ReviewForum> findAll(Pageable page);
	List <ReviewForum> findByTitleIsContaining(String title);
	ReviewForum findById(int id);
}
