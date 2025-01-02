// import java.util.*;
// public class slidingWindowMaximum{
//     // deque(doubly ended queue) -> can add and delete data from both sides in constant time (FIFO -> First In First Out)
//     public static void main(String[] args){
//         int[] arr = {1,3,-1,-3,5,3,6,7};
//         int k=3;
//         System.out.println(slidingWindow(arr, k));
//     }
//     public static int[] slidingWindow(int[] arr, int k) {
//         int[] ans = new int[arr.length - k + 1];
//         Deque<Integer> dq = new LinkedList<>();
        
//         for (int i = 0; i < k; i++) {
//             while (!dq.isEmpty() && arr[dq.getLast()] < arr[i]) {
//                 dq.removeLast();
//             }
//             dq.addLast(i);
//         }

//         int j = 0;
//         ans[j++] = arr[dq.getFirst()];
//         for (int i = k; i < arr.length; i++) {
//             // Grow
//             while (!dq.isEmpty() && arr[dq.getLast()] < arr[i]) {
//                 dq.removeLast();
//             }
//             dq.addLast(i);

//             // Shrink
//             if (i - k == dq.getFirst()) {
//                 dq.removeFirst();
//             }

//             // Update the answer
//             ans[j++] = arr[dq.getFirst()];
//         }

//         return ans;
//     }
// }



public static List<Integer> getPossibleDigits(Map<Integer, String> digitPatterns, String segment) {
    List<Integer> possibleDigits = new ArrayList<>();
    for (Map.Entry<Integer, String> entry : digitPatterns.entrySet()) {
        int mismatchCount = 0;
        String pattern = entry.getValue();

        for (int i = 0; i < segment.length(); i++) {
            if (segment.charAt(i) != pattern.charAt(i)) {
                mismatchCount++;
            }
        }

        if (mismatchCount <= 1) {
            possibleDigits.add(entry.getKey());
        }
    }
    return possibleDigits;
}

// Function to generate all combinations of possible numbers
public static List<List<Integer>> getCombinations(List<List<Integer>> digitOptions) {
    List<List<Integer>> allCombinations = new ArrayList<>();
    generateCombinations(digitOptions, 0, new ArrayList<>(), allCombinations);
    return allCombinations;
}

private static void generateCombinations(List<List<Integer>> digitOptions, int index, List<Integer> currentCombination, List<List<Integer>> allCombinations) {
    if (index == digitOptions.size()) {
        allCombinations.add(new ArrayList<>(currentCombination));
        return;
    }
    for (int digit : digitOptions.get(index)) {
        currentCombination.add(digit);
        generateCombinations(digitOptions, index + 1, currentCombination, allCombinations);
        currentCombination.remove(currentCombination.size() - 1);
    }
}

// Main solving function
public static void solve() {
    Scanner sc = new Scanner(System.in);

    // Reading segment patterns for all digits 0-9
    List<String> digitSegments = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
        digitSegments.add(sc.nextLine().strip());
    }

    // Reading input number segments
    List<String> inputSegments = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
        inputSegments.add(sc.nextLine().strip());
    }

    // Mapping each digit (0-9) to its pattern
    Map<Integer, String> digitPatterns = new HashMap<>();
    for (int digit = 0; digit < 10; digit++) {
        StringBuilder pattern = new StringBuilder();
        for (int row = 0; row < 3; row++) {
            pattern.append(digitSegments.get(row).substring(digit * 3, (digit + 1) * 3));
        }
        digitPatterns.put(digit, pattern.toString());
    }

    // Determining possible digits for each input segment
    List<List<Integer>> digitOptions = new ArrayList<>();
    int totalSegments = inputSegments.get(0).length() / 3;
    for (int i = 0; i < totalSegments; i++) {
        StringBuilder segment = new StringBuilder();
        for (int row = 0; row < 3; row++) {
            segment.append(inputSegments.get(row).substring(i * 3, (i + 1) * 3));
        }
        List<Integer> matchingDigits = getPossibleDigits(digitPatterns, segment.toString());
        if (matchingDigits.isEmpty()) {
            System.out.print("Invalid");
            return;
        }
        digitOptions.add(matchingDigits);
    }

    // Calculating the total sum of all valid combinations
    int totalSum = 0;
    for (List<Integer> combination : getCombinations(digitOptions)) {
        StringBuilder number = new StringBuilder();
        for (int digit : combination) {
            number.append(digit);
        }
        totalSum += Integer.parseInt(number.toString());
    }

    System.out.print(totalSum);
}

public static void main(String[] args) {
    solve();
}