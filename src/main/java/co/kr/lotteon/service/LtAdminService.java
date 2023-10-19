package co.kr.lotteon.service;

import co.kr.lotteon.dto.LtProductCate1DTO;
import co.kr.lotteon.dto.LtProductCate2DTO;
import co.kr.lotteon.mapper.admin.LtProductCateMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Log4j2
public class LtAdminService {

    private final LtProductCateMapper ltProductCateMapper;

    private final ModelMapper modelMapper;

    public List<LtProductCate1DTO> selectLtProductCate1s(){

        return ltProductCateMapper.selectLtProductCate1s();
    }

    public List<LtProductCate2DTO> selectLtProductCate2s(String cate1){
        return ltProductCateMapper.selectLtProductCate2s(cate1);
    }

}
