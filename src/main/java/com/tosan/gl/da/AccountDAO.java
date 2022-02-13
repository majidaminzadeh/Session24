package com.tosan.gl.da;

import com.tosan.gl.data.Account;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AccountDAO {
    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    public Account save(Account account){
        entityManager.persist(account);
        return account;
    }
}
