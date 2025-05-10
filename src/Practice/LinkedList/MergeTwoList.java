package Practice.LinkedList;

public class MergeTwoList {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode next1 = l1;
        ListNode next2 = l2;
        ListNode start = new ListNode(0);
        ListNode result =start;
        
        if((l1!=null) && (l2!=null)){
            while(next1 !=null && next2!=null){
                
                 
                if(next1.val< next2.val){
                    result.next = new ListNode(next1.val);
                    
                    next1 = next1.next;
                    System.out.println(result.val);
                }

                else if(next2.val>= next2.val){
                    
                	result.next = new ListNode(next2.val);
                    next2 = next2.next;
                    
                }
                System.out.println(result.val);
                
                
                result = result.next;
                result.next = null;
               
            }
        }

        while(next1!=null)

        {
        	result.next = new ListNode(next1.val);
        	result = result.next;
            result.next=null;

            next1= next1.next;
            

        }

        while(next2!=null)
        {
        	result.next = new ListNode(next2.val);
        	result= result.next;
            result.next=null;
            
            next2= next2.next;
        }
        
        if(l1 == null && l2 ==null)
        {
            start =null;
        }
        return start.next;
    }
	
	public static void main(String[] args)
	{
	/*	ListNode l1 = new ListNode(1);
		l1.next=new ListNode(2);
		l1.next.next=new ListNode(4);
		
		ListNode l2 = new ListNode(1);
		l2.next=new ListNode(3);
		l2.next.next=new ListNode(4);
		l2.next.next.next=new ListNode(5);
		ListNode res = mergeTwoLists(l1, l2);*/
		
		ListNode l3 = new ListNode(-9);
		l3.next=new ListNode(3);
		
		
		ListNode l4 = new ListNode(5);
		l4.next=new ListNode(7);
		ListNode result = mergeTwoLists(l3, l4);
		while(result!=null)
		{
			System.out.print(result.val);
			result = result.next;
		}
		
	}

}
