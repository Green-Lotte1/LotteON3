package co.kr.lotteon.service;

import co.kr.lotteon.dto.LtProductCartDTO;
import co.kr.lotteon.dto.LtProductDTO;
import co.kr.lotteon.dto.prodpage.ProdPageRequestDTO;
import co.kr.lotteon.dto.prodpage.ProdPageResponseDTO;
import co.kr.lotteon.entity.LtProductCartEntity;
import co.kr.lotteon.entity.LtProductEntity;
import co.kr.lotteon.mapper.LtProductMapper;
import co.kr.lotteon.repository.LtProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class LtProductService {

    private final LtProductRepository ltProductRepository;
    private final LtProductMapper ltProductMapper;
    private final ModelMapper modelMapper;

//    상품 리스트 출력(list)
    public List<LtProductDTO> selectProducts() {
        return ltProductMapper.selectProducts();
    }

//    상품 선택 상세페이지 (view)
    public LtProductDTO getProdDto(int prodNo) {
        LtProductEntity entity = ltProductRepository.findById(prodNo).get();
        return entity.toDTO();
    }

//    admin - 상품 등록
    public void insertLtProduct(LtProductDTO ltProductDTO){

        System.out.println("ltProductDTO : " + ltProductDTO);

        List<String> saveNames = fileUpload(ltProductDTO);

        ltProductDTO.setThumb1(saveNames.get(0));
        ltProductDTO.setThumb2(saveNames.get(1));
        ltProductDTO.setThumb3(saveNames.get(2));
        ltProductDTO.setDetail(saveNames.get(3));

        ltProductDTO.setIsRemoved(1);

        ltProductMapper.insertLtProduct(ltProductDTO);

    }

    // admin - 파일이 저장 될 경로
    @Value("${spring.servlet.multipart.location}")
    private String filePath;


    // admin - 파일 업로드
    public List<String> fileUpload(LtProductDTO ltProductDTO) {
        // 파일 첨부 경로(절대 경로로 변환)
        String path = new File(filePath).getAbsolutePath();
        // 첨부파일 리스트화
        List<MultipartFile> files = Arrays.asList(
                ltProductDTO.getFileThumb1(),
                ltProductDTO.getFileThumb2(),
                ltProductDTO.getFileThumb3(),
                ltProductDTO.getFileDetail()
        );
        //저장된 파일명 리스트 초기화
        List<String> saveNames = new ArrayList<>();
        for (MultipartFile file:files) {
            // 파일명 변경
            String oName = file.getOriginalFilename(); //업로드할 때 원래 파일 이름
            String ext = oName.substring(oName.lastIndexOf(".")); //확장자
            String sName = UUID.randomUUID().toString() + ext; //새로운 파일 이름 생성
            saveNames.add(sName);
            try {
                file.transferTo(new File(path, sName)); // 저장할 폴더 이름, 저장할 파일 이름
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
        return saveNames;
    }


//    admin - 상품 리스트
    public ProdPageResponseDTO findLtProductEntitiesByProdCate1(ProdPageRequestDTO prodPageRequestDTO){

        Pageable pageable = prodPageRequestDTO.getPageable("cate1");
        Page<LtProductEntity> result = ltProductRepository.findAll(pageable);

        //list의 각 요소들을 for문 돌리는 느낌 -> List<Entity>를 List<DTO>=10개로 변환(엔티티와dto 속성이 동일하니까 변환 가능함)
        List<LtProductDTO> dtoList = result.getContent().stream().map(entity -> modelMapper.map(entity, LtProductDTO.class)).toList();

        int totalElement = (int) result.getTotalElements(); //엔티티 갯수

        log.info("???? : " + dtoList);
        log.info("!!!! : " + totalElement);
        log.info("xxxxx : " + pageable);


        return ProdPageResponseDTO.builder()
                .pageRequestDTO(prodPageRequestDTO)
                .dtoList(dtoList)
                .total(totalElement)
                .build();
    }


}
