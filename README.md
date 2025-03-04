package dayeight;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

//basic iteration and adding in hashset and LinkedHashset
public class sets {
	public static void main(String[] args) {
		
		
		//collection data=new HashSet();
		//Set data=new HashSet();
		
		//HashSet data=new HashSet();
		
		LinkedHashSet data=new LinkedHashSet();
		data.add("Java");
		data.add(10);
		data.add(true);
		data.add(27.34f);
		data.add(67.94d);
		data.add('a');
		data.add("Java");
		data.add(10);
		data.add(109);
		
	Iterator itr=data.iterator();
	System.out.println("\n");
	while(itr.hasNext())
	{
		System.out.println(itr.next());
	}
	System.out.println("\n");
	
	data.forEach(dt->System.out.println(dt));
}

}
