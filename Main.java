import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CaffeinatedBeverage[] inventory = new CaffeinatedBeverage[10];
        Scanner keyboard = new Scanner(System.in);

        int choice;
        int ounces;
        int brewTemp;
        int count = 0;
        String name;
        double price;

        do {
            System.out.println("1) Enter new Tea");
            System.out.println("2) Enter new Yerba Mate");
            System.out.println("3) Exit");
            System.out.print(">> ");
            choice = keyboard.nextInt();
            keyboard.nextLine();

            switch (choice) {
                case 1:
                    if (count >= inventory.length) {
                        System.out.println("Inventory is full.");
                        break;
                    }

                    System.out.print("Enter name      : ");
                    name = keyboard.nextLine();
                    System.out.print("Enter ounces    : ");
                    ounces = keyboard.nextInt();
                    System.out.print("Enter price     $ ");
                    price = keyboard.nextDouble();
                    System.out.print("Enter brew temperature (in Celsius): ");
                    brewTemp = keyboard.nextInt();
                    keyboard.nextLine();

                    inventory[count] = new Tea(name, ounces, price, brewTemp);
                    System.out.println("Your tea order has been added: " + inventory[count]);
                    count++;
                    break;

                case 2:
                    if (count >= inventory.length) {
                        System.out.println("Inventory is full.");
                        break;
                    }

                    System.out.print("Enter name      : ");
                    name = keyboard.nextLine();
                    System.out.print("Enter ounces    : ");
                    ounces = keyboard.nextInt();
                    System.out.print("Enter price     $ ");
                    price = keyboard.nextDouble();
                    System.out.print("Enter brew temperature (in Celsius): ");
                    brewTemp = keyboard.nextInt();
                    keyboard.nextLine();

                    inventory[count] = new YerbaMate(name, ounces, price, brewTemp, 0);
                    System.out.println("Your yerba mate order has been added: " + inventory[count]);
                    count++;
                    break;

                case 3:
                    System.out.println("\nInventory:");
                    for (int i = 0; i < inventory.length; i++) {
                        if (inventory[i] != null) {
                            System.out.println(inventory[i]);
                        }
                    }

                    System.out.printf("Average price: $%.2f%n", findAveragePrice(inventory));

                    YerbaMate highest = findHighestPricedYerbaMate(inventory);
                    if (highest != null) {
                        System.out.println("Highest priced Yerba Mate: " + highest);
                    } else {
                        System.out.println("No Yerba Mate in inventory.");
                    }
                    break;

                default:
                    System.out.println("Invalid option.");
                    break;
            }

        } while (choice != 3);

        keyboard.close();
    }

    public static double findAveragePrice(CaffeinatedBeverage[] inventory) {
        double total = 0;
        int count = 0;

        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null) {
                total += inventory[i].getPrice();
                count++;
            }
        }

        if (count == 0) {
            return 0;
        }

        return total / count;
    }

    public static YerbaMate findHighestPricedYerbaMate(CaffeinatedBeverage[] inventory) {
        YerbaMate highest = null;

        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] instanceof YerbaMate) {
                YerbaMate current = (YerbaMate) inventory[i];

                if (highest == null || current.getPrice() > highest.getPrice()) {
                    highest = current;
                }
            }
        }

        return highest;
    }
}