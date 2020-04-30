package pro.devlinduldulao;

public class Main {

    public static void main(String[] args) {
        HashTable table = new HashTable();
        table.put(6, "A");
        table.put(8, "B");
        table.put(11, "C");
        table.put(6, "A+");
        try {
            table.remove(60);
        } catch (Exception e) {
            System.out.println("cannot delete " + e.getMessage());
        }
        System.out.println(table.get(6));
    }
}