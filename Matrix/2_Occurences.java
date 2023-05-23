import java.util.*;

public class frequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : a) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int largestElement = Integer.MIN_VALUE;
        int highestFrequency = Integer.MIN_VALUE;
        int secondHighestFrequency = Integer.MIN_VALUE;
        int secondHighestElement = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> freq : map.entrySet()) {
            int element = freq.getKey();
            int frequency = freq.getValue();

            if (frequency > highestFrequency) {
                secondHighestFrequency = highestFrequency;
                secondHighestElement = largestElement;
                highestFrequency = frequency;
                largestElement = element;
            } else if (frequency > secondHighestFrequency && frequency < highestFrequency) {
                secondHighestElement = element;
                secondHighestFrequency = frequency;
            }
        }
        System.out.println("largestElement: " + largestElement);
        System.out.println("highestFrequency: " + highestFrequency);
        System.out.println("2ndElement: " + secondHighestElement);
        System.out.println("2ndhighestFrequency: " + secondHighestFrequency);
    }

}
