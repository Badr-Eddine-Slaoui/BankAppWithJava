package util;

import java.util.Scanner;

public class HandleInput implements AutoCloseable{
    private static final Scanner scanner = new Scanner(System.in);

    public static int getInt(String prompt){
        System.out.print(prompt);

        while (!scanner.hasNextInt()){
            System.out.println("Invalid Input Please Try Again");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static double getDouble(String prompt){
        System.out.print(prompt);

        while (!scanner.hasNextDouble()){
            System.out.println("Invalid Input Please Try Again");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public static String getString(String prompt){
        System.out.print(prompt);
        return scanner.nextLine();
    }

    @Override
    public void close(){
        scanner.close();
    }
}
