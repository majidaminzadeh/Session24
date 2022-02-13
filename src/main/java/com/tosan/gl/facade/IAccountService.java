package com.tosan.gl.facade;

import com.tosan.gl.data.Account;
import com.tosan.gl.data.Branch;

import java.math.BigDecimal;

public interface IAccountService {
    public Account openAccount(Branch branch, BigDecimal initBalance);
}
