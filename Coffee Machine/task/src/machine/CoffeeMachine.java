package machine;

import java.util.Scanner;

public class CoffeeMachine {
    final static Scanner scanner = new Scanner(System.in);
    private int water = 400;
    private int milk = 540;
    private int coffee_bean = 120;
    private int disp_cup = 9;
    private int money = 550;

    private void status() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffee_bean + " of coffee beans");
        System.out.println(disp_cup + " of disposable cups");
        System.out.println("$" + money + " of money");
    }

    private int buyCoffee(int water, int beans, int milk, int cost) {
        if (this.water - water < 0) {
            return 1;
        }
        if (this.coffee_bean - beans < 0) {
            return 2;
        }
        if (this.milk - milk < 0) {
            return 3;
        }
        if (this.disp_cup == 0) {
            return 4;
        }
        this.water -= water;
        this.coffee_bean -= beans;
        this.milk -= milk;
        this.money += cost;
        this.disp_cup--;
        return 0;
    }

    private void response (int n) {
        String low = "";
        switch (n) {
            case 0:
                System.out.println("I have enough resources, making you a coffee!");
                return;
            case 1:
                low = "water";
                break;
            case 2:
                low = "coffee beans";
                break;
            case 3:
                low = "milk";
                break;
            case 4:
                low = "disposable cups";
                break;
        }
        System.out.println("Sorry, not enough " + low + "!");
    }

    private void buy(String n) {
        switch (n) {
            case "1":
                response(buyCoffee(250,16,0,4));
                break;
            case "2":
                response(buyCoffee(350, 20, 75, 7));
                break;
            case "3":
                response(buyCoffee(200, 12, 100, 6));
                break;
            case "back":
                break;
        }
    }

    private void fill() {
        System.out.println("Write how many ml of water do you want to add: ");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        coffee_bean += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        disp_cup += scanner.nextInt();
    }

    public void action() {
        System.out.println();
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        String inp = scanner.next();
        switch (inp) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                String type = scanner.next();
                buy(type);
                break;

            case "fill":
                fill();
                break;

            case "take":
                System.out.println("I gave you $" + money);
                money = 0;
                break;
            case "remaining":
                status();
                break;
            case "exit":
                System.exit(0);
                break;
        }
    }


    public static void main(String[] args) {
        CoffeeMachine cm = new CoffeeMachine();
        while (true) {
            cm.action();
        }
    }
}
