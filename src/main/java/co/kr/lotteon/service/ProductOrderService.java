package co.kr.lotteon.service;

import co.kr.lotteon.dto.LtProductCartDTO;
import co.kr.lotteon.entity.LtProductCartEntity;
import co.kr.lotteon.repository.LtProductCartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class ProductOrderService {
    private final LtProductCartRepository ltProductCartRepository;

    public List<LtProductCartDTO> showOrder(String[] chk){
        List<LtProductCartDTO> dtoList = new ArrayList<>();
        for(String cartNo : chk) {
            dtoList.add(ltProductCartRepository.findById(Integer.parseInt(cartNo)).get().toDTO());
        }
        return dtoList;
    }
}
