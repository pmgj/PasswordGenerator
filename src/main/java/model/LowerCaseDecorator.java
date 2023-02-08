package model;

public class LowerCaseDecorator extends Decorator {

    public LowerCaseDecorator(PasswordGenerator tree) {
        super(tree);
        this.value = "qwertyuiopasdfghjklzxcvbnm";
    }
}
