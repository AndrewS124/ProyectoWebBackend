package com.example.musiclist2.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class AuthR_DTO {

    public String accessToken ;
    private String tokenType = "Bearer";


    public AuthR_DTO(String accessToken) {
        this.accessToken = accessToken;

    }
}
