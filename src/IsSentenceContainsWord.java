public class IsSentenceContainsWord {
    public static boolean isContain(String input1, String input2) {
        char firstLetter = input2.charAt(0);
        if (input1.length() < input2.length()) {
            return false;
        }

        for (int i = 0; i < input1.length(); i++) {
            if (input1.charAt(i) == firstLetter) {
                for (int j = 0; j < input2.length(); j++) {
                    if (input1.charAt(i) == input2.charAt(j))
                        return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //System.out.println(isContain("you go"," go"));
    }
}
