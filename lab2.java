import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKMostFrequentNumbers {

    private static int[] numbers;

    public static void findTopKMostFrequentNumbers(int K) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for (int num : numbers) {
            int count = frequencyMap.getOrDefault(num, 0) + 1;
            frequencyMap.put(num, count);

            if (maxHeap.size() < K) {
                maxHeap.add(Map.entry(num, count));
            } else if (count > maxHeap.peek().getValue()) {
                maxHeap.remove();
                maxHeap.add(Map.entry(num, count));
            }
        }

        while (!maxHeap.isEmpty()) {
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        int[] nums = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
        int K = 4;

        numbers = nums;
        findTopKMostFrequentNumbers(K);
    }
}
