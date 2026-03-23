import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * ReadmeDisplay.java — Reads and prints README.md to the console.
 *
 * Run this class to view the project documentation without opening
 * the file in an editor.
 *
 * Usage:
 *   javac ReadmeDisplay.java
 *   java ReadmeDisplay
 */
public class ReadmeDisplay {

    public static void main(String[] args) {
        displayReadme("README.md");
    }

    public static void displayReadme(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Could not read " + path + ": " + e.getMessage());
        }
    }
}
