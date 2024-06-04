package com.global.commtech.test.anagramfinder.services;

import java.util.List;
import java.util.Map;

public interface PrintAnagramsService {

    void print(Map<Integer, List<String>> words);
}