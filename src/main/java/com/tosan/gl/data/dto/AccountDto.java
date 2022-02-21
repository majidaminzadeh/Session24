package com.tosan.gl.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto implements Serializable {
    private String accountTitle;
    private Date openingDate;
    private String branchCode;

//    public AccountDto(String accountTitle, ...){
//
//    }
}
