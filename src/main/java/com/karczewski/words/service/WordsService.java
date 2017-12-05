package com.karczewski.words.service;

import com.karczewski.words.domain.WordEntry;
import com.karczewski.words.repository.DatabaseRepository;
import com.karczewski.words.utils.PowerSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class WordsService {

    private DatabaseRepository repository;

    @Autowired
    public WordsService(DatabaseRepository repository) {
        this.repository = repository;
    }

    public List<WordEntry> getResults(String letters, int option) {
        switch (option) {
            case 0: {
                Set<String> subsets = PowerSet.powerSet(letters);
                return repository.findAllWords(subsets);
            }
            case 1: {
                Set<String> subsets = PowerSet.powerSet(letters);
                return repository.findAllWordsStartingWith(subsets, getLast(letters));
            }
            case 2: {
                Set<String> subsets = PowerSet.powerSet(letters);
                return repository.findAllWordsEndingWith(subsets, getLast(letters));
            }
            default: {
                return Collections.emptyList();
            }
        }
    }

    public boolean checkForWord(String word) {
        return repository.existsByWord(word);
    }

    private static String getSubstring(String letters) {
        return letters.substring(0, letters.length() - 2);
    }

    private static char getLast(String letters) {
        int len = letters.length();
        return letters.charAt(len - 1);
    }
}
