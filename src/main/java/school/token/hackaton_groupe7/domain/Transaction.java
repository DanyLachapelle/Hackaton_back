package school.token.hackaton_groupe7.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Transaction {
    private int id;
    private int idUser;
    private int idCat;
    private Date date;
    private int amount;
    private String object;


//    // Getters et Setters
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getIdUser() {
//        return idUser;
//    }
//
//    public void setIdUser(int idUser) {
//        this.idUser = idUser;
//    }
//
//    public int getIdCat() {
//        return idCat;
//    }
//
//    public void setIdCat(int idCat) {
//        this.idCat = idCat;
//    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
//    public int getAmount() {
//        return amount;
//    }
//
//    public void setAmount(int amount) {
//        this.amount = amount;
//    }
//
//    public String getObject() {
//        return object;
//    }
//
//    public void setObject(String object) {
//        this.object = object;
//    }

}
