package com.global.commtech.test.anagramfinder.services.impl;

import com.global.commtech.test.anagramfinder.services.AnagramGroupingService;
import com.global.commtech.test.anagramfinder.services.HashCodeService;
import com.global.commtech.test.anagramfinder.services.PrintAnagramsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BufferedAnagramGroupingService implements AnagramGroupingService {

    private final PrintAnagramsService printAnagramsService;
    private final HashCodeService hashCodeService;

    public void read(String fileName) throws IOException {
        int wordLength = 2;
        var map = new HashMap<Integer, List<String>>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String word;
            while ((word = bufferedReader.readLine()) != null) {
                if (word.length() > wordLength) {
                    // prints all the words of the same length and reset the map
                    printAnagramsService.print(map);
                    map.clear();
                    wordLength++;
                }
                // creating a unique key to add all the anagrams in a bucket of a map
                map.computeIfAbsent(hashCodeService.calculateHashcode(word), k -> new ArrayList<>()).add(word);
            }
            // prints the last group
            printAnagramsService.print(map);
        }
    }
}