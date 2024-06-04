package com.global.commtech.test.anagramfinder.services.impl;

import com.global.commtech.test.anagramfinder.services.HashCodeService;
import org.springframework.stereotype.Service;

@Service
public class FrequencyCharHashCodeService implements HashCodeService {

    @Override
    public int calculateHashcode(String word) {
        // Define an array to store the frequency of each character
        int[] frequency = new int[256]; // Assuming only lowercase alphabets

        // Calculate the frequency of each character in the string
        for (char c : word.toCharArray()) {
            frequency[c]++;
        }

        // Calculate the hashcode based on the frequency array using a prime number for better distribution
        int hash = 0;
        for (int count : frequency) {
            hash = hash * 31 + count;
        }

        return hash;
    }
}
