public class Main {
    public static void main(String[] args) {
//            longestPalindrome(String s) {

        String s = "aacabdkacaa";
        System.out.print("input: " + s + "\n\n");

        // copy below to LeetCode

        // initially at first letter
        int center = 0;
        boolean centerAtLetter = true;
        int palLen = 0;

        // necessary check n-2 letter, n-1 gap positions
        // for simplicity, check n letter, n-1 gap positions
        for (int i = 0; i <= s.length()*2-1; i ++) {
            int tCenter = i / 2;

            // if even i, odd Palindrome, center at letter, center at i/2
            if (i % 2 == 0) {
                // System.out.print("\ni: " + i + " , tCenter: " + tCenter + ", at letter\n");
                // System.out.print("tCenter: " + tCenter + ", s.length()-tCenter: " + (s.length()-tCenter) + "\n");

                // j is Palindrome length, radius is j/2 (no center)
                for (int j = 1; j/2 <= Math.min(tCenter, s.length() - tCenter -1); j+=2) {
                    // System.out.print("i: " + i + ", j: " + j
                    //         + ", start: " + s.charAt(getStartPoint(i, j))
                    //         + ", end: " + s.charAt(getEndPoint(i, j)) + "\n");

                    if (s.charAt(getStartPoint(i, j)) == s.charAt(getEndPoint(i, j))) {
                        if (j > palLen) {
                            // System.out.print("update odd length Palindrome\n");
                            center = tCenter;
                            centerAtLetter = true;
                            palLen = j;
                        }
                    }
                    else {
                        break;
                    }
                }
            }
            // if odd i, even Palindrome, center at gap, center at i/2 + 0.5
            else {
                // System.out.print("\ni: " + i + " , tCenter: " + tCenter + ", at gap\n");
                // System.out.print("tCenter: " + tCenter + ", s.length()-tCenter: " + (s.length()-tCenter) + "\n");

                // j is Palindrome length, radius is j/2
                for (int j = 2; j/2 < Math.min(tCenter +2, s.length() - tCenter); j+=2) {
                    // System.out.print("i: " + i + ", j: " + j
                    //         + ", start: " + getStartPoint(i, j) + " " + s.charAt(getStartPoint(i, j))
                    //         + ", end: " + getEndPoint(i, j) + " " +  s.charAt(getEndPoint(i, j)) + "\n");

                    if (s.charAt(getStartPoint(i, j)) == s.charAt(getEndPoint(i, j))) {
                        if (j > palLen) {
                            // System.out.print("update even length Palindrome\n");
                            center = tCenter;
                            centerAtLetter = false;
                            palLen = j;
                        }
                    }
                    else {
                        break;
                    }
                }
            }
        }

        // copy above to LeetCode

        System.out.print(s.substring(getStartPoint(center, centerAtLetter, palLen),
                getEndPoint(center, centerAtLetter, palLen)));
//        return s.substring(getStartPoint(center, centerAtLetter, palLen),
//                getEndPoint(center, centerAtLetter, palLen));

    }

    // Method to calculate the start point
    public static int getStartPoint(int center, boolean centerAtLetter, int palLen) {
        if (centerAtLetter) {
            // odd Palindrome, aba
            return center - palLen / 2;
        } else {
            // even Palindrome, abba
            return center - palLen / 2 + 1;
        }
    }

    // Method to calculate the end point
    public static int getEndPoint(int center, boolean centerAtLetter, int palLen) {
        if (centerAtLetter) {
            // odd Palindrome, aba
            return center + palLen / 2 + 1;
        } else {
            // even Palindrome, abba
            return center + palLen / 2 + 1;
        }
    }

    // Method to calculate the start point
    public static int getStartPoint(int i, int j) {
        int tCenter = i / 2;
        if (i % 2 == 0) {
            // odd Palindrome, aba
            return tCenter - j / 2;
        } else {
            // even Palindrome, abba
            return tCenter - j / 2 + 1;
        }
    }

    // Method to calculate the end point
    public static int getEndPoint(int i, int j) {
        int tCenter = i / 2;
        if (i % 2 == 0) {
            // odd Palindrome, aba
            return tCenter + j / 2;
        } else {
            // even Palindrome, abba
            return tCenter + j / 2;
        }
    }
}