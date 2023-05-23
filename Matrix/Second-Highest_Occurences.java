import java.util.*;

public class test {
    private static final String Map = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : a) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int largestElement = Integer.MIN_VALUE;
        int highestFrequency = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> frequency : map.entrySet()) {
            int element = frequency.getKey();
            int occurences = frequency.getValue();
            if (occurences > highestFrequency) {
                highestFrequency = occurences;
                largestElement = element;
            }
        }
        System.out.println("largestElement: " + largestElement);
        System.out.println("highestFrequency: " + highestFrequency);
        map.remove(largestElement);
        int secondHighestFrequency = Integer.MIN_VALUE;
        int secondHighestElement = 0;
        for (Map.Entry<Integer, Integer> frequency : map.entrySet()) {
            int element = frequency.getKey();
            int occurences = frequency.getValue();
            if (occurences > secondHighestFrequency) {
                secondHighestFrequency = occurences;
                secondHighestElement = element;
            }
        }
        System.out.println("2ndElement: " + secondHighestElement);
        System.out.println("2ndhighestFrequency: " + secondHighestFrequency);

    }
}
