package com.example.blobstore;

import java.util.List;
import java.util.ArrayList;

public class BlobDao {

    private List<Blob> blobList;

    public BlobDao() {
        blobList = new ArrayList<Blob>();
    }

    public List<Blob> getBlobList() {
        return blobList;
    }

    public void addBlob(Blob blob) {
        blobList.add(blob);
    }
}