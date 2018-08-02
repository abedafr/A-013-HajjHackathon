/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.User;
import controller.util.HashageUtil;
import controller.util.JsfUtil;
import controller.util.SessionUtil;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * All rights reserved The source code is protected to its owner
 *
 * @author Abed
 */
@Stateless
public class UserFacade extends AbstractFacade<User> {

    @PersistenceContext(unitName = "HajjPayPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }

    @Override
    public User find(Object id) {
        try {
            User user = (User) em.createQuery("select u from User u where u.email = '" + id + "'").getSingleResult();
            if (user != null) {
                return user;
            }
        } catch (Exception e) {
            JsfUtil.addErrorMessage("Login incorrect");
        }
        return null;
    }

    public void seDeConnnecter() {
        SessionUtil.getSession().invalidate();
        SessionUtil.deconnectUser();
        SessionUtil.registerUser(null);

    }

    public void cloneData(User userSource, User userDestination) {
        userDestination.setNom(userSource.getNom());
        userDestination.setPrenom(userSource.getPrenom());
        userDestination.setTel(userSource.getTel());
        userDestination.setEmail(userSource.getEmail());
    }

    public int seConnnecter(User user) {
        if (user == null || user.getEmail() == null) {
            return -5;
        } else {
            User loadedUser = find(user.getEmail());
            if (loadedUser == null) {
                return -4;
            } else if (!loadedUser.getPassword().equals(HashageUtil.sha256(user.getPassword()))) {
                if (loadedUser.getNbrCnx() < 3) {
                    System.out.println("hana loadedUser.getNbrCnx() < 3 ::: " + loadedUser.getNbrCnx());
                    loadedUser.setNbrCnx(loadedUser.getNbrCnx() + 1);
                } else if (loadedUser.getNbrCnx() >= 3) {
                    System.out.println("hana loadedUser.getNbrCnx() >= 3::: " + loadedUser.getNbrCnx());
                    loadedUser.setBlocked(true);
                }
                edit(loadedUser);
                return -3;
            } else if (loadedUser.isBlocked()) {
                return -2;
            } else {
                loadedUser.setNbrCnx(0);
                edit(loadedUser);
                user.setMdpChanged(loadedUser.isMdpChanged());
                user.setPassword(null);
                SessionUtil.registerUser(user);
                return 1;
            }
        }
    }

}
