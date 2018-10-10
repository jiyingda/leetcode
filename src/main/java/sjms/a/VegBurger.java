package sjms.a;

public class VegBurger extends Burger {
    @Override
    public String name() {
        return "VegBurgerIng";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
