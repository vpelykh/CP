import java.util.TreeSet;

public class CustomSet {
    private TreeSet<Double> numbersSet;

    public CustomSet() {
        this.numbersSet = new TreeSet<>();
    }

    public CustomSet(TreeSet<Double> set) {
        this.numbersSet = set;
    }

    public CustomSet(CustomSet other) {
        this.numbersSet = other.numbersSet;
    }

    public void add(Double num) {
        this.numbersSet.add(num);
    }

    public void unite(CustomSet set) {
        this.numbersSet.addAll(set.numbersSet);
    }

    public void print() {
        System.out.print("Set's elements: ");
        for (Double num : this.numbersSet) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public Boolean contains(Double num) {
        return this.numbersSet.contains(num);
    }
}
