package model;

import java.util.Random;

public abstract class Decorator implements PasswordGenerator {
    protected PasswordGenerator tree;
    protected boolean change = false;
    protected String value;

    public Decorator(PasswordGenerator pw) {
        this.tree = pw;
    }

    public void setChange(boolean change) {
        this.change = change;
    }

    @Override
    public String execute() {
        var str = tree.execute();
        var temp = new StringBuilder(str);
        var r = new Random();
        for (int i = 0; i < temp.length(); i++) {
            var b = r.nextInt(10);
            if ((this.change || b < 4) && temp.charAt(i) == ' ') {
                int index = r.nextInt(value.length());
                temp.setCharAt(i, value.charAt(index));

            }
        }
        return temp.toString();
    }
}
