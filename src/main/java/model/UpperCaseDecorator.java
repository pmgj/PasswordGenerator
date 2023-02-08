package model;

public class UpperCaseDecorator extends Decorator {

    public UpperCaseDecorator(PasswordGenerator tree) {
        super(tree);
        this.value = "QWERTYUIOPASDFGHJKLZXCVBNM";
    }
}
