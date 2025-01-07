
public class CommonCharacters {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "cbd";
        String commonChars = "";
        for (char c : str2.toCharArray()) {
            if (str1.contains(String.valueOf(c))) {
                commonChars = commonChars + c;
            }
        }
        System.out.println(commonChars);
    }
}
