public class StringManipulator{
    String output="";
    public String trimAndConcat (String str, String str1){
        String a = str.trim();
        String b = str1.trim();
        String concat = a.concat(b);
        return concat;
    }
    public Integer getIndexOrNull(String str, char let){
        char letter = let;
        Integer a = str.indexOf(letter);
        if(a== -1){
            a= null;
        }
        return a;
    }
    public Integer getIndexOrNull(String str, String str1){
        Integer a = str.indexOf(str1);
        if(a== -1){
            a= null;
        }
        return a;
    }
    public String concatSubstring(String str, Integer num, Integer num1, String str1) {
        String letter = str.substring(num);
        return letter;
    }
}