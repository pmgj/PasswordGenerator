package model;

public class NumberDecorator extends Decorator {

    public NumberDecorator(PasswordGenerator tree) {
        super(tree);
        this.value = "0123456789";
    }
}
