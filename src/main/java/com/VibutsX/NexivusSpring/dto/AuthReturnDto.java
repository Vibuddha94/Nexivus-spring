package com.VibutsX.NexivusSpring.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthReturnDto {
    private String jwtToken;
    private String usertype;
}
