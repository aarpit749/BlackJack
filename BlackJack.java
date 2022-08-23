import java.util.Scanner;

public class BlackJack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
        scan.nextLine();
        //Task 3 – Wait for the user to press enter.
        //Task 4 – Get two random cards.
        //       – Print them: \n You get a \n" + <randomCard> + "\n and a \n" + <randomCard>
        int n1 = drawRandomCard();
        int n2 = drawRandomCard();
        System.out.println(" You get a \n" + cardString(n1) + "\n and a \n" + cardString(n2));
        
        //Task 5 – Print the sum of your hand value.
        //       – print: your total is: <hand value>
        int total = n1 + n2;
        System.out.println("Your total is: " + total);
        
        //Task 6 – Get two random cards for the dealer.
        //       – Print: The dealer shows \n" + <first card> + "\nand has a card facing down \n" + <facedown card>
        //       – Print: \nThe dealer's total is hidden
        int d1 = drawRandomCard();
        int d2 = drawRandomCard(); 
        System.out.println("\nThe dealer shows \n" + cardString(d1) + "\nand has a card facing down \n" + faceDown());
        System.out.println("\nThe dealer's total is hidden");
       
        //Task 8 – Keep asking the player to hit or stay (while loop).
        //       1. Every time the player hits
        //             – draw a new card.
        //             – calculate their new total.
        //             – print: (new line) You get a (new line) <show new card>.
        //             - print: your new total is <total>

        //       2. Once the player stays, break the loop. 
        
        int n,d;
        String choice = hitOrStay() ;
        while (choice.equals("hit")) 
        {
            n = drawRandomCard();
            System.out.println("\nYou get a \n" + cardString(n));
            total = total + n;
            System.out.println("Your new total is: " + total);   
            if(total>21)
            {
                System.out.println("Bust! Player loses");
                System.exit(0);
            }
            System.out.println("Would you like to hit or stay?");
            choice = scan.nextLine();
        }
        System.out.println("\nDealer's turn");
        System.out.println("\n The dealer's card are \n" + cardString(d1) + "\n and a \n" + cardString(d2));
        int dtotal = d1+d2;
        System.out.println("\nDealer's total is " + dtotal);
        while(dtotal < 17)
        {
            d = drawRandomCard();
            System.out.println("\nDealer gets a\n" + cardString(d));
            dtotal = dtotal+d;
            System.out.println("\nDealer's total is " + dtotal);
        }
        if(dtotal > 21)
        {
            System.out.println("Bust! Dealer loses");
            System.exit(0);
        }
        if(total > dtotal)
        {
            System.out.println("\nPlayer wins!\n");
        }
        else if(total < dtotal)
        {
            System.out.println("\nDealer wins!\n");
        }
        else
        {
            System.out.println("\nDRAW\n");
        }
        
        scan.close();

    }
    
    /** Task 1 – make a function that returns a random number between 1 and 13
     * Function name – drawRandomCard
     * @return (int)
     *
     * Inside the function:
     *   1. Gets a random number between 1 and 13.
     *   2. Returns a card.
     */

    static int drawRandomCard()
    {
        double randomnum = Math.random() * 13;
        randomnum+=1;
        int rand = (int) randomnum;
        return rand;
    }
    /** Task 2 – make a function that returns a String drawing of the card.
     * Function name – cardString
     * @param cardNumber (int)
     * @return (String)
     *
     * Inside the function:
     *   1. Returns a String drawing of the card.
     */
    static String cardString(int cardNumber)
    {
        switch(cardNumber) 
        {
            case 1: return "   _____\n"+
                           "  |A _  |\n"+ 
                           "  | ( ) |\n"+
                           "  |(_'_)|\n"+
                           "  |  |  |\n"+
                           "  |____V|\n";                 
            case 2: return "   _____\n"+              
                           "  |2    |\n"+ 
                           "  |  o  |\n"+
                           "  |     |\n"+
                           "  |  o  |\n"+
                           "  |____Z|\n";
            case 3: return "   _____\n" +
                           "  |3    |\n"+
                           "  | o o |\n"+
                           "  |     |\n"+
                           "  |  o  |\n"+
                           "  |____E|\n";
            case 4: return "   _____\n" +
                           "  |4    |\n"+
                           "  | o o |\n"+
                           "  |     |\n"+
                           "  | o o |\n"+
                           "  |____h|\n";
            case 5: return "   _____ \n" +
                           "  |5    |\n" +
                           "  | o o |\n" +
                           "  |  o  |\n" +
                           "  | o o |\n" +
                           "  |____S|\n";
            case 6: return "   _____ \n" +
                           "  |6    |\n" +
                           "  | o o |\n" +
                           "  | o o |\n" +
                           "  | o o |\n" +
                           "  |____6|\n";
            case 7: return "   _____ \n" +
                           "  |7    |\n" +
                           "  | o o |\n" +
                           "  |o o o|\n" +
                           "  | o o |\n" +
                           "  |____7|\n";
            case 8: return "   _____ \n" +
                           "  |8    |\n" +
                           "  |o o o|\n" +
                           "  | o o |\n" +
                           "  |o o o|\n" +
                           "  |____8|\n";
            case 9: return "   _____ \n" +
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
            default: return "Not required";
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
    
    /** Task 7 – make a function that asks the user to hit or stay.
     * Function name – hitOrStay
     * @return (String)
     *
     * Inside the function:
     *   1. Asks the user to hit or stay.
     *   2. If the user doesn't enter "hit" or "stay", keep asking them to try again by printing:
     *      Please write 'hit' or 'stay'
     *   3. Returns the user's option 
     */
    public static String hitOrStay()
    {
        System.out.println("Would you like to hit or stay?");
        String choice = scan.nextLine();
        while(!choice.equals("stay") && !choice.equals("hit"))
        {
            System.out.println("Please write 'hit' or 'stay'");
            choice = scan.nextLine();
        }
        return choice;
    }
}