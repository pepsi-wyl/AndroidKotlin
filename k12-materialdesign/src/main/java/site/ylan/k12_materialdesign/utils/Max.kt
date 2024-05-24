package site.ylan.k12_materialdesign.utils

class Max {
    companion object {
        fun <T : Comparable<T>> max(vararg nums: T): T {
            if (nums.isEmpty()) throw RuntimeException("Params can not be empty.")
            var maxNum = nums[0]
            for (num in nums) {
                if (num > maxNum) {
                    maxNum = num
                }
            }
            return maxNum
        }
    }
}