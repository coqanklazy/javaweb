package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Cart implements Serializable {
    private ArrayList<LineItem> items;

    public Cart() {
        items = new ArrayList<LineItem>();
    }

    public ArrayList<LineItem> getItems() {
        return items;
    }

    public int getCount() {
        return items.size();
    }

    public void addItem(LineItem item) {
        String code = item.getProduct().getCode();
        int quantity = item.getQuantity();

        // Check if item already exists in cart
        for (LineItem lineItem : items) {
            if (lineItem.getProduct().getCode().equals(code)) {
                lineItem.setQuantity(lineItem.getQuantity() + quantity);
                return;
            }
        }
        items.add(item);
    }

    public void removeItem(String productCode) {
        for (int i = 0; i < items.size(); i++) {
            LineItem item = items.get(i);
            if (item.getProduct().getCode().equals(productCode)) {
                items.remove(i);
                return;
            }
        }
    }

    public void updateQuantity(String productCode, int quantity) {
        for (LineItem item : items) {
            if (item.getProduct().getCode().equals(productCode)) {
                item.setQuantity(quantity);
                return;
            }
        }
    }
}
