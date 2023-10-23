package co.kr.lotteon.service;

import co.kr.lotteon.dto.LtProductCartDTO;
import co.kr.lotteon.entity.LtProductCartEntity;
import co.kr.lotteon.repository.LtProductCartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class ProductCartSerivce {

    private final LtProductCartRepository ltProductCartRepository;
    public void saveCart(LtProductCartDTO dto){

        // 만약 이미 존재하는 장바구니면 +1
        int isExist = ltProductCartRepository.countByUidAndProdNo(dto.getUid(), dto.getProdNo());
        if(isExist > 0){
            ltProductCartRepository.updateCountByUidAndProdNo(dto.getUid(),dto.getCount(), dto.getProdNo());
        } else{

            // 아니라면 새 장바구니
            ltProductCartRepository.save(dto.toEntity());
        }
    }
    public List<LtProductCartDTO> showCart(String uid){
        return ltProductCartRepository.findAllByUid(uid).stream().map(LtProductCartEntity::toDTO).toList();
    }
}
