package happy.comments.springcomments.repository;

import happy.comments.springcomments.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    @Override
    <S extends Item> S save(S entity);

    @Override
    Optional<Item> findById(Long aLong);

}
