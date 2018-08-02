/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 * All rights reserved The source code is protected to its owner
 *
 * @author Abed
 */
@Entity
public class Card implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Long cardNumber;
    private int ccv;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date expirationDate;
    private boolean type;
    private String company;

    @OneToOne
    private User user;

    @OneToMany(mappedBy = "card")
    private List<Transaction> transactions;

    public Card() {
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Card(Long cardNumber, int ccv, Date expirationDate, boolean type, String company, User user) {
        this.cardNumber = cardNumber;
        this.ccv = ccv;
        this.expirationDate = expirationDate;
        this.type = type;
        this.company = company;
        this.user = user;
    }

    public Card(Long cardNumber, int ccv, Date expirationDate, boolean type, String company, User user, List<Transaction> transactions) {
        this.cardNumber = cardNumber;
        this.ccv = ccv;
        this.expirationDate = expirationDate;
        this.type = type;
        this.company = company;
        this.user = user;
        this.transactions = transactions;
    }

    public int getCcv() {
        return ccv;
    }

    public void setCcv(int ccv) {
        this.ccv = ccv;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cardNumber != null ? cardNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Card)) {
            return false;
        }
        Card other = (Card) object;
        if ((this.cardNumber == null && other.cardNumber != null) || (this.cardNumber != null && !this.cardNumber.equals(other.cardNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Card[ id=" + cardNumber + " ]";
    }

}
