import java.util.Arrays;

public class P2 {
    public static int find(int[] arr, String lyrics) {
        int n = arr.length;
        int noOfOuts = 0;

        int currStudentInd = 0;
        int currLyricInd = 0;

        while (noOfOuts < n) {
            currStudentInd = currStudentInd % n;
            currLyricInd = currLyricInd % lyrics.length();
            if (lyrics.charAt(currLyricInd) == 'b') {
                arr[currStudentInd] = -1;
                currStudentInd++;
                noOfOuts++;
                if (noOfOuts == n) {
                    System.out.println(Arrays.toString(arr));
                    for (int i = 0; i < n; i++) {
                        if (arr[i] != -1)
                            return arr[i];
                    }
                }
            } else {
                int c = currStudentInd + 1;
                while (c == -1) {
                    c++;
                }
                currStudentInd = c;
            }
            currLyricInd++;
        }

        return 0;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr = new int[n];
        for (int i = 1; i <= 5; i++)
            arr[i - 1] = i;
        String lyrics = "abbaabb";
        System.out.println(find(arr, lyrics));
    }
}