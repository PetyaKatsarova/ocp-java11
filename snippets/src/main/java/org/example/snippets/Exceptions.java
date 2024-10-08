package org.example.snippets;

public class Exceptions {
    public static void main(String... xyz) {
        try (MyFileClass a1 = new MyFileClass(1);
             MyFileClass a2 = new MyFileClass(2)) {
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("ex");
        } finally {
            System.out.println("finally");
        }
    }

}
class MyFileClass implements AutoCloseable {
    private final int num;
    public MyFileClass(int num) { this.num = num; }
    public void close() {
        System.out.println("Closing: " + num);
    }
}