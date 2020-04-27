package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.ImmutableMap;

class Person implements Comparable<Person> {
    public String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Person o) {
        return o.name.compareTo(this.name);
    }
}

public class ForEach {

    public static void main(String [] args) {
        ArrayList<Person> list = new ArrayList<>();
        list.addAll(List.of(new Person("A"), new Person("B")));
        list.addAll(List.of(new Person("C"), new Person("D")));
        list.forEach(System.out::println);
        System.out.println("-----------------");
        ImmutableMap<Person, Person> map = ImmutableMap.of(list.get(0), list.get(1), list.get(2), list.get(3));
        map.forEach((k,v) -> System.out.println(k + "=>" + v));
        System.out.println("-----------------");
        Collections.sort(list);
        list.forEach(System.out::println);
        System.out.println("-----------------");
        Collections.sort(list, (Person a, Person b) -> a.name.compareTo(b.name));
        list.forEach(System.out::println);
    }
}