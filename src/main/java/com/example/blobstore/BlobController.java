package com.example.blobstore;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BlobController {
    private final BlobDao blobDao = new BlobDao();

    @GetMapping("/")
    public List<Blob> listBlobs() {
        return blobDao.getBlobList();
    }

    @PostMapping("/upload")
    public void addBlob(@RequestParam(value="name") String name) {
        UUID id = UUID.randomUUID();
        Blob blob = new Blob(id, name);
        blobDao.addBlob(blob);
    }
}
