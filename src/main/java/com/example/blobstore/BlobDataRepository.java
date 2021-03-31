package com.example.blobstore;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface BlobDataRepository extends CrudRepository<BlobData, Long> {
}