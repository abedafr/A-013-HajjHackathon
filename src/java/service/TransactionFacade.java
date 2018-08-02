/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import bean.Transaction;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * All rights reserved 
 * The source code is protected to its owner
 *
 * @author Abed
 */
@Stateless
public class TransactionFacade extends AbstractFacade<Transaction> {

    @PersistenceContext(unitName = "HajjPayPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransactionFacade() {
        super(Transaction.class);
    }

}
