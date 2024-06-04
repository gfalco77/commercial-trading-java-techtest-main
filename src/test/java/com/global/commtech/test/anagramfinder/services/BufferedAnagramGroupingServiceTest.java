package com.global.commtech.test.anagramfinder.services;

import com.global.commtech.test.anagramfinder.services.impl.BufferedAnagramGroupingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.*;

public class BufferedAnagramGroupingServiceTest {

    @Mock
    private PrintAnagramsService printAnagramsService;

    @Mock
    private HashCodeService hashCodeService;

    @InjectMocks
    private BufferedAnagramGroupingService bufferedAnagramGroupingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRead_FileNotFound() {
        // Test with a non-existent file
        assertThrows(IOException.class, () -> bufferedAnagramGroupingService.read("file.txt"));
    }

    @Test
    public void testRead_withValidFile() throws IOException {
        // Given
        doNothing().when(printAnagramsService).print(anyMap());
        when(hashCodeService.calculateHashcode(anyString())).thenReturn(123); // Return a fixed value

        // When
        bufferedAnagramGroupingService.read("example2.txt");

        // Then: Verify interactions with mocked service
        verify(printAnagramsService, times(27)).print(anyMap());
    }
}
