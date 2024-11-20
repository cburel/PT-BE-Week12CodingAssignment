package com.promineotech;

import java.util.Random;

public class TestDemo {
	
	// adds two given positive numbers
	public int addPositive(int a, int b) {
		if (a > 0 && b > 0) {
			return a + b;
		}
		else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}
	
	// multiplies two given positive numbers
	public int multiplyPositive(int a, int b) {
		if (a > 0 && b > 0) {
			return a * b;
		}
		else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}
	
	int randomNumberSquared() {
		int rand = getRandomInt();
		return rand * rand;
	}

	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
}
