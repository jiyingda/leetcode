package sjms.a;

public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "coke";
    }

    @Override
    public float price() {
        return 20f;
    }
}
