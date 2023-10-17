package co.kr.lotteon.repository;

import co.kr.lotteon.entity.LtMemberEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface LtMemberRepository extends JpaRepository<LtMemberEntity, String> {

    /*
    @Modifying(clearAutomatically = true)

    @Query("UPDATE lt_member m SET m.pass = :pass where m.uid = :uid")
    void updatePass(String uid,  String pass);

     */
    LtMemberEntity findAllByEmail(String email);
    int countByUid(String uid);
    int countByHp(String hp);
    int countByEmail(String email);
    int countByNameAndEmail(String name, String email);
    int countByUidAndEmail(String uid, String email);
}
