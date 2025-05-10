package Amazon;

import java.util.HashMap;
import java.util.HashSet;
public class PackageDelivery {
	
	HashSet<Integer> smallSet = new HashSet<Integer>();
	HashSet<Integer> mediumSet = new HashSet<Integer>();
	HashSet<Integer> largeSet = new HashSet<Integer>();
	
	HashMap<Integer,Integer> smallMap = new HashMap<Integer,Integer>();
	HashMap<Integer,Integer> mediumMap = new HashMap<Integer,Integer>();
	HashMap<Integer,Integer> largeMap = new HashMap<Integer,Integer>();
	
	public enum Size{
		small, medium, large;
	}
	
	public PackageDelivery() {
		smallSet.add(1);
		smallSet.add(2);
		smallSet.add(3);
		
		mediumSet.add(4);
		mediumSet.add(5);
		mediumSet.add(6);
		
		largeSet.add(7);
		largeSet.add(8);
		largeSet.add(9);
	}
	
	
	public  int setLocker(int orderId, Size packageSize) {
		
		switch(packageSize) {
			case small:
				if(!smallSet.isEmpty()) {
					int lockerId =  smallSet.iterator().next();
					smallSet.remove(lockerId);
					smallMap.put(orderId, lockerId);
					return lockerId;
				}
				else if(!mediumSet.isEmpty()) {
					int lockerId =  mediumSet.iterator().next();
					mediumSet.remove(lockerId);
					mediumMap.put(orderId, lockerId);
					return lockerId;
				}
				else if(!largeSet.isEmpty()) {
					int lockerId =  largeSet.iterator().next();
					largeSet.remove(lockerId);
					largeMap.put(orderId, lockerId);
					return lockerId;
				}
				else
					return -1;
				
			case medium:
				if(!mediumSet.isEmpty()) {
					int lockerId =  mediumSet.iterator().next();
					mediumSet.remove(lockerId);
					mediumMap.put(orderId, lockerId);
					return lockerId;
				}
				else if(!largeSet.isEmpty()) {
					int lockerId =  largeSet.iterator().next();
					largeSet.remove(lockerId);
					largeMap.put(orderId, lockerId);
					return lockerId;
				}
				else
					return -1;	
				
			case large:
				if(!largeSet.isEmpty()) {
					int lockerId =  largeSet.iterator().next();
					largeSet.remove(lockerId);
					largeMap.put(orderId, lockerId);
					return lockerId;
				}
				else
					return -1;
			default:
				return -1;
				
		}
	}
	public int getLocker(int orderId) {
		if(smallMap.containsKey(orderId)) {
			return smallMap.get(orderId);
		}
		else if(mediumMap.containsKey(orderId)) {
			return mediumMap.get(orderId);

		}
		else if(largeMap.containsKey(orderId)) {
			return largeMap.get(orderId);

		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		PackageDelivery pd = new PackageDelivery();
		System.out.println(pd.setLocker(9, Size.small));
		System.out.println(pd.setLocker(10, Size.small));
		System.out.println(pd.setLocker(11, Size.medium));
		System.out.println(pd.setLocker(12, Size.small));
		System.out.println(pd.setLocker(4, Size.small));
		System.out.println(pd.setLocker(100, Size.large));
		System.out.println(pd.setLocker(101, Size.large));
		System.out.println(pd.setLocker(102, Size.large));
		System.out.println(pd.setLocker(103, Size.large));
		System.out.println("-----------------------");
		System.out.println(pd.getLocker(9));
		System.out.println(pd.getLocker(10));
		System.out.println(pd.getLocker(11));
		System.out.println(pd.getLocker(12));
		System.out.println(pd.getLocker(4));
		System.out.println(pd.getLocker(100));
		System.out.println(pd.getLocker(101));
		System.out.println(pd.getLocker(102));
		System.out.println(pd.getLocker(103));
	}

}





