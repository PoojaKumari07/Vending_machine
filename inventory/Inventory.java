package inventory;

import item.ItemShelf;
import item.Item;
public class Inventory {

    private ItemShelf[] inventory;

    public Inventory(int n){
        inventory =new ItemShelf[n];
        initialEmptyInventory();

    }

    public ItemShelf[] getInventory(){
        return this.inventory;
    }

    public void setInventory(ItemShelf[] inventory){
        this.inventory=inventory;
    }

    public void initialEmptyInventory(){
        int stratCode=101;
        for(int i=0; i<inventory.length; i++){
            ItemShelf itemShelf=new ItemShelf();
            itemShelf.setItemCode(stratCode);
            itemShelf.setSolOut(true);
            inventory[i]=itemShelf;
            stratCode++;

        }
    }

    public void addItem(Item item , int itemCode){
        for(ItemShelf shelf: inventory){
            if(shelf.getItemCode() == itemCode){
                if(shelf.isSoldOut()==true){
                    shelf.setItem(item);
                    shelf.setSolOut(false);
                }
            }
        }
    }

    public Item getItem(int itemCode){
        for(ItemShelf shelf:inventory){
            if(shelf.getItemCode()==itemCode){
                if(shelf.isSoldOut()){
                    System.out.println("Sorry item is not availabe.");
                    return new Item();
                }else{
                    return shelf.getItem();
                }
            }
        }
        System.out.println("Invalid item code.");
        return new Item();
    }

    public void updateSoldOutItem(int itemCodeNumber){
        for(ItemShelf shelf:inventory){
            if(shelf.getItemCode()==itemCodeNumber){
                shelf.setSolOut(true);
            }
        }
    }

}
