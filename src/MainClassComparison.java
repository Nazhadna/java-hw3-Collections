import geometry.Circle;

import java.util.*;
import java.util.stream.LongStream;

public class MainClassComparison {
    public static void main(String[] args) {

        HashMap<Integer, Circle> hashMap = new HashMap<>();
        LinkedHashMap<Integer, Circle> linkedHashMap = new LinkedHashMap<>();
        TreeMap<Integer, Circle> treeMap = new TreeMap<>();

        int count =100;
        long startTime;
        long HashMapTime[] = new long[count];
        long LinkedHashMapTime[] = new long[count];
        long TreeMapTime[] = new long[count];
        int indexes[] = new int[count];
        int index;


        for (int i=0; i<10000; i++)
        {
            hashMap.put(i, new Circle(i));
            linkedHashMap.put(i, new Circle(i));
            treeMap.put(i, new Circle(i));
        }

        for (int i=0; i<count; i++)
        {
            indexes[i]= (int) (Math.random() * hashMap.size());
            //index= (int) (Math.random() * 10000);

            startTime = System.nanoTime();
            hashMap.get(indexes[i]);
            //hashMap.contains(indexes[i]);
            HashMapTime[i] = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            linkedHashMap.get(indexes[i]);
            //linkedHashMap.contains(indexes[i]);
            LinkedHashMapTime[i] = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            treeMap.get(indexes[i]);
            //treeMap.contains(indexes[i]);
            TreeMapTime[i] = System.nanoTime() - startTime;
        }

        for (int i=0; i<count; i++)
            System.out.print(HashMapTime[i] +", ");

        System.out.println();
        for (int i=0; i<count; i++)
            System.out.print(LinkedHashMapTime[i] + ", ");

        System.out.println();
        for (int i=0; i<count; i++)
            System.out.print(TreeMapTime[i] + ", ");

        System.out.println();
        for (int i=0; i<count; i++)
            System.out.print(indexes[i] + ", ");


        System.out.println();
        System.out.println(LongStream.of(HashMapTime).average() + " - среднее значение HashMap");
        System.out.println(LongStream.of(LinkedHashMapTime).average() + " - среднее значение LinkedHashMap");
        System.out.println(LongStream.of(TreeMapTime).average()+ " - среднее значение TreeMap");

        System.out.println(" - среднее значение HashMap");
        System.out.println(" - среднее значение LinkedHashMap");
        System.out.println(" - среднее значение TreeMap");
    }
}
