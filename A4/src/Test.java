public class Test {

    public static void main(String[] args) {
        MapEntry[] entries = new MapEntry[10];
        LinkedList list = new LinkedList();
        for(int i = 0; i < entries.length; i++) {
            entries[i] = new MapEntry();
            System.out.println(entries[i]);
        }
        for(int i = 0; i < entries.length; i++) {
            list.add(entries[i].getKey(), entries[i].getValue());
        }
        System.out.println(list);
        System.out.println(list.get(entries[4].getKey()));
        System.out.println(list);
    }

}
