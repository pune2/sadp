//package remoteControl;

import java.util.Scanner;

//Command interface
interface Command {
 void execute();
}

//Concrete command: Turn on the TV
class TvOnCommand implements Command {
 private Tv tv;

 public TvOnCommand(Tv tv) {
     this.tv = tv;
 }

 @Override
 public void execute() {
     tv.turnOn();
 }
}

//Concrete command: Turn off the TV
class TvOffCommand implements Command {
 private Tv tv;

 public TvOffCommand(Tv tv) {
     this.tv = tv;
 }

 @Override
 public void execute() {
     tv.turnOff();
 }
}



//Receiver: The TV
class Tv {

 private boolean isOn = false;

 public void turnOn() {
     isOn = true;
     System.out.println("TV is ON");
 }

 public void turnOff() {
     isOn = false;
     System.out.println("TV is OFF");
 }


}

//Invoker: Controls the commands
class RemoteControl {
 private Command command;

 public void setCommand(Command command) {
     this.command = command;
 }

 public void pressButton() {
     command.execute();
 }
}

public class TvRemoteControlDemo {
 public static void main(String[] args) {
     // Create the TV and commands
     Tv livingRoomTv = new Tv();
     TvOnCommand tvOn = new TvOnCommand(livingRoomTv);
     TvOffCommand tvOff = new TvOffCommand(livingRoomTv);

     // Create the remote control
     RemoteControl remote = new RemoteControl();

     // Menu-driven program
     Scanner scanner = new Scanner(System.in);
     int choice = 0; // Initialize choice with a default value

     do {
         System.out.println("\nTV Remote Control Menu:");
         System.out.println("1. Turn On TV");
         System.out.println("2. Turn Off TV");

         System.out.println("3. Exit");
         System.out.print("Enter your choice: ");

         if (scanner.hasNextInt()) {
             choice = scanner.nextInt();
             switch (choice) {
                 case 1:
                     remote.setCommand(tvOn);
                     remote.pressButton();
                     break;
                 case 2:
                     remote.setCommand(tvOff);
                     remote.pressButton();
                     break;

                 case 3:
                     System.out.println("Exiting the TV remote control.");
                     break;
                 default:
                     System.out.println("Invalid choice. Please try again.");
             }
         } else {
             System.out.println("Invalid input. Please enter a number.");
             scanner.next(); // Consume invalid input
         }
     } while (choice != 3);

     scanner.close();
 }
}
