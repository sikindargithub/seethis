package com.voterapp.service;

import com.voterapp.exception.LocalityNotFoundException;
import com.voterapp.exception.NoVoterIDException;
import com.voterapp.exception.NotEligibileException;
import com.voterapp.exception.UnderAgeException;


public class ElectionBooth {
	
	String localities[] = {"SRnagar","Ammerpet","Dilsuknagar","LBnagar"};
	
	// throws exception if age is below 18
	boolean checkAge(int age) throws UnderAgeException {
		if(age<18)
			return false;
		return true;
	}
	// throws exception if locality is mismatched
	boolean checkLocality(String locality) throws LocalityNotFoundException {
		for (String actualLocality : localities) {
			if(actualLocality.equalsIgnoreCase(locality))
				return true;
		}
		return  false;
	
	}
	// throws exception if voterId in not found
	boolean checkVoterID(int voterId) throws NoVoterIDException  {
		
			if(voterId<9000 && voterId<1000) {
				return false;
			}
		
		return true;
	}
	public boolean checkEligibility(int age,String locality,int voterId) throws NotEligibileException {
		
		if(checkAge(age)) {
			if(checkLocality(locality)) {
				if(checkVoterID(voterId)) {
					return true;
				}
				throw new NoVoterIDException("Voter Id is invalid....");
			}
			throw new LocalityNotFoundException("Sorry,locality is not matched!!!");
		}
		throw new UnderAgeException("Below 18 yrs age pesons are not eligible to vote!!!");
	}
}
