package io.nagarro.exit.shared;

import java.util.Random;

public  class RandomNumerGenrator {

	    public static int findMinRec(int arr[], int i,
                                int sumCalculated,
                                 int sumTotal)
    {
      
        if (i == 0)
            return Math.abs((sumTotal-sumCalculated) -
                                   sumCalculated);
      
      
        return Math.min(findMinRec(arr, i - 1, sumCalculated 
                                   + arr[i-1], sumTotal),
                                 findMinRec(arr, i-1,
                                  sumCalculated, sumTotal));
    }
      
    public static int findMin(int arr[], int n)
    {
        int sumTotal = 0;
        for (int i = 0; i < n; i++)
            sumTotal += arr[i];
      
        return findMinRec(arr, n, 0, sumTotal);
    }

	public static int genrate() {
		Random random = new Random();
		int[] lstRandom = new int[20];
		for(int i = 0; i<20;i++){// genrate 20 number
			lstRandom[i] = genrateVaribleLengthNo(random.nextInt(6),random);
		}
		return findMin(lstRandom, 20)%37;
		
	}

private static int genrateVaribleLengthNo(int nextInt, Random random) {
	
	int num = 0;
	for(int i=0;i<nextInt;i++){
		num += random.nextInt(10);
		num *= 10;
	}
	return num;
	
}
}
