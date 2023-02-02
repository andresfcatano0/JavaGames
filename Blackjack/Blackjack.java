import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");

        scan.nextLine();

        int playerCard1 = drawRandomCard();
        int playerCard2 = drawRandomCard();
        int playerSum = Math.min(playerCard1, 10) + Math.min(playerCard2, 10);

        System.out.println("\nYou get a \n" + cardString(playerCard1) + "\nand a \n" + cardString(playerCard2));
        System.out.println("\nYour total is: " + playerSum);

        int dealerCard1 = drawRandomCard();
        int dealerCard2 = drawRandomCard();
        int dealerSum = Math.min(dealerCard1, 10) + Math.min(dealerCard2, 10);

        scan.nextLine();

        System.out.println("\nThe dealer shows \n" + cardString(dealerCard1) + "\nand has a card facing down \n" + faceDown());
        System.out.println("\nThe dealer's total is hidden");

        while (!hitOrStay().equals("stay")){
            int newPlayerCard = drawRandomCard();
            playerSum += Math.min(newPlayerCard, 10);
            System.out.println("\nYou get a\n" + cardString(newPlayerCard));
            System.out.println("\nYour new total is: " + playerSum);
            if (playerSum > 21){
                System.out.println("Bust! Player loses");
                System.exit(0);
            }
        }

        System.out.println("\n\nDealer's turn");
        System.out.println("=============");
        System.out.println("\nThe dealer's cards are \n" + cardString(dealerCard1) + "\nand a \n" + cardString(dealerCard2));
        System.out.println("\nDealer's total is: " + dealerSum);
       
        while (dealerSum < 17) {
            scan.nextLine();
            int newDealerCard = drawRandomCard();
            dealerSum += Math.min(newDealerCard, 10);
            System.out.println("\nDealer gets a \n" + cardString(newDealerCard));
            System.out.println("\nDealer's new total is: " + dealerSum);
            if (dealerSum > 21){
                System.out.println("Bust! Dealer loses");
                System.exit(0);
            }
        }

        if (dealerSum > playerSum) {
            System.out.println("Dealer wins!");
        } else if (playerSum > dealerSum) {
            System.out.println("Player wins!");
        } else {
            System.out.println("We hava a tie!!!");
        }
        
         scan.close();

    }


    public static int drawRandomCard() {
        double randomNum = Math.random() * 13;
        randomNum++;
        return (int)randomNum;
    }


    public static String cardString(int cardNumber){
        switch (cardNumber) {
            case 1: return  "   _____\n"+
                            "  |A _  |\n"+ 
                            "  | ( ) |\n"+
                            "  |(_'_)|\n"+
                            "  |  |  |\n"+
                            "  |____V|\n";

            case 2: return  "   _____\n"+              
                            "  |2    |\n"+ 
                            "  |  o  |\n"+
                            "  |     |\n"+
                            "  |  o  |\n"+
                            "  |____Z|\n";

            case 3: return  "   _____\n" +
                            "  |3    |\n"+
                            "  | o o |\n"+
                            "  |     |\n"+
                            "  |  o  |\n"+
                            "  |____E|\n";

            case 4: return  "   _____\n" +
                            "  |4    |\n"+
                            "  | o o |\n"+
                            "  |     |\n"+
                            "  | o o |\n"+
                            "  |____h|\n";

            case 5: return  "   _____ \n" +
                            "  |5    |\n" +
                            "  | o o |\n" +
                            "  |  o  |\n" +
                            "  | o o |\n" +
                            "  |____S|\n";

            case 6: return  "   _____ \n" +
                            "  |6    |\n" +
                            "  | o o |\n" +
                            "  | o o |\n" +
                            "  | o o |\n" +
                            "  |____6|\n";

            case 7: return  "   _____ \n" +
                            "  |7    |\n" +
                            "  | o o |\n" +
                            "  |o o o|\n" +
                            "  | o o |\n" +
                            "  |____7|\n";

            case 8: return  "   _____ \n" +
                            "  |8    |\n" +
                            "  |o o o|\n" +
                            "  | o o |\n" +
                            "  |o o o|\n" +
                            "  |____8|\n";

            case 9: return  "   _____ \n" +
                            "  |9    |\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |____9|\n";

            case 10: return "   _____ \n" +
                            "  |10  o|\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |___10|\n";

            case 11: return "   _____\n" +
                            "  |J  ww|\n"+ 
                            "  | o {)|\n"+ 
                            "  |o o% |\n"+ 
                            "  | | % |\n"+ 
                            "  |__%%[|\n";

            case 12: return "   _____\n" +
                            "  |Q  ww|\n"+ 
                            "  | o {(|\n"+ 
                            "  |o o%%|\n"+ 
                            "  | |%%%|\n"+ 
                            "  |_%%%O|\n";

            case 13: return "   _____\n" +
                            "  |K  WW|\n"+ 
                            "  | o {)|\n"+ 
                            "  |o o%%|\n"+ 
                            "  | |%%%|\n"+ 
                            "  |_%%%>|\n";
        
            default: return "Never runs";
        }
    }


    public static String faceDown() {
        return
        "   _____\n"+
        "  |     |\n"+ 
        "  |  J  |\n"+
        "  | JJJ |\n"+
        "  |  J  |\n"+
        "  |_____|\n";
    }


    public static String hitOrStay() {
        System.out.println("\nWould you like to hit or stay?");
        String answer = scan.nextLine();
        while (!(answer.equalsIgnoreCase("hit") || answer.equalsIgnoreCase("stay"))){
            System.out.println("\nPlease write 'hit' or 'stay'");
            answer = scan.nextLine();
        }
        return answer;
    }
    
}

