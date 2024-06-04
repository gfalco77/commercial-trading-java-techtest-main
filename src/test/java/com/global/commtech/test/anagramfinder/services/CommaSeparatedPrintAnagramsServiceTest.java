package com.global.commtech.test.anagramfinder.services;

import com.global.commtech.test.anagramfinder.services.impl.CommaSeparatedPrintAnagramsService;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CommaSeparatedPrintAnagramsServiceTest {

    @Test
    void testPrint() {
        // Given
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        CommaSeparatedPrintAnagramsService printAnagramsService = new CommaSeparatedPrintAnagramsService();

        Map<Integer, List<String>> anagramsMap = new HashMap<>();
        anagramsMap.put(1, Arrays.asList("abc", "cba"));
        anagramsMap.put(2, Arrays.asList("xyz", "yzx"));

        // When
        printAnagramsService.print(anagramsMap);

        // Then
        String expectedOutput = "abc,cba\nxyz,yzx\n";
        String actualOutput = outputStream.toString();
        assert actualOutput.equals(expectedOutput);

    }
}
