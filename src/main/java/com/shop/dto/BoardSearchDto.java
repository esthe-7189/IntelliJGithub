package com.shop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardSearchDto {

    private String searchBy;

    private String searchQuery = "";
}
