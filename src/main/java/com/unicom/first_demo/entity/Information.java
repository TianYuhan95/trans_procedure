package com.unicom.first_demo.entity;


import javax.persistence.*;
import java.sql.Clob;
import java.util.Date;

@Entity
@Table(name = "t_bsstocb_procedure")
public class Information {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private java.sql.Date to_date;
    @Lob @Basic(fetch = FetchType.LAZY) @Column(columnDefinition = "text")
    private String detail;
    @Column(length = 50)
    private String owner;
    @Column(length = 2)
    private String state;
    @Lob@Basic(fetch = FetchType.LAZY)@Column(columnDefinition = "text")
    private String info;
    @Column(length = 2)
    private int is_valid;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public java.sql.Date getTo_date() {
        return to_date;
    }

    public void setTo_date(java.sql.Date to_date) {
        this.to_date = to_date;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getIs_valid() {
        return is_valid;
    }

    public void setIs_valid(int is_valid) {
        this.is_valid = is_valid;
    }
}
