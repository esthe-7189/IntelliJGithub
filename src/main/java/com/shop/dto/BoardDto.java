package com.shop.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class BoardDto {
    private Long id;
    private String writer;
    private String email;
    private String title;
    private String content;
    private LocalDateTime regTime;
    private LocalDateTime updateTime;

}
