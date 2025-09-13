public class Menu {
    private final String[] items;

    private Menu(String[] items) {
        this.items = items;
    }

    public void display() {
        System.out.println("\nВыберите действие:");
        for (int i = 0; i < items.length; i++) {
            System.out.println((i + 1) + ". " + items[i]);
        }
    }

    public static class Builder {
        private String[] items = new String[0];

        public Builder() {}

        public Builder addItem(String item) {
            String[] newItems = new String[items.length + 1];
            System.arraycopy(items, 0, newItems, 0, items.length);
            newItems[items.length] = item;
            items = newItems;
            return this;
        }

        public Menu build() {
            return new Menu(items);
        }
    }
}
