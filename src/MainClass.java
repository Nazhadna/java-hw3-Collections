import geometry.Circle;
import mylist.MyLinkedList;

public class MainClass {
    public static void main(String[] args) {

        MyLinkedList<Circle> myListOfCircles = new MyLinkedList<>();
        myListOfCircles.add(new Circle());
        myListOfCircles.add(new Circle());
        Circle circle = new Circle(4, "white");
        myListOfCircles.add(circle);
        myListOfCircles.add(new Circle(87, "green"));
        myListOfCircles.add(1, new Circle(52, "blue"));
        myListOfCircles.set(2, new Circle(6, "black"));

        System.out.println(myListOfCircles);
        System.out.println("Size: " + myListOfCircles.size());
        System.out.println("Index of white circle: " + myListOfCircles.indexOf(circle));
        System.out.println("Third circle: " + myListOfCircles.get(3));

        myListOfCircles.remove(3);

        Circle ar[] = myListOfCircles.toArray();
        System.out.println("Array: ");
        for (Circle c: ar)
            System.out.println(c);

        myListOfCircles.clear();
        System.out.println(myListOfCircles);
    }
}
