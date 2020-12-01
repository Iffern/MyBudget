package model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "Operation")
public class Operation {
    private int id;

    private ObjectProperty<Account> account;

    private ObjectProperty<BigDecimal> amount;

    private ObjectProperty<Date> date;

    private StringProperty comment;


    public Operation() {}

    public Operation(Account account, BigDecimal amount, Date date, String comment) {
        this.account = new SimpleObjectProperty<>(account);
        this.amount = new SimpleObjectProperty<>(amount);
        this.date = new SimpleObjectProperty<>(date);
        this.comment = new SimpleStringProperty(comment);
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Transient
    @ManyToOne
    public Account getAccount() {
        return account.getValue();
    }
    public void setAccount(Account account) {
        this.account = new SimpleObjectProperty<>(account);
    }
    public ObjectProperty<Account> accountProperty() {
        return account;
    }

    @Column(name = "amount")
    public BigDecimal getAmount() {
        return amount.getValue();
    }
    public void setAmount(BigDecimal amount) {
        this.amount = new SimpleObjectProperty<>(amount);
    }
    public ObjectProperty<BigDecimal> amountProperty() {
        return amount;
    }

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDate() {
        return date.getValue();
    }
    public void setDate(Date date) {
        this.date = new SimpleObjectProperty<>(date);
    }
    public ObjectProperty<Date> dateProperty() {
        return date;
    }

    @Column(name = "comment")
    public String getComment() {
        return comment.getValue();
    }
    public void setComment(String comment) {
        this.comment = new SimpleStringProperty(comment);
    }
    public StringProperty commentProperty() {
        return comment;
    }


}
