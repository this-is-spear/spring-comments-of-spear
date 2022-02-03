package happy.comments.springcomments.repository;

import happy.comments.springcomments.domain.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Override
    <S extends Comment> S save(S entity);

    @Override
    Optional<Comment> findById(Long aLong);

//    long countByItem_id(Long item_id);
}
