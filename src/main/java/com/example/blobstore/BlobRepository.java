package com.example.blobstore;

import org.springframework.data.repository.CrudRepository;

import com.example.blobstore.Blob;

public interface BlobRepository extends CrudRepository<Blob, Integer> {

}