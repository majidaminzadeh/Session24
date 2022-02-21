package com.tosan.gl.da;

import com.tosan.gl.data.Account;
import com.tosan.gl.data.dto.AccountDto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

@Stateless
public class AccountDAO {
    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;


    public List<AccountDto> findBy(String branchCode, Date openingDate){
        Query query = entityManager.createNamedQuery("findAccountByBranchCodeOpeningDate", AccountDto.class);
        query.setParameter(1, branchCode).setParameter(2, openingDate);
//        query.setFirstResult(10);
//        query.setMaxResults(10);
        List<AccountDto> accounts = query.getResultList();
        return accounts;
    }

    public Account save(Account account){
        entityManager.persist(account);
        return account;
    }
}
