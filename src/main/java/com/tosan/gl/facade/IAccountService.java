package com.tosan.gl.facade;

import com.tosan.gl.data.Account;

import java.math.BigDecimal;

public interface IAccountService {
    public Account openAccount(BigDecimal initBalance);
}
