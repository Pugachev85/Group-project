package MenuActions;

public class ExitStrategy implements MenuStrategy {
    @Override
    public void execute() {
        System.out.println("До свидания!");
        System.exit(0);
    }
}
