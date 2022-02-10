package com.tosan.gl.bl;

import com.tosan.gl.data.Account;
import com.tosan.gl.data.Branch;
import com.tosan.gl.data.Voucher;
import com.tosan.gl.data.VoucherEntry;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.PrePassivate;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Startup
public class VoucherService {

    @EJB
    private AccountService accountService;

    private int randomInt = 0;

    @PostConstruct
    public void init(){

    }

    @PreDestroy
    public void destroy(){

    }

    public Voucher postVoucher(Branch branch, List<VoucherEntry> entries){
        validateInput(branch, entries);
        Voucher voucher = new Voucher();
        voucher.setVoucherNumber(1l);
        voucher.setVoucherEntries(entries);
        voucher.setApplyDate(new Date());
        voucher.setIssueDate(new Date());
        voucher.setBranch(branch);
        randomInt = 1;
        return voucher;
    }

    private void validateInput(Branch branch, List<VoucherEntry> entries) {
        for (VoucherEntry entry : entries){
            validateAccount(entry.getAccount());
        }
    }

    private void validateAccount(Account account) {
        if(!accountService.isAccountValid(account)) {
            throw new RuntimeException("Account is invalid");
        }
    }
}
