package com.shop.repository;

import com.shop.entity.ItemImg;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

//상품 이미지 저장 위한 클래스, 여기서 대표 이미지를 찾는 쿼리 실행
public interface ItemImgRepository extends JpaRepository<ItemImg, Long> {

    List<ItemImg> findByItemIdOrderByIdAsc(Long itemId);

    ItemImg findByItemIdAndRepimgYn(Long itemId, String repimgYn);

}