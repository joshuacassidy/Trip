import java.util.*;
public class Main {
    

    public static void main(String[] args){
        LinkedList <String> placesToVisit = new LinkedList <String>();
        addInOrder(placesToVisit,"Dublin");
        addInOrder(placesToVisit,"Wexford");
        addInOrder(placesToVisit,"Kerry");
        addInOrder(placesToVisit,"Belfast");
        addInOrder(placesToVisit,"Cork");
        addInOrder(placesToVisit,"Galway");
        addInOrder(placesToVisit,"Meath");
        addInOrder(placesToVisit,"Mayo");
        printList(placesToVisit);
        visit(placesToVisit);


    }
    private static void printList(LinkedList<String> linkedList){
         for(String i : linkedList){
             System.out.println(i);
         }
    }


    private static boolean addInOrder(LinkedList<String> linkedList,String newCity){
        ListIterator <String> i = linkedList.listIterator();
        while(i.hasNext()){
            int comparison = i.next().compareTo(newCity);
            if(comparison == 0){
                System.out.println(newCity + " is already included as a destination");
                return false;
            }
            else if(comparison > 0){
                i.previous();
                i.add(newCity);
                return true;

            }
            else{
                
            }
            }
            
            i.add(newCity);
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
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }
        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action){
                case 0:
                    System.out.println("Holiday over");
                    quit = true;
                    break;
                case 1:
                    if(!goingForward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now visiting " + listIterator.next());
                    }
                    else{
                        System.out.println("Reached the end of the list");
                        goingForward = false;
                    }
                    printMenu();
                    break;
                case 2:
                    if(goingForward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        goingForward =false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now visiting " + listIterator.previous());
                    }
                    else{
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

    private static void printMenu(){
        System.out.println("Available actions: \npress: ");
        System.out.println(" 0 - to quit \n 1 - go to next city \n 2 - go to previous city \n 3 - print menu options \n 4 - print full list of cities");
    }

}
