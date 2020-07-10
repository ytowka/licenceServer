package com.ytowka.LCS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

@SpringBootApplication
public class LicenceCheckerServerApplication {
	public static ArrayList<String> availableLicences;
	public static HashMap<String,String> licenses;
	public static String console = "<h>--console--</h> \n";

	public static void main(String[] args) {
		SpringApplication.run(LicenceCheckerServerApplication.class, args);
		availableLicences = new ArrayList<>();
		licenses = new HashMap<>();

		//new Thread(() -> {
		//	Scanner in = new Scanner(System.in);
		//	while (true){
		//		availableLicences.add(in.nextLine());
		//		System.out.println("\n avaible Licences: "+availableLicences.toString()+"\n activated licences: "+licenses.toString());
		//	}
		//}).start();
	}
}
