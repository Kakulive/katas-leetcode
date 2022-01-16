package twosum;

import java.util.*;

public class Twosum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> availableNumbers = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!availableNumbers.containsKey(nums[i])) {
                ArrayList<Integer> newList = new ArrayList<>();
                newList.add(i);
                availableNumbers.put(nums[i], newList);
            } else {
                availableNumbers.get(nums[i]).add(i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int searchedNumber = target - nums[i];
            if (availableNumbers.containsKey(searchedNumber) && nums[i] != searchedNumber) {
                return new int[]{i, availableNumbers.get(searchedNumber).get(0)};
            } else if (availableNumbers.containsKey(searchedNumber) && nums[i] == searchedNumber && availableNumbers.get(searchedNumber).size() > 1) {
                int secondIndex = -1;
                if (availableNumbers.get(searchedNumber).get(0) != i) {
                    secondIndex = availableNumbers.get(searchedNumber).get(0);
                } else {
                    secondIndex = availableNumbers.get(searchedNumber).get(1);
                }

                return new int[]{i, secondIndex};
            }
        }

        return new int[]{-1, -1};
    }
}
