/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Card;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * All rights reserved The source code is protected to its owner
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

    public void createCardHolder() {
        // Set your secret key: remember to change this to your live secret key in production
        // See your keys here: https://dashboard.stripe.com/account/apikeys
//        Stripe.apiKey = "sk_test_BQokikJOvBiI2HlWgH4olfQ2";

        Map<String, Object> addressParams = new HashMap<String, Object>();
        addressParams.put("line1", "1234 Main Street");
        addressParams.put("city", "San Francisco");
        addressParams.put("state", "CA");
        addressParams.put("postal_code", "94111");
        addressParams.put("country", "US");

        Map<String, Object> billingParams = new HashMap<String, Object>();
        billingParams.put("name", "Jenny Rosen");
        billingParams.put("address", addressParams);

        Map<String, Object> cardholderParams = new HashMap<>();
        cardholderParams.put("name", "Jenny Rosen");
        cardholderParams.put("email", "jenny.rosen@example.com");
        cardholderParams.put("phone_number", "+18008675309");
        cardholderParams.put("status", "active");
        cardholderParams.put("type", "individual");
        cardholderParams.put("billing", billingParams);

//        Cardholder cardholder = Cardholder.create(cardholderParams);
    }

    public void createCard() {
        // Set your secret key: remember to change this to your live secret key in production
// See your keys here: https://dashboard.stripe.com/account/apikeys
//        Stripe.apiKey = "sk_test_BQokikJOvBiI2HlWgH4olfQ2";

        Map<String, Object> cardParams = new HashMap<>();
        cardParams.put("cardholder", "ich_1Cm3pZIyNTgGDVfzI83rasFP");
        cardParams.put("type", "virtual");
        cardParams.put("currency", "usd");
//        Card card = Card.create(cardParams);

    }
}
