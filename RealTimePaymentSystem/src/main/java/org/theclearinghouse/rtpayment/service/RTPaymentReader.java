package org.theclearinghouse.rtpayment.service;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.theclearinghouse.rtpayment.common.Constants;
import org.theclearinghouse.rtpayment.model.RTPaymentBank;

public class RTPaymentReader {
	
	public static Set<RTPaymentBank> readFile(String filePath) throws Exception {
		// parsing a CSV file into Scanner class constructor
		Scanner sc = new Scanner(new File(filePath));
		sc.useDelimiter(","); // sets the delimiter pattern
		Set<RTPaymentBank> banks = new HashSet<>();
		boolean head = true;
		while (sc.hasNextLine()) // returns a boolean value
		{
			String[] dataPts = sc.nextLine().toString().split(",");
			if(head) {
				head=false;
				continue;
			}
			banks.add(new RTPaymentBank(Integer.parseInt(dataPts[Constants.ID]), dataPts[Constants.BANK_NAME],
			dataPts[Constants.TYPE], dataPts[Constants.STATE], dataPts[Constants.CITY],
			Integer.parseInt(dataPts[Constants.ZIPCODE])));
		}
		sc.close(); // closes the scanner
		return banks;
	}

}
