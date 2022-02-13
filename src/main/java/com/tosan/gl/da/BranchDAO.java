package com.tosan.gl.da;

import com.tosan.gl.data.Branch;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BranchDAO {
    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    public Branch find(Long id){
        Branch branch = entityManager.find(Branch.class, id);
        return branch;
    }

    public Branch save(Branch branch){
        branch.setId(null);
        entityManager.persist(branch);
        return branch;
    }
}
