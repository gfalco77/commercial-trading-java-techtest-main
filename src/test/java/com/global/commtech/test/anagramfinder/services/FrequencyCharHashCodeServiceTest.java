package com.global.commtech.test.anagramfinder.services;

import com.global.commtech.test.anagramfinder.services.impl.FrequencyCharHashCodeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class FrequencyCharHashCodeServiceTest {

    private FrequencyCharHashCodeService frequencyCharHashCodeService;

    @BeforeEach
    public void setUp() {
        frequencyCharHashCodeService = new FrequencyCharHashCodeService();
    }

    @Test
    public void same_hashcode_for_anagrams() {
        String word1 = "listen";
        String word2 = "silent";
        assertEquals(frequencyCharHashCodeService.calculateHashcode(word1), frequencyCharHashCodeService.calculateHashcode(word2));
    }

    @Test
    public void different_hashcode_for_different_words() {
        String word3 = "hello";
        String word4 = "world";
        assertNotEquals(frequencyCharHashCodeService.calculateHashcode(word3), frequencyCharHashCodeService.calculateHashcode(word4));
    }

    @Test
    public void test_hashcode_for_empty_word_is_zero() {
        String emptyWord = "";
        assertEquals(0, frequencyCharHashCodeService.calculateHashcode(emptyWord));
    }
}
