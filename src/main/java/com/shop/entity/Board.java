package com.shop.entity;

import com.shop.dto.BoardFormDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.*;


@Entity
@Table(name = "board")
@Getter @Setter
@ToString
public class Board extends BaseEntity{

    @Id
    @Column(name = "board_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 30)
    private String writer;

    @Column(unique = true)
    private String email;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;


//    public static Board createBoard(BoardFormDto boardFormDto){
//        Board board=new Board();
//        board.setWriter(boardFormDto.getWriter());
//        board.setEmail(boardFormDto.getEmail());
//        board.setTitle(boardFormDto.getTitle());
//        board.setContent(boardFormDto.getContent());
//        return board;
//    }

    public void updateBoard(BoardFormDto boardFormDto){
        this.writer=boardFormDto.getWriter();
        this.email=boardFormDto.getEmail();
        this.title=boardFormDto.getEmail();
        this.content=boardFormDto.getContent();
    }

}
