import MenuActions.MenuStrategy;

class MenuItem {
    private String description;
    private MenuStrategy strategy;

    public MenuItem(String description, MenuStrategy strategy) {
        this.description = description;
        this.strategy = strategy;
    }

    public String getDescription() {
        return description;
    }

    public void execute() {
        strategy.execute();
    }
}