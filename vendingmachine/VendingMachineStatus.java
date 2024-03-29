package vendingmachine;

import coin.Coin;
import java.util.*;
//import vendingmachine.VendingMachine;
import item.Item;

public class VendingMachineStatus {

    public VendingMachineStatus() {
        System.out.println("machine is in ideal state.");
    }

    public void clickOnStartProductSelectionButton() {
        System.out.println("vending machine is in has MoneyState.");
    }

    public void insertCoin(VendingMachine vendingmachine, Coin coin) {
        System.out.println("Vending machine is in hasMoneyState");
        System.out.println("Accepted the coin");
    }

    public void chooseProduct(VendingMachine vendingmachine, int itemCodeNumber) {

        Item item = vendingmachine.getInventory().getItem(itemCodeNumber);
        int paidByUser = 0;
        for (Coin coin : vendingmachine.getCoinList()) {
            paidByUser += coin.getValue();
        }

        if (paidByUser < item.getPrice()) {
            refundFullMoney(vendingmachine);
            return;
        } else {
            getChange(item.getPrice(), paidByUser);
            dispenseProduct(vendingmachine, itemCodeNumber);
            return;
        }

    }

    public List<Coin> refundFullMoney(VendingMachine vendingmachine) {
        System.out.println("Redunding the full amount back in the matchine tray.");
        vendingmachine.setVendingMachineStatus(new VendingMachineStatus());
        return vendingmachine.getCoinList();
    }

    public void updateInventory(VendingMachine vendingmachine, Item item, int itemCodeNumber) {
        vendingmachine.getInventory().addItem(item, itemCodeNumber);

    }

    public void dispenseProduct(VendingMachine vendingmachine, int itemCodeNumber) {
        System.out.println("item is being dispensed.");
        System.out.println("item is dispensed.");
        vendingmachine.getInventory().updateSoldOutItem(itemCodeNumber);
        vendingmachine.setVendingMachineStatus(new VendingMachineStatus());

    }

    public void getChange(int itemPrice, int paidByUser) {
        System.out.println("Returning the change in the machine tray: " + (paidByUser - itemPrice));

    }

}
