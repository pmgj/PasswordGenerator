package model;

import java.util.Random;

public class SymbolDecorator extends Decorator {
    private String value = "!@#$%&*";

    public SymbolDecorator(PasswordGenerator tree) {
        super(tree);
    }

    public String execute() {
        var str = super.execute();
        var temp = new StringBuilder(str);
        var r = new Random();
        for (int i = 0; i < temp.length(); i++) {
            var b = r.nextInt(10);
            if(b == 0) {
                int index = r.nextInt(value.length());
                temp.setCharAt(i, value.charAt(index));    
            }
        }
        return temp.toString();
    }
}
