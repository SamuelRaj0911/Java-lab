public class TopKMostFrequentNumbersWithoutBuiltInMethods {

    private static int[] numbers;

    public static void findTopKMostFrequentNumbers(int K) {
        int[] frequencyCounts = new int[numbers.length];
        int maxFrequency = 0;

        for (int num : numbers) {
            frequencyCounts[num]++;
            maxFrequency = Math.max(maxFrequency, frequencyCounts[num]);
        }

        int[] topKIndices = new int[K];
        for (int i = 0; i < K; i++) {
            int maxIndex = 0;
            for (int j = 0; j < numbers.length; j++) {
                if (frequencyCounts[j] == maxFrequency && !contains(topKIndices, j)) {
                    maxIndex = j;
                    break;
                }
            }

            topKIndices[i] = maxIndex;
            frequencyCounts[maxIndex] = 0;
        }

        for (int i = K - 1; i >= 0; i--) {
            System.out.println(numbers[topKIndices[i]] + " - " + maxFrequency);
            maxFrequency--;
        }
    }

    private static boolean contains(int[] array, int value) {
        for (int element : array) {
            if (element == value) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 4, 5, 2, 6, 1};
        int K = 2;

        numbers = nums;
        findTopKMostFrequentNumbers(K);
    }
}
