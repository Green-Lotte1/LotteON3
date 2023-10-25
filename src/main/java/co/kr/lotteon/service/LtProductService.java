package co.kr.lotteon.service;

import co.kr.lotteon.dto.LtProductDTO;
import co.kr.lotteon.dto.prodpage.ProdPageRequestDTO;
import co.kr.lotteon.dto.prodpage.ProdPageResponseDTO;
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

//    Index 출력
    // Hit 상품 Top8
    public List<LtProductDTO> selectProductHit() {

        List<LtProductEntity> prodEntity = ltProductRepository.findTop8ByOrderByHitDesc();

        List<LtProductDTO> prodHitDTO = prodEntity.stream().map(entity -> modelMapper.map(entity, LtProductDTO.class)).toList();

        return prodHitDTO;
    }

    // discount Top8
    public List<LtProductDTO> selectProductDiscount() {
        List<LtProductEntity> prodEntity = ltProductRepository.findTop8ByOrderByDiscountDesc();
        List<LtProductDTO> prodDisDTO = prodEntity.stream().map(entity -> modelMapper.map(entity, LtProductDTO.class)).toList();

        return prodDisDTO;
    }

    // Sold Top5 (Side Best prod)
    public List<LtProductDTO> selectProductSold() {
        List<LtProductEntity> prodEntity = ltProductRepository.findTop5ByOrderBySoldDesc();
        List<LtProductDTO> prodSoldDTO = prodEntity.stream().map(entity -> modelMapper.map(entity, LtProductDTO.class)).toList();
        return prodSoldDTO;
    }

    // Score Top 8
    public List<LtProductDTO> selectProductScore() {
        List<LtProductEntity> prodEntity = ltProductRepository.findTop8ByOrderByScoreDesc();
        List<LtProductDTO> prodScoreDTO = prodEntity.stream().map(entity -> modelMapper.map(entity, LtProductDTO.class)).toList();
        return prodScoreDTO;
    }

    // New Top8
    public List<LtProductDTO> selectProductNew() {
        List<LtProductEntity> prodEntity = ltProductRepository.findTop8ByOrderByRegDateDesc();
        List<LtProductDTO> prodNewDTO = prodEntity.stream().map(entity -> modelMapper.map(entity, LtProductDTO.class)).toList();
        return prodNewDTO;
    }

// admin - 상품 등록
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
    @Value("${upload.path.thumbs}")
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


// admin - 상품 리스트

    //상품 전체 출력, 조건 검색
    public ProdPageResponseDTO search(ProdPageRequestDTO prodPageRequestDTO){

        Pageable pageable = prodPageRequestDTO.getPageable("cate1");
        String searchType = prodPageRequestDTO.getSearchType(); // searchType 값을 가져와야 함
        int count = 0;
        // 검색 결과를 저장할 변수
        Page<LtProductEntity> searchResult = null;
        log.info("서치 키워드 : " + prodPageRequestDTO.getSearchKeyword());
        log.info("서치 타입 : " + prodPageRequestDTO.getSearchType());

        switch(searchType){
            case "prodName":
                searchResult = ltProductRepository.findALLByIsRemovedAndProdNameContains(0, prodPageRequestDTO.getSearchKeyword(), pageable);
                count = (int) ltProductRepository.countByIsRemovedAndProdNameContains(0, prodPageRequestDTO.getSearchKeyword());
                break;
            case "prodNo":
                int searchProdNo = prodPageRequestDTO.getSearchProdNo();
                String searchProdNoStr = String.valueOf(searchProdNo); //와일드카드 사용을 위한 String 변환
                searchResult = ltProductRepository.productNoList(0, searchProdNoStr, pageable);
                count = (int) ltProductRepository.countByproductNoList(0, searchProdNoStr);
                break;
            case "company":
                searchResult = ltProductRepository.findAllByIsRemovedAndCompanyContains(0, prodPageRequestDTO.getSearchKeyword(), pageable);
                count = (int)ltProductRepository.countByIsRemovedAndCompanyContains(0, prodPageRequestDTO.getSearchKeyword());
                break;
            default:
                searchResult = ltProductRepository.findAllByIsRemoved(0, pageable);
                count = (int)searchResult.getTotalElements();
                break;
        }

        // entity page -> dto list 로 변환
        List<LtProductDTO> dtoList = searchResult.getContent().stream().map(LtProductEntity::toDTO).toList();

        return ProdPageResponseDTO
                .builder()
                .pageRequestDTO(prodPageRequestDTO)
                .dtoList(dtoList)
                .total(count)
                .build();
    }

// admin - 상품 삭제






}
