package model;

import java.util.Random;

public class LowerCaseDecorator extends Decorator {
    private String value = "qwertyuiopasdfghjklzxcvbnm";

    public LowerCaseDecorator(PasswordGenerator tree) {
        super(tree);
    }

    public String execute() {
        var str = super.execute();
        var temp = new StringBuilder(str);
        var r = new Random();
        for (int i = 0; i < temp.length(); i++) {
            var b = r.nextInt(10);
            if ((temp.charAt(i) == ' ' && b < 4) || b == 0) {
                int index = r.nextInt(value.length());
                temp.setCharAt(i, value.charAt(index));

            }
        }
        return temp.toString();
    }
}
