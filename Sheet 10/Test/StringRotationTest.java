public class StringRotationTest {
    public static void main(String[] args) {
        StringRotation stringRotation = new StringRotation();
       
        System.out.println(stringRotation.containsString("ABCD", "ABC"));
        System.out.println(stringRotation.containsString("TestString", "sts"));
        System.out.println(stringRotation.containsString("ABCDEF", "EFA"));
        System.out.println(stringRotation.containsString("ABCDEF", "DCE"));
    }
}
