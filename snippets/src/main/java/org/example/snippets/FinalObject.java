package org.example.snippets;

public class FinalObject {}
class Person {
    static String name;
    void setName(String q) {   name = q; }
}
class Child extends Person {
    static String name;
    void setName(String w) { name = w; }
    public static void main(String[] p) {
        final Child child = new Child();
        final Person person = child;
        child.name = "Elysia";
        person.name = "Sophia";
        child.setName("Webby");
        person.setName("Olivia");
        System.out.println(child.name + " " + person.name);
    }
}