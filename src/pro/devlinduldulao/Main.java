package pro.devlinduldulao;

public class Main {

    public static void main(String[] args) {
        Array array = new Array(5);
        array.insert(10);
        array.insert(20);
        array.insert(30);
        array.removeAt(0);
        array.print();
    }
}