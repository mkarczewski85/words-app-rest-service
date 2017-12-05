package com.karczewski.words.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "wordentry")
public class WordEntry implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String word;
    private String sortedchars;
    private Integer points;

    public WordEntry() {
    }

    public WordEntry(String word, String sortedChars, Integer points) {
        this.word = word;
        this.sortedchars = sortedChars;
        this.points = points;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getSortedchars() {
        return sortedchars;
    }

    public void setSortedchars(String sortedchars) {
        this.sortedchars = sortedchars;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "WordEntry{" +
                "word='" + word + '\'' +
                ", sortedchars='" + sortedchars + '\'' +
                ", points=" + points +
                '}';
    }
}
