package com.tosan.gl.bl;

import com.tosan.gl.da.AccountDAO;
import com.tosan.gl.da.BranchDAO;
import com.tosan.gl.data.Account;
import com.tosan.gl.data.Branch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
//import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @Mock
    private BranchDAO branchDAO;

    @Mock
    private AccountDAO accountDAO;

    @InjectMocks
    private AccountService accountService;

    @Test
//    @RepeatedTest(10)
    @DisplayName("happy scenario")
    public void happyScenarioOpenAccount(){
        Branch branch = new Branch();
        branch.setId(1l);
        branch.setCode("100");
        when(branchDAO.find(Matchers.eq(1l))).thenAnswer(t -> {
            Long id = (Long) t.getArgument(0);
            System.out.println(id);
            return new Branch();
        });
        when(branchDAO.find(Matchers.eq(10l))).thenAnswer(t -> {
            Long id = (Long) t.getArgument(0);
            System.out.println(id+1);
            return new Branch();
        });
        when(accountDAO.save(Matchers.any())).thenAnswer(t -> {
            Account account = new Account();
            account.setId(1l);
            return account;
        });
        Account account = accountService.openAccount(branch, new BigDecimal(130));
        assertNotNull(account.getId());
    }


}
