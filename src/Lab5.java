public class Lab5 {
    public static void main(String[] args) {
        CustomSet customSet = new CustomSet();
        customSet.add(5.78);
        customSet.add(23.4);
        customSet.print();

        CustomSet customSet2 = new CustomSet(customSet);
        customSet2.add(-2.56);
        customSet2.print();

        customSet.unite(customSet2);
        customSet.print();

        System.out.println("Set contains 5.78 " + customSet.contains(5.78));
        System.out.println("Set contains 5.7 " + customSet.contains(5.7));
    }
}
