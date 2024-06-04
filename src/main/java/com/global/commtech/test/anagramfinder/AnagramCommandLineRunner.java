package com.global.commtech.test.anagramfinder;

import com.global.commtech.test.anagramfinder.services.impl.BufferedAnagramGroupingService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class AnagramCommandLineRunner implements CommandLineRunner {

    private final BufferedAnagramGroupingService anagramGroupingService;

    @Override
    public void run(final String... args) throws Exception {
        Assert.isTrue(args.length == 1, "Please ensure that the input file is provided");

        final File file = new File(args[0]);
        Assert.isTrue(file.exists(), args[0] + " Does not exist");

        try {
            anagramGroupingService.read(args[0]);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            Scanner scanner = new Scanner(System.in);
            System.out.println("Do you want to specify another file? (y/n)");
            String choice = scanner.nextLine().trim().toLowerCase();
            if (choice.equals("y")) {
                System.out.print("Enter the input file name: ");
                String newFileName = scanner.nextLine().trim();
                run(newFileName);
            }
        }
    }
}
