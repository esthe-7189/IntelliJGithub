package com.shop.repository;

import com.shop.dto.BoardSearchDto;
import com.shop.dto.ItemSearchDto;
import com.shop.dto.MainItemDto;
import com.shop.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

    Board findById(String id);
    Page<Board> getAdminBoardPage(BoardSearchDto boardSearchDto, Pageable pageable);

}
