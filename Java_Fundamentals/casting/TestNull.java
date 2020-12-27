// null values: Primitive data types can only hold data. However, Object types are pointers to where the data is stored. This means that this pointer can point to nothing (null), while primitive types cannot.


public class TestNull {
    public static void main(String[] args) {
        Integer a = 10;
        int b = 10;
        a = null;
        b = null;
    }
}