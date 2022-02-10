package com.tosan.gl.bl;

import com.tosan.gl.data.*;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.Date;

@Stateless
public class AccountService {

    private String str;

    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    @EJB
    private AccountDataService accountDataService;

//    @PostConstruct
//    private void init(){
//        try {
//            accountDataService = InitialContext.doLookup("java:global/");
//        } catch (NamingException e) {
//            e.printStackTrace();
//        }
//        accountDataService = InitialContext.doLookup("java:app/module");
//        accountDataService = InitialContext.doLookup("java:module/AccountDataService");
//    }

    public Account openAccount(/*Branch branch, Currency currency, GlEntry glEntry, */BigDecimal initBalance){
//        validateInput(branch, currency, glEntry, initBalance);
        Account account = new Account();
//        account.setCode(accountDataService.generateAccountCode(branch, currency, glEntry));
//        account.setTitle(accountDataService.generateAccountTitle(branch, currency, glEntry));
//        account.setBranch(branch);
//        account.setCurrency(currency);
        account.setClosingDate(null);
//        account.setGlEntry(glEntry);
        account.setOpeningDate(new Date());
        account.setBalance(initBalance);
        account.setStatus(AccountStatus.OPEN);
        entityManager.persist(account);
        return account;
    }

    public Account closeAccount(Account account){
        if(account.getBalance().equals(BigDecimal.ZERO)){
            account.setStatus(AccountStatus.CLOSE);
            account.setClosingDate(new Date());
            return account;
        } else {
            throw new RuntimeException("Can not be closed, Account has balance");
        }
    }

    public boolean isAccountValid(Account account){
        if(!isAccountExisted(account)){
            return false;
        }
        if(account.getStatus().equals(AccountStatus.CLOSE)){
            return false;
        }
        return true;
    }

    private boolean isAccountExisted(Account account) {
        return true;
    }

    private void validateInput(Branch branch, Currency currency, GlEntry glEntry, BigDecimal initBalance) {
    }
}
