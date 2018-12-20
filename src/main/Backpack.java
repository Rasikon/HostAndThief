import java.util.ArrayList;
import java.util.List;

public class Backpack {
    private List<Item> items = new ArrayList<>();


    public List<Item> getItems() {
        return items;
    }

    public void setItems(Item item) {
        items.add(item);
    }
}
