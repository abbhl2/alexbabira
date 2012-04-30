import java.util.ArrayList;


public class Logic {

	
	
	public Integer[] calculate(int input )
	{
		
		
	
		double result = 0;
		int characters = 0;
		int digits = 0;

		int max_digits = 0;
		int max_chr = 0;

		digits = 0;
		while (input > result) {
			result = Math.pow(26, characters) * Math.pow(10, digits);
			characters++;
			max_chr = characters;
		}

		System.out.println(result + " characters: " + characters + " digits: "
				+ digits);

		digits = 0;
		characters = 0;
		result = 0;
		while (input > result) {
			result = Math.pow(26, characters) * Math.pow(10, digits);
			digits++;
			max_digits = digits;
		}

		System.out.println(result + " characters: " + characters + " digits: "
				+ digits);

		digits = 0;
		characters = 0;
		result = 0;

		ArrayList<Integer[]> maxcases = new ArrayList<Integer[]>();

		for (int i = 0; i < max_digits; i++)
			for (int j = 0; j < max_chr; j++) {
				result = Math.pow(26, j) * Math.pow(10, i);
				if (result >= input) {
					Integer[] sol = new Integer[3];
					sol[0] = i;
					sol[1] = j;
					sol[2] = (int)result;
					
					maxcases.add(sol);

				}

			}
		
		
		Integer[] min_case=maxcases.get(0);
		
		
		for (int i=0; i<maxcases.size();i++)
		{
		 
		  if (min_case[2]>maxcases.get(i)[2])
		  {
			  min_case=maxcases.get(i);
		  }
		}
		
		
	
		
		for (int i=0; i<maxcases.size();i++)
		{
		   System.out.println("digits: "+maxcases.get(i)[0]);
		   System.out.println("characters: "+maxcases.get(i)[1]);
		   System.out.println("result: "+maxcases.get(i)[2]);
		}
		
		

		   System.out.println("Min case digits: "+min_case[0]);
		   System.out.println("Min case characters: "+min_case[1]);
		   System.out.println("Min case result: "+min_case[2]);
		   
		   return min_case;
		
	}
	
}
