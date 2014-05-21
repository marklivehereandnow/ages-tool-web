/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mark
 */
@Entity
@Table(name = "CARD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Card.findAll", query = "SELECT c FROM Card c"),
    @NamedQuery(name = "Card.findById", query = "SELECT c FROM Card c WHERE c.id = :id"),
    @NamedQuery(name = "Card.findByName", query = "SELECT c FROM Card c WHERE c.name = :name"),
    @NamedQuery(name = "Card.findByAge", query = "SELECT c FROM Card c WHERE c.age = :age"),
    @NamedQuery(name = "Card.findByCivilMilitary", query = "SELECT c FROM Card c WHERE c.civilMilitary = :civilMilitary"),
    @NamedQuery(name = "Card.findByTag", query = "SELECT c FROM Card c WHERE c.tag = :tag"),
    @NamedQuery(name = "Card.findByAction", query = "SELECT c FROM Card c WHERE c.action = :action"),
    @NamedQuery(name = "Card.findByIconPoints", query = "SELECT c FROM Card c WHERE c.iconPoints = :iconPoints"),
    @NamedQuery(name = "Card.findByEffect", query = "SELECT c FROM Card c WHERE c.effect = :effect"),
    @NamedQuery(name = "Card.findByColor", query = "SELECT c FROM Card c WHERE c.color = :color"),
    @NamedQuery(name = "Card.findByCnt", query = "SELECT c FROM Card c WHERE c.cnt = :cnt"),
    @NamedQuery(name = "Card.findByTokenWhite", query = "SELECT c FROM Card c WHERE c.tokenWhite = :tokenWhite"),
    @NamedQuery(name = "Card.findByTokenRed", query = "SELECT c FROM Card c WHERE c.tokenRed = :tokenRed"),
    @NamedQuery(name = "Card.findByTokenYellow", query = "SELECT c FROM Card c WHERE c.tokenYellow = :tokenYellow"),
    @NamedQuery(name = "Card.findByTokenBlue", query = "SELECT c FROM Card c WHERE c.tokenBlue = :tokenBlue")})
public class Card implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "AGE")
    private Integer age;
    @Column(name = "CIVIL_MILITARY")
    private String civilMilitary;
    @Column(name = "TAG")
    private String tag;
    @Basic(optional = false)
    @Column(name = "ACTION")
    private String action;
    @Basic(optional = false)
    @Column(name = "ICON_POINTS")
    private String iconPoints;
    @Basic(optional = false)
    @Column(name = "EFFECT")
    private String effect;
    @Column(name = "COLOR")
    private String color;
    @Basic(optional = false)
    @Column(name = "CNT")
    private int cnt;
    @Basic(optional = false)
    @Column(name = "TOKEN_WHITE")
    private int tokenWhite;
    @Basic(optional = false)
    @Column(name = "TOKEN_RED")
    private int tokenRed;
    @Basic(optional = false)
    @Column(name = "TOKEN_YELLOW")
    private int tokenYellow;
    @Basic(optional = false)
    @Column(name = "TOKEN_BLUE")
    private int tokenBlue;

    public Card() {
    }

    public Card(Integer id) {
        this.id = id;
    }

    public Card(Integer id, String action, String iconPoints, String effect, int cnt, int tokenWhite, int tokenRed, int tokenYellow, int tokenBlue) {
        this.id = id;
        this.action = action;
        this.iconPoints = iconPoints;
        this.effect = effect;
        this.cnt = cnt;
        this.tokenWhite = tokenWhite;
        this.tokenRed = tokenRed;
        this.tokenYellow = tokenYellow;
        this.tokenBlue = tokenBlue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCivilMilitary() {
        return civilMilitary;
    }

    public void setCivilMilitary(String civilMilitary) {
        this.civilMilitary = civilMilitary;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getIconPoints() {
        return iconPoints;
    }

    public void setIconPoints(String iconPoints) {
        this.iconPoints = iconPoints;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public int getTokenWhite() {
        return tokenWhite;
    }

    public void setTokenWhite(int tokenWhite) {
        this.tokenWhite = tokenWhite;
    }

    public int getTokenRed() {
        return tokenRed;
    }

    public void setTokenRed(int tokenRed) {
        this.tokenRed = tokenRed;
    }

    public int getTokenYellow() {
        return tokenYellow;
    }

    public void setTokenYellow(int tokenYellow) {
        this.tokenYellow = tokenYellow;
    }

    public int getTokenBlue() {
        return tokenBlue;
    }

    public void setTokenBlue(int tokenBlue) {
        this.tokenBlue = tokenBlue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Card)) {
            return false;
        }
        Card other = (Card) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Card[ id=" + id + " ]";
    }
    
}
