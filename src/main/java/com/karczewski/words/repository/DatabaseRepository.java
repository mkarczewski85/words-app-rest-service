package com.karczewski.words.repository;

import com.karczewski.words.domain.WordEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface DatabaseRepository extends JpaRepository<WordEntry, Integer> {

    @Query("SELECT e FROM WordEntry e WHERE LOWER(e.sortedchars) IN (:chars)")
    List<WordEntry> findAllWords(@Param("chars") Set<String> chars);

    @Query("SELECT e FROM WordEntry e WHERE (LOWER(e.sortedchars) IN (:chars)) AND e.word LIKE CONCAT(:letter, '%')")
    List<WordEntry> findAllWordsStartingWith(@Param("chars") Set<String> chars, @Param("letter") char letter);

    @Query("SELECT e FROM WordEntry e WHERE (LOWER(e.sortedchars) IN (:chars)) AND e.word LIKE CONCAT('%', :letter)")
    List<WordEntry> findAllWordsEndingWith(@Param("chars") Set<String> chars, @Param("letter") char letter);

    boolean existsByWord(String word);
}
