package co.kr.lotteon.service;

import co.kr.lotteon.repository.LtProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ProductService {

    @Autowired
    LtProductRepository ltProductRepository;


}
