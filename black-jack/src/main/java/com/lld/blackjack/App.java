package com.lld.blackjack;

import com.lld.blackjack.accounts.Dealer;
import com.lld.blackjack.accounts.Player;
import com.lld.blackjack.game.Game;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
/*TODO :
    1. Logic checking
    2. Split functionality
    3. end to end logging
    4. command and strategy pattern
    5. Break game class
  */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Scanner sc = new Scanner(System.in);
        Game game = Game.getInstance();
        Player player = new Player("testPlayer","134",5000.00);
        Dealer dealer = new Dealer("testDealer","1234");
        game.init(player,dealer,sc);
        game.startGame(sc);
    }
}
