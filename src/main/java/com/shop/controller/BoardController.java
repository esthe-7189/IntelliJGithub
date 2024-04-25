package com.shop.controller;


import com.shop.dto.BoardFormDto;
import com.shop.dto.BoardSearchDto;
import com.shop.entity.Board;
import com.shop.service.BoardService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Optional;



@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping(value = "/admin/board/new")
    public String boardFrom(Model model){
        model.addAttribute("boardFormDto", new BoardFormDto());
        return "board/boardForm";
    }

    @PostMapping(value = "/admin/board/new")
    public String boardNew(@Valid BoardFormDto boardFormDto, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return "board/boardForm";
        }

        try {
            boardService.saveBoard(boardFormDto);
        }catch (Exception e){
            model.addAttribute("errorMessage", "글 등록중 에러가 발생했습니다.");
            return "board/boardForm";
        }
        return "redirect:/";
    }

    @GetMapping(value = "/admin/board/{boardId}")
    public String boardDtl(@PathVariable("boardId") Long boardId, Model model){

        try {
            BoardFormDto boardFormDto = boardService.getBoardDtl(boardId);
            model.addAttribute("boardFormDto", boardFormDto);
        }catch (EntityNotFoundException e){
            model.addAttribute("errorMessage", "존재하지 않는 글입니다.");
            model.addAttribute("boardFormDto", new BoardFormDto());
            return "board/boardForm";
        }
        return "board/boardForm";
    }

    public String boardUpdate(@Valid BoardFormDto boardFormDto, BindingResult bindingResult, Model model ){

        if(bindingResult.hasErrors()){
            return "board/boardForm";
        }

        try {
            boardService.updateBoard(boardFormDto);
        }catch (Exception e){
            model.addAttribute("errorMessage", "글 수정수 에러가 발생했습니다.");
            return "board/boardForm";
        }
        return "redirect:/";
    }

    @GetMapping(value = {"/admin/boards", "/admin/boards/{page}"})
    public String boardManage(BoardSearchDto boardSearchDto, @PathVariable("page") Optional<Integer> page, Model model){

        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 3);
        Page<Board> boards=boardService.getAdminBoardPage(boardSearchDto, pageable);

        model.addAttribute("board", boards);
        model.addAttribute("boardSearchDto", boardSearchDto);
        model.addAttribute("maxPage", 5);
        return "board/boardMng";
    }

    @GetMapping(value = "/board/{boardId}")
    public String boardDtl(Model model, @PathVariable("boardId") Long boardId){
        BoardFormDto boardFormDto = boardService.getBoardDtl((boardId));
        model.addAttribute("board", boardFormDto);
        return "board/boardDtl";
    }

}












