package com.tosan.gl.rest;

import com.tosan.gl.bl.AccountService;
import com.tosan.gl.data.Account;
import com.tosan.gl.data.Branch;
import com.tosan.gl.data.dto.AccountDto;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Path("/account")
@Stateless
public class AccountRestService {

    @EJB
    private AccountService accountService;

    @GET
    @Path("/bycode/code/{branchCode}") // ".../account/bycode"
//    @QueryParam()
    public List<AccountDto> get(@QueryParam("code") String branchCode1, @PathParam("branchCode") String branchCode){
        Account account = new Account();
        account.setOpeningDate(sampleDate());
        Branch branch = new Branch();
        branch.setCode(branchCode);
        account.setBranch(branch);
        List<AccountDto> accountDtos = accountService.findAccountByFilter(account);
        return accountDtos;
    }

    @POST
    @Path("/bycode") // ".../account/bycode"
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public AccountDto findByFilter(Account account){
//        Account account = new Account();
//        account.setOpeningDate(sampleDate());
//        Branch branch = new Branch();
//        branch.setCode(branchCode);
//        account.setBranch(branch);
        List<AccountDto> accountDtos = accountService.findAccountByFilter(account);
        return accountDtos.get(0);
    }

    @GET
    @Path("/test")
    public String get(){
        return "GET";
    }

    @POST
    @Path("/test")
    public String post(){
        return "POST";
    }

    private Date sampleDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -10);
        return calendar.getTime();
    }

}
