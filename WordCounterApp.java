import java.util.Scanner;

    // Abstract class for WordCounter
    abstract class WordCounter {
        protected String text;

        // Constructor
        public WordCounter(String text) {
            this.text = text;
        }

        // Abstract method to count words
        public abstract int countWords();
    }

    // TextWordCounter class to count words from user input text
    class TextWordCounter extends WordCounter {
        // Constructor
        public TextWordCounter(String text) {
            super(text);
        }

        // Implementing countWords method
        @Override
        public int countWords() {
            String[] words = text.split("[\\s\\p{Punct}]+");
            return words.length;
        }
    }

    // FileWordCounter class to count words from file
    class FileWordCounter extends WordCounter {
        // Constructor
        public FileWordCounter(String text) {
            super(text);
        }

        // Implementing countWords method
        @Override
        public int countWords() {
            String[] words = text.split("[\\s\\p{Punct}]+");
            return words.length;
        }
    }

    public class WordCounterApp {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to Word Counter!");
            System.out.println("Enter 'text' to input text, or 'file' to specify a file to count words: ");
            String inputType = scanner.nextLine().trim().toLowerCase();

            WordCounter wordCounter;

            if (inputType.equals("text")) {
                System.out.println("Enter the text: ");
                String text = scanner.nextLine();
                wordCounter = new TextWordCounter(text);
            }
            else if (inputType.equals("file")) {
                System.out.println("Enter the file path: ");
                String filePath = scanner.nextLine();
                String text = readTextFromFile(filePath);
                wordCounter = new FileWordCounter(text);
            }
            else {
                System.out.println("Invalid input type. Please enter 'text' or 'file'.");
                return;
            }

            int wordCount = wordCounter.countWords();
            System.out.println("Total count of words: " + wordCount);
            scanner.close();
        }

        // Method to read text from file
        private static String readTextFromFile(String filePath) {
            // Implementation to read text from file
            return "Sample text from file"; // Placeholder implementation
        }
    }
