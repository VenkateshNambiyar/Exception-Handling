package com.bus;

import java.util.*;

public class IncorrectDetailsException extends InputMismatchException {
	
	IncorrectDetailsException(String exceptionName) {
		System.out.println(exceptionName);
	}
}