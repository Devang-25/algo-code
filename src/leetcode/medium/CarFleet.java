package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;

public class CarFleet {
    class Car {
        int pos;
        int speed;

        Car(int pos, int speed) {
            this.pos = pos;
            this.speed = speed;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 0) {
            return 0;
        }

        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            cars.add(new Car(position[i], speed[i]));
        }

        Collections.sort(cars, (a, b) -> -Integer.compare(a.pos, b.pos));
        int index = 1, numfleets = 0;
        double hopFirst = (target - cars.get(0).pos) / (double) cars.get(0).speed;
        while (index < position.length) {
            double hop = (target - cars.get(index).pos) / (double) cars.get(index).speed;
            if (hop > hopFirst) {
                numfleets++;
                hopFirst = hop;
            }
            index++;
        }
        return numfleets + 1;
    }

    public static void main(String[] args) {
        CarFleet cf = new CarFleet();
        System.out.println(cf.carFleet(12, new int[]{5, 4, 3, 2, 1}, new int[]{5, 4, 3, 2, 1}));
        System.out.println(cf.carFleet(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3}));
        System.out.println(cf.carFleet(12, new int[]{5, 4, 3, 2, 1}, new int[]{5, 4, 3, 2, 1}));
        System.out.println(cf.carFleet(12, new int[]{5, 4, 3, 2, 1}, new int[]{1, 10, 20, 30, 40}));
    }


}
