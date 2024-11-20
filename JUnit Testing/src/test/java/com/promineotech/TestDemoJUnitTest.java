package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

class TestDemoJUnitTest {

	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	// ensures that testDemo.addPositive asserts and throws correctly
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}

	// gets test arguments for testDemo.addPositive
	static Stream<Arguments> argumentsForAddPositive() {

		return Stream.of(arguments(2, 4, 6, false), 
				arguments(1, 2, 3, true), 
				arguments(0, 3, 5, false),
				arguments(-2, 3, 10, false));
	}

	// checks that testDemo.addPositive adds correctly
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(1, 3)).isEqualTo(4);
		assertThat(testDemo.addPositive(10, 10)).isEqualTo(20);
	}

	// ensures that testDemo.multiplyPositive asserts and throws correctly
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForMultiplyPositive")
	void assertThatTwoPositiveNumbersAreMultipliedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.multiplyPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.multiplyPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}

	// gets test arguments for testDemo.multiplyPositive
	static Stream<Arguments> argumentsForMultiplyPositive() {

		return Stream.of(arguments(2, 3, 10, false), 
				arguments(1, 2, 2, true), 
				arguments(0, 3, 5, false),
				arguments(-2, 3, 10, false));
	}
	
	// checks that testDemo.multiplyPositive adds correctly
	@Test
	void assertThatPairsOfPositiveNumbersAreMultipliedCorrectly() {
		assertThat(testDemo.multiplyPositive(1, 3)).isEqualTo(3);
		assertThat(testDemo.multiplyPositive(10, 10)).isEqualTo(100);
	}
	
	// checks that testDemo.randomNumberSquared squares correctly
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}
}
