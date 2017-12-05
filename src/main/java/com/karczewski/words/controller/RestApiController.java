package com.karczewski.words.controller;

import com.karczewski.words.domain.WordEntry;
import com.karczewski.words.service.WordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestApiController {

    private WordsService service;

    @Autowired
    public RestApiController(WordsService service) {
        this.service = service;
    }

    @CrossOrigin
    @GetMapping("/words")
    public ResponseEntity<?> getResults(@RequestParam String letters, @RequestParam int option) {

        if (letters.length() > 8) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        List<WordEntry> results = service.getResults(letters, option);

        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/check")
    public ResponseEntity<?> checkForWord(@RequestParam String word){
        boolean result = service.checkForWord(word);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
