package com.tosan.gl.facade.soap;

import com.tosan.gl.data.Account;
import com.tosan.gl.data.Branch;
import com.tosan.gl.data.dto.AccountDto;

import java.math.BigDecimal;
import java.util.List;

public interface IAccountService {
    Account openAccount(Branch branch, BigDecimal initBalance);
    List<AccountDto> findAccountByFilter(Account account);
}
