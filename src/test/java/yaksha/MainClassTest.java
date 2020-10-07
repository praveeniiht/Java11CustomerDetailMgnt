package yaksha;

import static yaksha.TestUtils.businessTestFile;
import static yaksha.TestUtils.currentTest;
import static yaksha.TestUtils.yakshaAssert;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class MainClassTest {

	@Test
	public void testExceptionConditon() throws Exception {

		TestUtils.yakshaAssert(TestUtils.currentTest(), true, TestUtils.boundaryTestFile);
	}

	@Test
	public void testBoundaryCondition() throws Exception {

		TestUtils.yakshaAssert(TestUtils.currentTest(), true, TestUtils.exceptionTestFile);
	}

	@Test
	void testConvertCsvToMap() throws Exception {
		// Test will pass
		List<String> csvList = new ArrayList<String>();/////
		List<String> resulList1 = new ArrayList<String>();
		List<String> resulList2 = new ArrayList<String>();
		csvList.add(
				"1,John Smith,M,johnsmith@a.com,+89-7485-8578974885,15/01/2016 10:30:00,112th St,Utica,New York,USA,13455");
		csvList.add(
				"2,Aekerman,M,aekerman@a.com,+99-7489-8857945569,14/02/2016 16:30:00,Avenue,Austin,Texas,USA,88596");
		csvList.add(
				"3,Madeleine,F,madeleine@a.com,+88-7859-7748599989,25/01/2016 10:00:00,155th St,Plano,Texas,USA,56684");

		resulList2.add("New York=1");
		resulList2.add("Texas=2");
		Map<String, Integer> tm = CustomerDetailManagement.convertCsvToMap(csvList);
		for (Map.Entry<String, Integer> tm2 : tm.entrySet()) {
			resulList1.add(tm2.getKey() + "=" + tm2.getValue());
		}
		yakshaAssert(currentTest(), (resulList1.containsAll(resulList2) ? "true" : "false"), businessTestFile);
	}
}
