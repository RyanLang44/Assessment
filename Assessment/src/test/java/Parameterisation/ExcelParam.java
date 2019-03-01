package Parameterisation;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ExcelParam {
	
	@Parameters
	public static Collection<Object[]> data(){
		Object[][] ob = new Object[2][3];
		ob[0][0] =1;
		ob[0][1] =2;
		ob[0][2] =3;
		ob[1][0] =6;
		ob[1][1] =7;
		ob[1][2] =8;
		return Arrays.asList(ob);
	}
	

}
