package com.tosan.gl.facade;

import com.tosan.gl.bl.AccountService;
import com.tosan.gl.data.Account;
import com.tosan.gl.data.Branch;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jws.WebService;
import java.math.BigDecimal;

@WebService
@Stateless
public class AccountServiceFacade implements IAccountService{

    @EJB
    private AccountService accountService;

    @Override
    public Account openAccount(Branch branch, BigDecimal initBalance) {
        return accountService.openAccount(branch, initBalance);
    }
}
