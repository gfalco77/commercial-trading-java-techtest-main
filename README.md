# Anagram Finder
A simple command line utility for finding anagrams in a specified file

## Software required to run this
* Java 17

## Building and Running the tests
```
./gradlew clean build
```

## Running the program
```
./gradlew bootRun --args="example2.txt" 
```
where example2.txt is the text file that we want to search for anagrams

## Big O Notation 

### Time Complexity: O(nm)
1. **Reading the file**: Reading each word from the file: O(n), where n is the number of words in the file.
2. **Processing each word**: For each word, the calculateHashcode method is called. This method iterates over each character of the word and then over the frequency array, making it O(m+c), where m is the length of the word and c is the size of the character frequency array (which is constant at 256). Since c is constant, the complexity simplifies to O(m).
3. **Updating the map**: The computeIfAbsent and add operations on the HashMap are amortized O(1) assuming a good hash function and distribution
4. **Printing the map values**: The print method is called periodically which iterates over the values in the map O(n). The map can have up to n entries with words of varying lengths m. So on average it would be O(nm)

### Space Complexity: O(n)

1. **Storing the map:** The space required to store the map is O(n) in the worst case, where each word has a unique hashcode and is stored in separate lists.
2. **Additional data structures:** The space complexity of other data structures used internally, such as ArrayLists for storing lists of anagrams, is also considered. However, these additional data structures contribute insignificantly to the overall space complexity compared to the HashMap.

The largest contributing factor to the complexity is the number of words n and their average length m.

## Decisions

I designed the services with interfaces to promote loose coupling, flexibility, testability, and maintainability. Each service adheres to the single responsibility principle, ensuring that it handles only one task.
To efficiently group anagrams, I used a map with unique keys to store words that are anagrams of each other. This design simplifies the process of printing anagrams. Due to memory constraints, the map is reset whenever a new block of words with a different length is encountered.
However, I have some reservations about the scalability of this solution when dealing with large files. Resetting the map might not be sufficient.
Regarding exception handling, if an error occurs during file processing, the user is prompted to provide an alternative file. This approach ensures robustness and continuity of the process without crashing the application.

## If I had more time?

I would find a way to use multithreading effectively to read and process the file in different batches to avoid out of memory and to speed up the process