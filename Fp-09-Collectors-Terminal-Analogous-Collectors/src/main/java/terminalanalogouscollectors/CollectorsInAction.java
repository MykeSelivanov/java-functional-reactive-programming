package terminalanalogouscollectors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Spliterator;
import java.util.stream.Stream;

public class CollectorsInAction {
    public static void main(String[] args) {

        Path path = Paths.get("/Users/mykhailoselivanov/Documents/java-projects/java-functional-programming/Fp-09-Collectors-Terminal-Analogous-Collectors/src/main/java/terminalanalogouscollectors/EmployeeData");

        try (Stream<String> lines = Files.lines(path)) {

            // getting flatten stream on all the words present in the file
            Stream<String> words = lines.flatMap(line -> Arrays.stream(line.split(",")));

            // creating a base spliterator
            Spliterator<String> wordsSpliterator = words.spliterator();

            // creating a custom spliterator, that will read Employee objects based on base words spliterator
            Spliterator<Employee> employeeSpliterator = new EmployeeSpliterator(wordsSpliterator);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}