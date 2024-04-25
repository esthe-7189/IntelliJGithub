package com.shop.service;

import com.shop.dto.BoardFormDto;
import com.shop.dto.BoardSearchDto;
import com.shop.entity.Board;
import com.shop.repository.BoardRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
@RequiredArgsConstructor
public class BoardService  {

    private final BoardRepository boardRepository;

    public Long saveBoard(BoardFormDto boardFormDto) throws Exception{

        //등록
        Board board = boardFormDto.createBoard();
        boardRepository.save(board);
        return board.getId();
    }

    @Transactional(readOnly = true)
    public BoardFormDto getBoardDtl(Long boardId){
        Board board = boardRepository.findById(boardId)
                .orElseThrow(EntityNotFoundException::new);
        BoardFormDto boardFormDto = BoardFormDto.of(board);
        return boardFormDto;
    }

    public Long updateBoard(BoardFormDto boardFormDto) throws Exception{
        Board board = boardRepository.findById(boardFormDto.getId())
                .orElseThrow(EntityNotFoundException::new);
        board.updateBoard(boardFormDto);
        return board.getId();
    }

    @Transactional(readOnly = true)
    public Page<Board> getAdminBoardPage(BoardSearchDto boardSearchDto, Pageable pageable){
        return boardRepository.getAdminBoardPage(boardSearchDto, pageable);

    }



}
