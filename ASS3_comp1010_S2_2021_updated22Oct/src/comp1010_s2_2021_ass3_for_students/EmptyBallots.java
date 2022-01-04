//ID, NAME (For example, "40404040, Janet Kim")
//Put x inside [] below:
//[] 	This assignment is entirely my own work and 
// 		I have not seen anyone else's code or design
package comp1010_s2_2021_ass3_for_students;
public class EmptyBallots {

	public Ballot head;
	public Ballot tail;
	public int size;
	
	/** 5 marks - Pass level
	 * 
	 * Create a list with n empty ballots, with id from 0 to n-1
	 * 
	 * @param n - the number of empty ballots to create in the list
	 */
        
	public EmptyBallots(int n) {
	    if(head==null){
                head = new Ballot(0,null);
                tail = head;
                size++;
               }
	    
          //  Ballot temp = head;
            
            for(int i=1; i<n; i++){
               // temp.next = new Ballot(i,null);
            	tail.next = new Ballot(i,null);
            	tail = tail.next;
                size++;
              //  temp = temp.next;             
            }
	}
	
	/** 5 marks - Pass level
	 * 
	 * Remove the first empty ballot from the list
	 * 
	 * @return the removed ballot if there are still empty ballots
	 *         left in the list, null otherwise
	 */
	public Ballot remove() {
		if(head==null)
                    return null;
                Ballot temp = head;
                 head=head.next;
                 size--;
                 
                //if(head!=null)
                  return temp;                    	
	}
	
	/** 5 marks - Pass level
	 * 
	 * Check if the ids of the empty ballots in the list are sequential
	 * in an increasing incremental order. For example, if the first empty ballot
	 * id is 13, then it should be followed by ballots with ids 14, 15,
	 * and so on.
	 * 
	 * @return true if the ids in the empty ballots are sequential in 
	 *         increasing incremental order, or if the list is empty, false otherwise
	 */
	public boolean isValid() {
		        if(head==null)
                    return false;
                int flag = 0;
                boolean isInOrder = true;
                Ballot temp = head;
                while(temp.next!=null){                  
                   if(temp.id < temp.next.id+1){
                        isInOrder = false;
                        flag++;
                        //break;
                   }                    
                    else
                        isInOrder = false;
                    
                    temp = temp.next;
                }
                if(flag == size-1 )
                	return true;
                
		return isInOrder;
	}
	
}
