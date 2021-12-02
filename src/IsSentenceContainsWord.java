public class IsSentenceContainsWord {
    public static boolean isContain(String input1, String input2) {
        char firstLetter = input2.charAt(0);
        boolean comparisionStart;

        if (input1.length() < input2.length()) {
            return false;
        } else {
            for (int i = 0; i < input1.length(); i++) {
                if (input1.charAt(i) == firstLetter) {
                    comparisionStart = true;
                    for (int firstInputIndex = i, secondInputIndex = 0; secondInputIndex < input2.length();
                         firstInputIndex++, secondInputIndex++) {
                        if (input1.charAt(firstInputIndex) != input2.charAt(secondInputIndex)) {
                            comparisionStart = false;
                            break;
                        }
                    }
                    return comparisionStart;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isContain("i like melon", "likemelon"));
    }
}
