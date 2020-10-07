package yaksha;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainClass {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of customer:");
		int n = Integer.parseInt(br.readLine());
		List<String> csvList = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			System.out.println("Enter the customer " + (i + 1) + " details:");
			csvList.add(br.readLine());
		}
		Map<String, Integer> tm = CustomerDetailManagement.convertCsvToMap(csvList);
		// fill code here.
		System.out.printf("%-15s %s\n", "State", "No of customer(s)");
		for (Map.Entry<String, Integer> entry : tm.entrySet()) {

			System.out.printf("%-15s %s\n", entry.getKey(), entry.getValue());
		}
		List<Customer> lt = CustomerDetailManagement.getCustomerListFromMap(tm);
		System.out.format("%-5s %-15s %-5s %-20s %-20s %-15s %-15s %-15s %s\n", "Id", "Name", "Gender", "Email",
				"Created on", "City", "State", "Country", "Zipcode");
		for (Customer c : lt)
			System.out.format("%-5s %-15s %-5s %-20s %-20s %-15s %-15s %-15s %s\n", c.getId(), c.getName(),
					c.getGender(), c.getEmail(), sdf.format(c.getCreatedOn()), c.getAddress().getCity(),
					c.getAddress().getState(), c.getAddress().getCountry(), c.getAddress().getZipCode());
	}
}