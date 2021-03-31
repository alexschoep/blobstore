package com.example.blobstore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

import javax.sql.rowset.serial.SerialBlob;

@Entity
@Table(name = "blobData")
public class BlobData {
    @Id
    private Long id;
    private SerialBlob bytes;

    public BlobData() {
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
