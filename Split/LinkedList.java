/*LinkedList.java
 * Purpose: Creates a linked list with nodes that store an integer and the next node
 * in the linked list.
 */

public class LinkedList {
	ListNode head;
	ListNode tail;
	
	/***
	 * Constructor
	 */
	public LinkedList () {
		clearList();
	}
	
	private static class ListNode {
		int number;
		ListNode nextNode;
		
		/***
		 * Constructor
		 * @param number
		 * @param nextNode
		 */
		public ListNode (int number, ListNode nextNode) {
			number = this.number;
			nextNode = this.nextNode;
		}
	}
	
	public void clearList(){
		head = new ListNode(0, null);
		tail = new ListNode(0, null);
		head.nextNode = tail;		
	}
	
	/**
	 * Add a node to linked list
	 * @param inputNum
	 * @return
	 */
	public boolean add (int inputNum){
		ListNode newNode = new ListNode (inputNum, null);
		
		//Linked List is empty
		if (head.nextNode == tail){
			head.nextNode = newNode;
			newNode.nextNode = tail;
			newNode.number = inputNum;
			return true;
		}
		
		ListNode currentNode = head.nextNode;
		while (currentNode != tail){
			if (currentNode.nextNode == tail){
				currentNode.nextNode = newNode;
				newNode.nextNode = tail;
				newNode.number = inputNum;
				return true;
			}
			currentNode = currentNode.nextNode;
		}
		return false;   //Number not added to linked list
	}

    
    /**
     * Returns true if integers in linked list can be put into two subsets
     * with a lowest common divisors that don't divide each other
     * @return
     */
    public boolean twoSubsets (){
    	ListNode currentNode = head.nextNode;
    	int subsetNum = 1;
    	int n1 = currentNode.number;
    	currentNode = currentNode.nextNode;
    	int n2 = 0;
    	
    	while (currentNode != tail){
    		int currentNum = currentNode.number;
    		
    		if (n1 % currentNum != 0 && currentNum % n1 != 0){
    			if (n2 == 0){
    				n2 = currentNum;
    				subsetNum++;
    			}
    			else if (n2 % currentNum != 0 && currentNum % n2 != 0)
    				return false;
    			else if (n2 > currentNum)
    				n2 = currentNum;
    		}
    		else if(n1 > currentNum){
    			n1 = currentNum;
    		}
    		currentNode = currentNode.nextNode;
    	}
    	
    	if (subsetNum == 2)
    		return true;
    	else
    		return false;
    }
}
