package com.example.blobstore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

import java.util.Date;

@Entity
@Table(name = "blobMetaData")
public class BlobMetaData {
    @Id
    private Long id;
    private String name;
    private Date dateCreated;

    public BlobMetaData() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateCreated() {
        dateCreated = new Date(System.currentTimeMillis());
    }
}
