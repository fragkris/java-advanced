package IteratorsAndComparators.ComparingObjects;

public class Person implements Comparable<Person>{
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTown() {
        return town;
    }

    @Override
    public int compareTo(Person person) {
        int result = this.name.compareTo(person.name);
        if (result==0){
            result= Integer.compare(this.age, person.age);
        }
        if (result==0){
            result = this.town.compareTo(person.town);
        }
        return result;
    }
}
