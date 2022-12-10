import java.util.*;
import java.io.*;


public class lab13 {
	
	
	ArrayList<Integer> list = new ArrayList<>();
	public void readData(String filename)
	{
			String str = "";
			BufferedReader reader;
			list = new ArrayList<>();
			try {
				reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
				while ((str = reader.readLine())!= null) {
					list.add(Integer.valueOf(str.trim()));
				}
				reader.close();
			}
				
			catch(Exception e) {
				System.out.println(e.toString());
			}
			
		
			
		for( int i = 0; i < 1000; i++ )
		{
			list.add(Integer.valueOf(i));
		}		
	}
		
	public long getTotalCount()
	{
		return (list.stream().count());
		
	}
	public long getOddCount()
	{
		return (list.stream().filter(x-> x % 2 != 0 ).count());
	}
	public long getEvenCount()
	{
		return (list.stream().filter(x-> x % 2 == 0 ).count());
	}
	public long getDistinctGreaterThanFiveCount()
	{
		return (list.stream().filter(x-> x >5).distinct().count());
	}
	public Integer[] getResult1()
	{
		return list.stream().filter(x-> x % 2 == 0 && x > 5 && x<50).sorted().toArray(Integer[]::new);
	}
	public Integer[] getResult2()
	{
		return list.stream().map(x-> x*x*3).limit(50).toArray(Integer[]::new);
	}
	public Integer[] getResult3()
	{
		return  list.stream().filter(x-> x %2 ==1).map(x -> x* 2).sorted().skip(20).distinct().toArray(Integer[]::new);
	}
}
