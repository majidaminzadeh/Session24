package com.tosan.gl.bl;

import com.tosan.gl.data.Branch;
import com.tosan.gl.data.Currency;
import com.tosan.gl.data.GlEntry;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AccountDataService {

    public String generateAccountTitle(Branch branch, Currency currency, GlEntry glEntry){
        StringBuilder builder = new StringBuilder();
        // String str = branch.getCode() + currency.getCode() + glEntry.getCode();
        builder.append(branch.getCode());
        builder.append(currency.getCode());
        builder.append(glEntry.getCode());
        return builder.toString();
    }
    public String generateAccountCode(Branch branch, Currency currency, GlEntry glEntry){
        StringBuilder builder = new StringBuilder();
        builder.append(branch.getTitle());
        builder.append(currency.getTitle());
        builder.append(glEntry.getTitle());
        return builder.toString();
    }
}
