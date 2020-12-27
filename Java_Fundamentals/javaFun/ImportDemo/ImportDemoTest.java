public class ImportDemoTest {
    public static void main(String[] args) {
        ImportDemo iD = new ImportDemo();
        // 1-we are instantiating a new 'ImportDemo' object. Now ALL public methods are available to the object
        String currentDate = iD.getCurrentDate();
        // 2-Calling the 'getCurrentDate' method on the object
        System.out.println(currentDate);
        // 3-Printing the 'currentDate' string
    }
}


// NOTE- as long as 'ImportDemo' and 'ImportDemoTest' are in same directory, do not have to explicityly import on into another.  Also can fun 'javac' compiler on 'ImportDemoTest' and will compile both files.