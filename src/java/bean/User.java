/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 * All rights reserved 
 * The source code is protected to its owner
 *
 * @author Abed
 */
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id    
    private String email;
    private String password;
    private String nom;
    private String prenom;
    private String tel;
    private String gender;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateNaissance;
    private String passportNumber;
    private String country;
    private String nationality;
    private String adress;
    private int zipCode;
    
    
    
    
    
    private boolean blocked;
    private int nbrCnx;
    private boolean mdpChanged;
    private int isAdmin;
    private int tentativeRest;      
    @OneToOne(mappedBy = "user")
    private Card card;

    public User() {
    }

    public User(String email, String password, String nom, String prenom, String tel, String gender, Date dateNaissance, String passportNumber, String country, String nationality, String adress, int zipCode, boolean blocked, int nbrCnx, boolean mdpChanged, int isAdmin, int tentativeRest, Card card) {
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.gender = gender;
        this.dateNaissance = dateNaissance;
        this.passportNumber = passportNumber;
        this.country = country;
        this.nationality = nationality;
        this.adress = adress;
        this.zipCode = zipCode;
        this.blocked = blocked;
        this.nbrCnx = nbrCnx;
        this.mdpChanged = mdpChanged;
        this.isAdmin = isAdmin;
        this.tentativeRest = tentativeRest;
        this.card = card;
    }

    public User(String email, String password, String nom, String prenom, String tel, String gender, Date dateNaissance, String passportNumber, String country, String nationality, String adress, int zipCode, Card card) {
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.gender = gender;
        this.dateNaissance = dateNaissance;
        this.passportNumber = passportNumber;
        this.country = country;
        this.nationality = nationality;
        this.adress = adress;
        this.zipCode = zipCode;
        this.card = card;
    }

    
    public User(String email, String password, String nom, String prenom, String tel, String gender, Date dateNaissance, boolean blocked, int nbrCnx, boolean mdpChanged, int isAdmin, int tentativeRest) {
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.gender = gender;
        this.dateNaissance = dateNaissance;
        this.blocked = blocked;
        this.nbrCnx = nbrCnx;
        this.mdpChanged = mdpChanged;
        this.isAdmin = isAdmin;
        this.tentativeRest = tentativeRest;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public int getNbrCnx() {
        return nbrCnx;
    }

    public void setNbrCnx(int nbrCnx) {
        this.nbrCnx = nbrCnx;
    }

    public boolean isMdpChanged() {
        return mdpChanged;
    }

    public void setMdpChanged(boolean mdpChanged) {
        this.mdpChanged = mdpChanged;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public int getTentativeRest() {
        return tentativeRest;
    }

    public void setTentativeRest(int tentativeRest) {
        this.tentativeRest = tentativeRest;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "email=" + email + ", nom=" + nom + ", prenom=" + prenom + '}';
    }
    
}
