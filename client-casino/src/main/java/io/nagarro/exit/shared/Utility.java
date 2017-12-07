package io.nagarro.exit.shared;

import java.util.Map;

public class Utility {

	public static int[] getBetAmount(Map<String, String> map) {

		try {
			int[] betAmount = new int[8];
			int[] idx = { 0 };
			map.forEach((key, value) -> {
				betAmount[idx[0]++] = !value.equals("") ? Integer.parseInt(value) : 0;
			});

			return betAmount;
			
		} catch (Exception e) {
			throw e;
		}

	}

}
