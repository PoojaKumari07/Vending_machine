import coin.Coin;
import item.Item;
import item.ItemShelf;
import vendingmachine.VendingMachine;
import vendingmachine.VendingMachineStatus;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // int value = Coin.FIFTY.getValue();
        // System.out.println(value);
        VendingMachine vendingmachine = new VendingMachine();
        System.out.println("| Fill the Inventory |");
        fillInventory(vendingmachine);

        System.out.println("Display the Inventory");

        displayInventory(vendingmachine);

        VendingMachineStatus vendingMachineStatus = vendingmachine.getVendingMachineStatus();
        vendingMachineStatus.insertCoin(vendingmachine, Coin.FIFTY);
        vendingMachineStatus.insertCoin(vendingmachine, Coin.TWENTY);

        vendingMachineStatus.chooseProduct(vendingmachine, 102);
        displayInventory(vendingmachine);

    }

    private static void fillInventory(VendingMachine vendingmachine) {
        ItemShelf[] itemshelfSlots = vendingmachine.getInventory().getInventory();
        for (int i = 0; i < itemshelfSlots.length; i++) {
            Item item = new Item();
            if (i == 0 || i == 8) {
                item.setItemType("OREO");
                item.setPrice(30);
            } else if (i == 1 || i == 9) {
                item.setItemType("JUICE");
                item.setPrice(40);
            } else if (i == 2) {
                item.setItemType("COKE");
                item.setPrice(45);
            } else if (i == 3) {
                item.setItemType("SODA");
                item.setPrice(20);
            } else if (i == 4) {
                item.setItemType("CHIPS");
                item.setPrice(10);
            } else if (i == 5) {
                item.setItemType("CHOCOLATE");
                item.setPrice(60);
            } else if (i == 6) {
                item.setItemType("CANDY");
                item.setPrice(5);
            } else if (i == 7) {
                item.setItemType("GUM");
                item.setPrice(5);
            }
            itemshelfSlots[i].setItem(item);
            itemshelfSlots[i].setSolOut(false);
        }
    }

    private static void displayInventory(VendingMachine vendingmachine) {
        ItemShelf[] itemShelfSlots = vendingmachine.getInventory().getInventory();
        System.out.println(itemShelfSlots.length);
        for (ItemShelf shelf : itemShelfSlots) {
            System.out.println("Item code: " + shelf.getItemCode() + " Item: " + shelf.getItem().getType() + " Price: "
                    + shelf.getItem().getPrice() + " isAvailable: " + !shelf.isSoldOut());
        }
    }

}
