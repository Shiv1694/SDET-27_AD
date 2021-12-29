package practise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data_Provder_2 {

	@Test(dataProvider="getData")
	public void readDataFromDataProviderTest(String name,int qty,String company)
	{
		System.out.println("mobile name--->"+name+"quantity---->"+qty+"Company---->"+company);
	}

	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr=new Object[5][3];
		objArr[0][0]="Iphone";
		objArr[0][1]=10;
		objArr[0][2]="Apple";
		
		objArr[1][0]="Samsung s2";
		objArr[1][1]=20;
		objArr[1][2]="Samsung";
		
		objArr[2][0]="Vivo S1";
		objArr[2][1]=30;
		objArr[2][2]="vivo";
		
		objArr[3][0]="redmi";
		objArr[3][1]=30;
		objArr[3][2]="Xiomi";
		
		objArr[4][0]="oppp a3";
		objArr[4][1]=30;
		objArr[4][2]="Oppo";
		return objArr;
	}
}
