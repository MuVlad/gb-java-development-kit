package mu.vlad.seminar_6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MontyHall {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random generator = new Random();
        int userDoor, openDoor, otherDoor;

        // generate random value 1 to 3
        int prizeDoor = generator.nextInt(3) + 1;
        int goatDoor1 = prizeDoor;
        while (goatDoor1 == prizeDoor) {
            goatDoor1 = generator.nextInt(3) + 1;
        }
        int goatDoor2 = goatDoor1;
        while (goatDoor2 == goatDoor1 || goatDoor2 == prizeDoor) {
            goatDoor2 = generator.nextInt(3) + 1;
        }

        // begin Game
        System.out.println("Welcome to the Monty Hall game show!");
        System.out.print("Select the door (1, 2, or 3): ");
        userDoor = scan.nextInt();

        // validation
        if (userDoor > 3 || userDoor <= 0) {
            System.out.print("Please select door 1, 2, or 3");
            userDoor = scan.nextInt();
        } else {
            if(userDoor == goatDoor1) {
                openDoor = goatDoor2;
                otherDoor = prizeDoor;
            } else if(userDoor == goatDoor2) {
                openDoor = goatDoor1;
                otherDoor = prizeDoor;
            } else {
                openDoor = goatDoor1;
                otherDoor = goatDoor2;
            }

            System.out.println("\nIn a moment, I will show you "
                    + " where the prize is located, but first I will"
                    + " show you what is behind one of the other doors");
            System.out.println("\nBehind door number " + openDoor
                    + " are goats!");
            System.out.println("You selected door number " + userDoor);
            System.out.print("\nWould you like to switch your"+
                    " door (y/n)? ");

            // take user input Yes or No
            char userReply = scan.next().charAt(0);
            while (userReply != 'y' && userReply != 'n') {
                System.out.print("Please enter either y/n");
                userReply = scan.next().charAt(0);
            }
            if (userReply == 'y') {
                userDoor = otherDoor;
                System.out.println("Your choice switched to door "
                        + userDoor);
            }

            System.out.println("The prize is behind door number: "
                    + prizeDoor);

            // check if user won or lost
            if (userDoor == prizeDoor) {
                System.out.println("Congratulations! You won the prize!");
            } else {
                System.out.println("Sorry. You lost the game.");
            }
            scan.close();
        }
    }}
