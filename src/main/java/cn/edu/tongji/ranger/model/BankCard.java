package cn.edu.tongji.ranger.model;

import javax.persistence.*;

/**
 * Created by LiaoShanhe on 2016/4/27.
 */
@Entity
@Table(name = "bank_card", schema = "ranger", catalog = "")
public class BankCard {
    private long id;
    private String owner;
    private String cardNumber;
    private String bank;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "owner")
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Basic
    @Column(name = "card_number")
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Basic
    @Column(name = "bank")
    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankCard bankCard = (BankCard) o;

        if (id != bankCard.id) return false;
        if (owner != null ? !owner.equals(bankCard.owner) : bankCard.owner != null) return false;
        if (cardNumber != null ? !cardNumber.equals(bankCard.cardNumber) : bankCard.cardNumber != null) return false;
        if (bank != null ? !bank.equals(bankCard.bank) : bankCard.bank != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (cardNumber != null ? cardNumber.hashCode() : 0);
        result = 31 * result + (bank != null ? bank.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BankCard{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", bank='" + bank + '\'' +
                '}';
    }
}
