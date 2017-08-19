import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class Main {
    

    public static void main(String[] args) throws IOException{
        System.out.print("\033[H\033[2J");
        LinkedList <String> placesToVisit = new LinkedList();
        try(BufferedReader placesFile = new BufferedReader(new FileReader("src/Places.txt"))) {
            String placesData = placesFile.readLine();
            while (placesData != null) {
                addInOrder(placesToVisit,placesData);
                placesData = placesFile.readLine();
            }
        }
        visit(placesToVisit);
    }
    private static void printList(LinkedList<String> linkedList){
         for(String i : linkedList){
             System.out.println(i);
         }
    }


    private static boolean addInOrder(LinkedList<String> linkedList,String newCity){
        for(String i : linkedList){
            if(i.compareTo(newCity) == 0){
                System.out.printf("%s is already included as a destination\n",newCity);
                return false;
            }
        }
        linkedList.add(newCity);
        Collections.sort(linkedList);
        return true;
    }
    private static void visit(LinkedList cities){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator <String> listIterator = cities.listIterator();

        if(cities.isEmpty()){
            System.out.println("No cities in the itenerary");
            return;
        }
        else{
            System.out.printf("Now visiting %s\n", listIterator.next());
            printMenu();
        }
        try{
        while(!quit){
                int action = scanner.nextInt();
                scanner.nextLine();
            switch(action) {
                case 0:
                    System.out.println("Holiday over");
                    quit = true;
                    break;
                case 1:
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.printf("Now visiting %s\n", listIterator.next());
                    } else {
                        System.out.println("Reached the end of the list");
                        goingForward = false;
                    }
                    printMenu();
                    break;
                case 2:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.printf("Now visiting %s\n", listIterator.previous());
                    } else {
                        System.out.println("We are at the start of the list");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
                case 4:
                    printList(cities);
                }
            }
        }
        catch(InputMismatchException e){
            System.out.println("Invalid input");
        }
    }

    private static void printMenu(){
        System.out.println("Available actions: \npress: ");
        String [] options = {"to quit","go to next city","go to previous city","print menu options","print list of cities"};
        for(String i: options){
            System.out.printf("%d - %s\n",Arrays.asList(options).indexOf(i),i);
        }
    }

}
