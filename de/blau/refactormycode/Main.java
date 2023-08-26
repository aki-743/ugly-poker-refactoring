package de.blau.refactormycode;

public class Main {
    public static void main(String[] args) {
        UglyPoker uglyPoker = new UglyPoker("s05", "d10", "h07", "c03", "s08");
        int result = uglyPoker.compareHighCard("s09", "d06", "h04", "c02", "s10");
        
        if (result > 0) {
            System.out.println("自分の手札が勝ちました。");
        } else if (result < 0) {
            System.out.println("相手の手札が勝ちました。");
        } else {
            System.out.println("引き分けです。");
        }
    }
}
