package com.voterapp.main;

import java.util.Scanner;

import com.voterapp.exception.NotEligibileException;
import com.voterapp.service.ElectionBooth;

public class Voter {
	
	public static void main(String[] args) {
		ElectionBooth booth = new ElectionBooth();
		Scanner scan = new Scanner(System.in);
		int age,voterId;
		String locality;
		
		System.out.println("Enter age :");
		age = scan.nextInt();
		System.out.println("Enter locality :");
		locality = scan.next();
		System.out.println("Enter voterId :");
		voterId = scan.nextInt();
		
			try {
				if(booth.checkEligibility(age,locality,voterId))
					System.out.println("Voter is valid!!!");
			} catch (NotEligibileException exception) {
				exception.printStackTrace();
			}

	}
	
}
