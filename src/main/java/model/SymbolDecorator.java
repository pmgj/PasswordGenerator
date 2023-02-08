package model;

public class SymbolDecorator extends Decorator {

    public SymbolDecorator(PasswordGenerator tree) {
        super(tree);
        this.value = "!@#$%&*";
    }
}
