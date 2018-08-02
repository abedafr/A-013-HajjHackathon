/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import bean.Card;
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
public class CardFacade extends AbstractFacade<Card> {

    @PersistenceContext(unitName = "HajjPayPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CardFacade() {
        super(Card.class);
    }

}
