package model;

public class LengthGenerator implements PasswordGenerator {
    private int quantity;

    public LengthGenerator(int quantity) {
        this.quantity = quantity;
    }

    public String execute() {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < quantity; i++) {
            out.append(" ");
        }
        return out.toString();
    }

    @Override
    public void setChange(boolean change) {

    }
}
