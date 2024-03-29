package vendingmachine;

import inventory.Inventory;
import coin.Coin;
import java.util.*;

public class VendingMachine {

    private Inventory inventory;
    private VendingMachineStatus vendingMachineStatus;
    private List<Coin> CoinList;

    public VendingMachine(){
        vendingMachineStatus=new VendingMachineStatus();
        inventory= new Inventory(10);
        CoinList= new ArrayList<>();
    }

    public List<Coin> getCoinList(){
        return this.CoinList;

    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public VendingMachineStatus getVendingMachineStatus(){
        return this.vendingMachineStatus;
    }

    public void setVendingMachineStatus(VendingMachineStatus vendingMachineStatus){
        this.vendingMachineStatus=vendingMachineStatus;
    }

    public Inventory getInventory(){
        return this.inventory;
    }
    public void setInventory(Inventory inventory){
        this.inventory = inventory;

    }


}
