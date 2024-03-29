package vendingmachine;

import coin.Coin;
import java.util.*;
//import vendingmachine.VendingMachine;  
import item.Item;

public class VendingMachineStatus {

    public VendingMachineStatus(){
        System.out.println("machine is in ideal state.");
    }

    public void clickOnStartProductSelectionButton(){
        System.out.println("vending machine is in hasMoneyState.");
    }

    public void insertCoin(Coin coin){
        System.out.println("Vending machine is in hasMoneyState");
        System.out.println("Accepted the coin");
    }

    public void chooseProduct(VendingMachine vendingMachine, int itemCodeNumber){

        Item item = vendingMachine.getInventory().getItem(itemCodeNumber);
        int paidByUser=0;
        for(Coin coin: vendingMachine.getCoinList()){
            paidByUser+=coin.getValue();
        }

        if(paidByUser<item.getPrice()){
            refundFullMoney(vendingMachine);
            return ;
        }else{
            getChange(item.getPrice(), paidByUser);
            dispenseProduct(vendingMachine, itemCodeNumber);
            return;
        }


    }

    public List<Coin> refundFullMoney(VendingMachine vendingMachine){
        System.out.println("Redunding the full amount back in the matchine tray.");
        vendingMachine.setVendingMachineStatus(new VendingMachineStatus());
        return vendingMachine.getCoinList();
    }

    public void updateInventory(VendingMachine vendingMachine, Item item, int itemCodeNumber ){
        vendingMachine.getInventory().addItem(item, itemCodeNumber);

    }

    public void dispenseProduct(VendingMachine vendingMachine , int itemCodeNumber){
        System.out.println("item is being dispensed.");
        System.out.println("item is dispensed.");
        vendingMachine.getInventory().updateSoldOutItem(itemCodeNumber);
        vendingMachine.setVendingMachineStatus(new VendingMachineStatus());


    }

    public void getChange(int itemPrice , int paidByUser){
        System.out.println("Returning the change in the machine tray: "+(paidByUser-itemPrice));

    }

}
