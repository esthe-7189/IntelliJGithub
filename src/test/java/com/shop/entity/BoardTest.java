package com.shop.entity;


import com.shop.repository.BoardRepository;
import com.shop.repository.MemberRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
public class BoardTest {

    @Autowired
    BoardRepository boardRepository;

    @PersistenceContext
    EntityManager em;

    @Autowired
    MemberRepository memberRepository;

    public Board createBoard(){
        Board board = new Board();
        board.setWriter("장미미");
        board.setEmail("aa@aa.com");
        board.setTitle("타이틀이에요");
        board.setContent("내용이에요");
        board.setRegTime(LocalDateTime.now());
        board.setUpdateTime(LocalDateTime.now());
        return board;
    }


}
