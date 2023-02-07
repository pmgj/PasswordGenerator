package model;

public abstract class Decorator implements PasswordGenerator {
    private PasswordGenerator tree;

    public Decorator(PasswordGenerator pw) {
        this.tree = pw;
    }

    @Override
    public String execute() {
        return tree.execute();
    }
}
