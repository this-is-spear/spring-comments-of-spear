package happy.comments.springcomments.repository;

import happy.comments.springcomments.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    @Override
    <S extends Member> S save(S entity);

    @Override
    Optional<Member> findById(Long aLong);
}
