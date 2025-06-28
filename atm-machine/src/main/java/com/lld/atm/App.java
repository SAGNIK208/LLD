package com.lld.atm;

import com.lld.atm.ATMState.ATMState;
import com.lld.atm.ATMState.ATMStates;
import com.lld.atm.ATMState.ExitState;
import com.lld.atm.Models.Card;
import com.lld.atm.Models.Cash;
import com.lld.atm.Models.OperationType;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ATM atm = ATM.getInstance();
        while(atm.getAtmState().getState() != ATMStates.EXIT){
            try{
                ATMState atmState = atm.getAtmState();
                ATMStates state = atmState.getState();
                System.out.println(state);
                switch (state){
                    case IDLE:
                        atmState.insertCard(new Card("12345"));
                        break;
                    case AUTHENTICATING:
                        atmState.authenticate("12345");
                        break;
                    case READY:
                        atmState.selectTransaction(OperationType.WITHDRAW);
                        break;
                    case VERIFYING_BALANCE:
                        double amount = atmState.viewBalance();
                        System.out.println(amount);
                        break;
                    case WITHDRAWING:
                        Cash cash = atmState.withdraw(500);
                        System.out.println(cash);
                        break;
                }
            }catch (Exception e){
                atm.nextState(new ExitState(atm));
            }
        }

    }
}
