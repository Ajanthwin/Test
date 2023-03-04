package Android.test;


import org.testng.annotations.Test;

public class learn {

	@Test
	public void test()
	{
		
//			int i=0;
//			String s = "$120.010";
//			System.out.println(s.split(".")[1]);
//			String a[] = s.split("$");
//			i = Integer.parseInt(a[1]) + i;
//			System.out.println(i);
			
			 String str = "120.010";
		       String  a = str.split("@")[0];
		  
		                System.out.println(a);
	}
}
