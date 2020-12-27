// public class TestSum {
//     public static void main(String[] args) {
//         long start = System.currentTimeMillis();
//         Integer sum = 0;
//         for (int i = 0; i < Integer.MAX_VALUE; i++) {
//             sum += i;
//         }
//         System.out.println("Sum: " + sum);
//         long end = System.currentTimeMillis();
//         double total = (double) (end - start) / 1000;
//         System.out.println("Time of execution: " + total + " seconds");
//     }
// }

// Above takes and sets <sum> to class Integer. So everytime we add <i> in the for-loop we create new instance of Integer (This takes a lot longer to calculate)
// A more efficient way is to use primitive type and set <sum> to int (below)
public class TestSum {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println("Sum: " + sum);
        long end = System.currentTimeMillis();
        double total = (double) (end - start) / 1000;
        System.out.println("Time of execution: " + total + " seconds");
    }
}