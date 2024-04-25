package com.shop.dto;

import com.shop.entity.Board;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter @Setter
public class BoardFormDto {
    private Long id;

    @NotBlank(message = "글쓴이를 기재해 주세요")
    private String writer;

    @NotEmpty(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "이메일 형식으로 입력해주세요.")
    private String email;

    @NotBlank(message = "타이틀을 기재해 주세요")
    private String title;

    @NotBlank(message = "내용을 기재해주세요")
    private String content;

    private static ModelMapper modelMapper = new ModelMapper();

    public Board createBoard(){
        return modelMapper.map(this, Board.class);
    }

    public static BoardFormDto of(Board board){
        return modelMapper.map(board, BoardFormDto.class);
    }

}
