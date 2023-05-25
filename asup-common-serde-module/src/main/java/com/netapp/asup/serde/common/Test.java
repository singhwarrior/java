package com.netapp.asup.serde.common;

public class Test {

    public static void main(String[] args) {
        System.out.println(getSecondMax(new int[]{3,5,4,2,13, 11}));
    }

    public static int getSecondMax(int[] arr){
        int max = arr[0];
        int smax = arr[0];

        for(int i = 1; i < arr.length; i++){
            if(max < arr[i]) {
                smax = max;
                max = arr[i];
            } else if(max > arr[i] && smax < arr[i])
                smax = arr[i];

        }
        return smax;
    }
}
