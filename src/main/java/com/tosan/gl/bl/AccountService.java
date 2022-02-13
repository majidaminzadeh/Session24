package com.tosan.gl.bl;

import com.tosan.gl.da.AccountDAO;
import com.tosan.gl.da.BranchDAO;
import com.tosan.gl.data.*;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.Date;

@Stateless
public class AccountService {

    @EJB
    private AccountDAO accountDAO;

    @EJB
    private BranchDAO branchDAO;

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

    public Account openAccount(Branch branch, BigDecimal initBalance){
        Account account = new Account();
        Branch tempBranch = branchDAO.find(branch.getId());
        if(tempBranch == null){
            branch = branchDAO.save(branch);
        }
        account.setBranch(branch);
        account.setClosingDate(null);
        account.setOpeningDate(new Date());
        account.setBalance(initBalance);
        account.setStatus(AccountStatus.OPEN);
        account = accountDAO.save(account);
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
