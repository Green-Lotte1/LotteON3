package co.kr.lotteon.service;

import co.kr.lotteon.dto.LtMemberDTO;
import co.kr.lotteon.entity.LtMemberEntity;
import co.kr.lotteon.repository.LtMemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.http.HttpRequest;

@Service
public class LtMemberService {
    @Autowired
    LtMemberRepository ltMemberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void save(LtMemberDTO dto){


        // 비밀번호 암호화
        dto.setPass(passwordEncoder.encode(dto.getPass()));

        // DTO를 Entity로 변환
        LtMemberEntity entity = dto.toEntity();

        // DB insert
        ltMemberRepository.save(entity);
    }

    public int countUid(String uid){
        return ltMemberRepository.countByUid(uid);
    }

}
