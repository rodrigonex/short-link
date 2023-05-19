package com.portfolio.shortlink.service;

import java.util.Random;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.portfolio.shortlink.Repositories.Repositorie;
import com.portfolio.shortlink.model.ShortLink;

@Service
public class MyService {

    @Autowired
    private Repositorie repository;

    public ResponseEntity<?> create(ShortLink shortLink) {

        Random random = new Random();
        LocalDate currentDate = LocalDate.now();
        int randomNumber = random.nextInt(900000) + 100000;

        shortLink.setCod(randomNumber);
        shortLink.setCreateDate(currentDate);

        return new ResponseEntity<>(repository.save(shortLink), HttpStatus.CREATED);
    }

    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> getByCod(int id) {

        if (repository.countByCod(id) == 0) {
            return new ResponseEntity<>("Código não encontrado", HttpStatus.BAD_REQUEST);
        } else {
            ShortLink shortLink = repository.findByCod(id);
            return new ResponseEntity<String>(shortLink.getUrl(), HttpStatus.OK);
        }
    }

}
