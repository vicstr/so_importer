package com.vincipline.util.entity;

import org.hibernate.annotations.Type;
import org.hibernate.type.ByteType;
import org.hibernate.type.NumericBooleanType;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "badges")
public class Badge {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "Id", updatable = false, nullable = false)
    private long id;

    @Column(name = "UserId")
    private int userId;

    @Column(name = "Name", length = 50)
    private String name;

    @Temporal(value= TemporalType.TIMESTAMP)
    @Column(name = "Date")
    private Date date;

    @Column(name = "Class", length = 2)
    @Type(type = "org.hibernate.type.ShortType")
    private Short classification;

    @Column(name = "TagBased", nullable = false)
    private Boolean tagBased;


    public long getId() {
        return id;
    }

    public Badge setId(int id) {
        this.id = id;
        return this;
    }

    public int getUserId() {
        return userId;
    }

    public Badge setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Badge setName(String name) {
        this.name = name;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Badge setDate(Date date) {
        this.date = date;
        return this;
    }

    public Short getClassification() {
        return classification;
    }

    public Badge setClassification(Short classification) {
        this.classification = classification;
        return this;
    }

    public Boolean getTagBased() {
        return tagBased;
    }

    public Badge setTagBased(Boolean tagBased) {
        this.tagBased = tagBased;
        return this;
    }
}
