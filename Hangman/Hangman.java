import java.util.Scanner;

public class Hangman {

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String word(String[] words) {
        int num = (int) (Math.random() * words.length);
        String word = words[num];
        return word;
    }


    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};




    

    public static boolean fail(int wrongGuesses) {
        if (wrongGuesses == 6) {
            System.out.println(gallows[6]);
            System.out.println("You dead!!!");
            System.exit(0);
        }
        return false;
    }


    public static void main(String[] args) {

        int gallowsCount = 0;

        System.out.println(gallows[0]);
        

        String word = word(words);
        System.out.println(word);

        char[] wordArray = new char[word.length()];

        // System.out.print("Word:\t");

        for (int i = 0; i < wordArray.length; i++) {
            wordArray[i] = '_';
        }

        // for (int i = 0; i < wordArray.length; i++) {
        //     System.out.print(wordArray[i] + " ");
        // }

        
        Scanner input = new Scanner(System.in); 
        System.out.print("Guess: ");
        char guess = input.next().charAt(0);
        System.out.println();


        int wrongGuesses = 0;

        String wordComp = "";
        
        while (true) {

            System.out.print("Word:\t");
            
            for (int i = 0; i < wordArray.length; i++) {
                char letter = word.charAt(i);
                if (guess == letter){
                    wordArray[i] = guess;
                } 
                
                System.out.print(wordArray[i] + " ");
            
            }

            System.out.println("\n");

            if (word.indexOf(guess) == -1) {
                System.out.println("Wrong guess\n");
                wrongGuesses++;
                gallowsCount++;
                fail(wrongGuesses);
            }

            System.out.println(gallows[gallowsCount]);

            for (int i = 0; i < wordArray.length; i++){
                wordComp += wordArray[i];
            }

            if (wordComp.equals(word)){
                System.out.println("You Win!!!!!!");
                System.exit(0);
            } else {
                wordComp = "";
            }



            System.out.print("Guess: ");
        
            guess = input.next().charAt(0);
            
        }

        




    }

}





