package java8;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableList;

public class LambdaConstructorReference {
    static class Person {
        public String name;

        Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "{ " + this.name + " }";
        }
    }

    public static ArrayList < Person > extractNamesIntoAList(ArrayList < Person > l, Function < String, Person > ctor) {
        ArrayList < Person > list = new ArrayList < > ();
        l.forEach(p-> list.add(ctor.apply(p.name + ":(")));
        return list;
    }

    public static void main(String[] args) {
        ImmutableList < Person > list = ImmutableList.of(new Person("A"), new Person("B"), new Person("C"));

        ArrayList < Person > list2 = new ArrayList < > (
            list.stream().map((person) -> person.name + ":)").map(Person::new).collect(Collectors.toList()));
        list2.forEach(System.out::println);

        ArrayList < Person > list3 = extractNamesIntoAList(list2, Person::new);
        list3.forEach(System.out::println);

    }
}