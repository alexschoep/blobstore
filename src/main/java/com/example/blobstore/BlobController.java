package com.example.blobstore;

import java.util.List;
import java.util.Optional;

import java.util.Random;
import java.lang.Math;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class BlobController {

    @Autowired
    private BlobMetaDataRepository blobMetaDataRepository;
    @Autowired
    private BlobDataRepository blobDataRepository;

    @GetMapping("/")
    public Iterable<BlobMetaData> listBlobs() {
        return blobMetaDataRepository.findAll();
    }

    @PostMapping("/upload")
    public ResponseEntity<String> createBlob(@RequestParam(value="name") String name) {
        Long id = getNewId();
        BlobMetaData blobMetaData = new BlobMetaData();
        blobMetaData.setId(id);
        blobMetaData.setName(name);
        blobMetaData.setDateCreated();
        blobMetaDataRepository.save(blobMetaData);
        BlobData blobData = new BlobData();
        blobData.setId(id);
        blobDataRepository.save(blobData);
        return new ResponseEntity<String>("blob created", HttpStatus.ACCEPTED);
    }

    @GetMapping("/{pathVarId}")
    public BlobMetaData readBlob(@PathVariable String pathVarId) throws ResponseStatusException {
        Long id = Long.parseLong(pathVarId);
        Optional<BlobMetaData> queryResult = blobMetaDataRepository.findById(id);
        if (queryResult.isPresent()) {
            return queryResult.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "blob not found in database");
        }
    }

    @PostMapping("/{pathVarId}/delete")
    public ResponseEntity<String> deleteBlob(@PathVariable String pathVarId) throws ResponseStatusException {
        Long id = Long.parseLong(pathVarId);
        Optional<BlobMetaData> queryResult = blobMetaDataRepository.findById(id);
        if (queryResult.isPresent()) {
            blobMetaDataRepository.deleteById(id);
            blobDataRepository.deleteById(id);
            return new ResponseEntity<String>("blob deleted", HttpStatus.NO_CONTENT);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "blob not found in database");
        }
    }

    private Long getNewId() {
        Random IdGenerator = new Random(System.currentTimeMillis());
        Long id = IdGenerator.nextLong();
        return Math.abs(id);
    }
}
