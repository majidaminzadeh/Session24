package com.tosan.gl.facade.soap;

import com.tosan.gl.bl.AccountService;
import com.tosan.gl.data.Account;
import com.tosan.gl.data.Branch;
import com.tosan.gl.data.dto.AccountDto;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.math.BigDecimal;
import java.util.List;

@WebService
@Stateless
public class AccountServiceFacade implements IAccountService{

    @EJB
    private AccountService accountService;

    @Override
    public Account openAccount(Branch branch, BigDecimal initBalance) {
        return accountService.openAccount(branch, initBalance);
    }

    @Override
    public List<AccountDto> findAccountByFilter(Account account) {
        List<AccountDto> accountDto = accountService.findAccountByFilter(account);
        return accountDto;
    }
}
