package com.wangzhou.datastructure.comparator;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/30
 * Time:9:40
 **/
public class TestMyComparator<T> {
    private MyComparator<T> comparator;
    private T[] data;

    public TestMyComparator(MyComparator<T> comparator) {
        this.comparator = comparator;
    }

    public void testMyComparator(T[] nums) {
        data = (T[]) new Object[nums.length];
        for (int i = 0; i < nums.length; i++) {
            data[i] = comparator.compare(nums[i], nums[i]);
        }
        for (T i:data ){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1, 2, 3, 4, 5, 6};
        TestMyComparator<Integer> myComparator = new TestMyComparator<>(
                (a, b) -> a + b
        );
        myComparator.testMyComparator(nums);


    }
}
