package com.global.commtech.test.anagramfinder.services.impl;

import com.global.commtech.test.anagramfinder.services.PrintAnagramsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CommaSeparatedPrintAnagramsService implements PrintAnagramsService {

    @Override
    public void print(Map<Integer, List<String>> map) {
        map.values().stream()
                    .map(values -> String.join(",", values))
                    .forEach(System.out::println);
    }
}