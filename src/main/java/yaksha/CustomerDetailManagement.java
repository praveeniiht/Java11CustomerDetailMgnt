package yaksha;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CustomerDetailManagement {
	static List<Customer> li = new ArrayList<Customer>();

	public static TreeMap<String, Integer> convertCsvToMap(List<String> csvDetails)
			throws NumberFormatException, ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		for (String s : csvDetails) {
			String det[] = s.split(",");
			li.add(new Customer(Integer.parseInt(det[0]), det[1], det[2].charAt(0), det[3], det[4], sdf.parse(det[5]),
					new Address(det[6], det[7], det[8], det[9], Integer.parseInt(det[10]))));
		}

		TreeMap<String, Integer> hm = new TreeMap<String, Integer>();
		for (Customer c : li) {
			String st = c.getAddress().getState();
			if (hm.containsKey(st)) {
				hm.put(st, hm.get(st) + 1);
			} else
				hm.put(st, 1);
		}
		return hm;
	}

	public static List<Customer> getCustomerListFromMap(Map<String, Integer> customerMap) {
		TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
		for (Map.Entry<String, Integer> entry : customerMap.entrySet()) {
			tm.put(entry.getKey(), entry.getValue());
		}

		ArrayList<Customer> res = new ArrayList<Customer>();

		for (Map.Entry<String, Integer> entry : tm.entrySet()) {
			ArrayList<Customer> ar = new ArrayList<Customer>();
			for (int i = 0; i < li.size(); i++) {
				if (li.get(i).getAddress().getState().equalsIgnoreCase(entry.getKey())) {
					ar.add(li.get(i));
				}
			}

			CustomerComparator cc = new CustomerComparator();
			Collections.sort(ar, cc);
			res.addAll(ar);
		}
		return res;
	}
}
