package org.theclearinghouse.rtpayment.service;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.theclearinghouse.rtpayment.common.Constants;
import org.theclearinghouse.rtpayment.model.RTPaymentBank;

public class RTPaymentService {
	
	private static Set<RTPaymentBank> bankList = null;

	public static List<RTPaymentBank> fetch(String param, String value) throws Exception{
		if(bankList == null) {
			bankList = RTPaymentReader.readFile(Constants.FEED_PATH);
		}
		List<RTPaymentBank> resultSet = null;
		switch(param) {
			case Constants.SEARCH_BY_ZIPCODE:
				resultSet = fetchByZipcode(value);
				break;
				
			case Constants.SEARCH_BY_TYPE:
				resultSet = fetchByType(value);
			break;
			
			case Constants.SEARCH_BY_STATE:
				resultSet = fetchByState(value);
			break;
			
			case Constants.SEARCH_BY_ID:
				resultSet = fetchById(value);
			break;
			
			case Constants.SEARCH_BY_CITY:
				resultSet = fetchByCity(value);
			break;
			
			case Constants.SEARCH_BY_BANK_NAME:
				resultSet = fetchByBankName(value);
			break;
		}
		return resultSet;
	}
		
	private static List<RTPaymentBank> fetchByZipcode(String value) {
		Predicate<RTPaymentBank> banksInThisZipCode = b -> (b.getZipCode() == Integer.parseInt(value)) ;
		List<RTPaymentBank> resultSet = bankList.stream().filter(banksInThisZipCode).sorted(Comparator.
				comparing(RTPaymentBank::getBankName)).collect(Collectors.toList());
		return resultSet;
	}

	private static List<RTPaymentBank> fetchByType(String value) {
		Predicate<RTPaymentBank> banksOfType = b -> (b.getType() == value) ;
		List<RTPaymentBank> resultSet = bankList.stream().filter(banksOfType).sorted(Comparator.
				comparing(RTPaymentBank::getBankName)).collect(Collectors.toList());
		return resultSet;
	}

	private static List<RTPaymentBank> fetchByBankName(String value) {
		Predicate<RTPaymentBank> banksByName = b -> (b.getBankName() == value) ;
		List<RTPaymentBank> resultSet = bankList.stream().filter(banksByName).sorted(Comparator.
				comparing(RTPaymentBank::getType)).collect(Collectors.toList());
		return resultSet;
	}

	private static List<RTPaymentBank> fetchByCity(String value) {
		Predicate<RTPaymentBank> banksByCity = b -> (b.getCity() == value) ;
		List<RTPaymentBank> resultSet = bankList.stream().filter(banksByCity).sorted(Comparator.
				comparing(RTPaymentBank::getBankName)).collect(Collectors.toList());
		return resultSet;
	}

	private static List<RTPaymentBank> fetchById(String value) {
		Predicate<RTPaymentBank> banksById = b -> (b.getID() == Integer.parseInt(value)) ;
		List<RTPaymentBank> resultSet = bankList.stream().filter(banksById).sorted(Comparator.
				comparing(RTPaymentBank::getBankName)).collect(Collectors.toList());
		return resultSet;
	}

	private static List<RTPaymentBank> fetchByState(String value) {
		Predicate<RTPaymentBank> banksByState = b -> (b.getState() == value) ;
		List<RTPaymentBank> resultSet = bankList.stream().filter(banksByState).sorted(Comparator.
				comparing(RTPaymentBank::getBankName)).collect(Collectors.toList());
		return resultSet;
	}


}
