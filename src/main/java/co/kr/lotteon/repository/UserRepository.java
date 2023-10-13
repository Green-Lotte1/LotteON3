package co.kr.lotteon.repository;

import co.kr.lotteon.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {

    int countByUid(String uid);
}
