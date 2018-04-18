package edu.ap.spring;

import java.awt.Point;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

@Component
public class Exam {
	
	// Maak gebruik van lambdas en streams om een array met alle
	// priemgetallen terug te geven
	// 2 punten
	public int[] getPrimes(int[] numbers) {
		int[] primes = new int[] {0, 0, 0, 0};
		try {
			int j = 0;
			for(int i = 0; i < numbers.length; i ++) {
				int number = numbers[i];
				Boolean isPrime = IntStream.rangeClosed(2, number/2).noneMatch(p -> number%p == 0);
				if (isPrime) {
					primes[j] = number;
					j++;
				}
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return  primes;


	}
	
	// Maak gebruik van lambdas en streams alle lowercase characters
	// te tellen in de gegeven string
	// 1 punt
	public int countLowercaseCharacters(String string) {
        String[] stringArr = string
				.replace(" ", "")
				.replace("?", "")
				.split("");
        List<String> lowerCaseList = new ArrayList<>();
        try {
        	lowerCaseList = Arrays.stream(stringArr)
					.filter(p -> p == p.toLowerCase())
					.peek(System.out::println)
					.collect(Collectors.toList());
		}
		catch (Exception e) {
        	e.printStackTrace();
		}
		return lowerCaseList.size();
	}
	
	// Maak gebruik van lambdas en streams om de som van alle
	// x-coordinaten uit de lijst van points te berekenen
	// 1 punt
	public int sumOfX(List<Point> points) {
		List<Integer> xList = new ArrayList<>();
		xList = points
				.stream()
				.map(p -> p.x)
				.collect(Collectors.toList());

		int sum = 0;
		for (int i = 0; i < xList.size(); i++) {
			sum += xList.get(i);
		}

		return sum;

	}
	
	// Maak gebruik van lambdas en streams om een comma-separated
	// string te maken die alle x-coordinaten bevat die groter of gelijk 
	// zijn aan twee
	// 2 punten
	public String getXOverTwo(List<Point> points) {
		List<Integer> xList = new ArrayList<>();
		xList = points
				.stream()
				.filter(p -> p.x >= 2)
				.map(p -> p.x)
				.collect(Collectors.toList());

		String string = "";
		for (int i = 0; i < xList.size(); i++) {
			string += xList.get(i).toString();
			if (i < (xList.size() - 1)) {
				string += ",";
			}
		}
		System.out.println(string);
		return string;
	}
}
