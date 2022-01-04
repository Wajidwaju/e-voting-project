//ID, NAME (For example, "40404040, Janet Kim")
//Put x inside [] below:
//[] 	This assignment is entirely my own work and 
// 		I have not seen anyone else's code or design
package comp1010_s2_2021_ass3_for_students;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

public class FilledBallots {

	public Ballot head;
	public Ballot tail;
        public int size;
	
	// add attributes as needed
	// needed to implement efficient code 
	// tested for `advanced' parts
	
	/**
	 * Default constructor
	 * 
	 * You may modify this constructor if you need to (e.g.
	 * if you want to initialize extra attributes in the class)
	 */
	public FilledBallots() {
		head = null;
		tail=null;
		//
		// add initialisation of added attributes, if needed
		
	}
	

    	/**
	 * 5 marks - P level
	 * 
	 * Add a vote (a ballot) for a candidate to the END of the Filled list.
	 * 
	 * @param candidate - the name of the candidate voted for
         * @param ballots - the list of empty ballots where the official card comes from
         * @param time - a new time stamp
	 * 
	 */

	
	public void addVote(String candidate, EmptyBallots ballots, Timestamp time) {
		//
		// TODO - 5 marks
                Ballot removedBallot=ballots.remove();
                if(removedBallot==null){
                    System.out.println("No more Empty Ballots");
//                    return;
                } else {
					if(this.head==null){
					//                      removedBallot = 
					this.tail = this.head = new Ballot(removedBallot.id,null, candidate, removedBallot.fill(candidate, time), time);
					++this.size;
					
					//                    return;
				  } else {       
	                  	this.tail = this.tail.next = new Ballot(removedBallot.id,null, candidate, removedBallot.fill(candidate, time), time);
	                     
	                      ++this.size;
	//                              return;
	                                                             
	              }            
                }
                
            //    if(candidate!=null && ballots!=null && time!=null){
                                                         
                                 
                  //  }                                 	
	}
	
	/**
	 * 5 marks, P level
	 * 
	 * Count the number of votes obtained by a candidate in a valid Filled list.
	 * 
	 * @param candidate	- the name of the candidate
	 * @return the number of votes obtained by the candidate
	 */
	public int countVoteFor(String candidate) {
		//
		// TODO - 5 marks
                if(this.head==null)
                    return 0;
                
                int count = 0;
                Ballot temp = head;
                
                while(temp!=null){                   
                    if(temp.candidate.equals(candidate)){
                        count++;
                    }
                    temp = temp.next;
                }               
		return count;
	}
	
	
	/** 
	 * 5 marks P level
	 * 4 marks Advanced P level for efficiency
	 * 
	 * Count how many ballots we have in the list.
	 * 
	 * @return the number of ballots in the list
	 */
	public int size() {
		//
		// TODO - 5 and 4 marks
		return size;
	}
	
	
	/**
	 * 5 marks
	 * 
	 * Check the integrity of the filled ballot list: 
	 * each ballot is valid and the list is in increasing time stamp order
	 * 
	 * @return true if the current list of ballots is valid,
	 *         false otherwise
	 */
	public boolean isValid(int first, int last, String[] candidates ) {
		//
		// TODO - 5 marks
                Ballot temp = this.head;
                int i = 0;
                while(temp!=null){
                    if(first == 0 && last == this.size && temp.isValid(temp.id, temp.id, candidates)){
                        i++;
                    }
                    temp = temp.next;
                }
                if(this.size==i)
                    return true;
		return false;
	}
	

    	/**
	 * 5 marks
	 * 
	 * Insert a ballot to the Filled list such that the list remains sorted
	 * by timestamp.
	 * pre-condition: the Filled list is sorted by timestamp
	 * post-condition: the Filled list is sorted by timestamp
	 * 
	 * You may assume that the ballot to be inserted is valid and that
	 * its next field is initially null (it is not connected to another ballot before insertion).
	 * 
	 * @param b - the ballot to be inserted
	 */

	public void insertBallot(Ballot b) {          
		//
		// TODO - 5 marks
		
		/* Ballot ba = null;
         Ballot start = null;
         int time;
         boolean flag = false;
         boolean yes = false;
         int size2 = 0;
            
         for(Ballot temp=this.head; temp!=null; temp=temp.next){              
             time = temp.timestamp.compareTo(b.timestamp);
             if(time==1){
               Ballot c = new Ballot(b.id,temp); 
               c.candidate=b.candidate;
               c.filled=b.filled;
               c.timestamp=b.timestamp; 
               
                 if (ba==null)
                     ba = c;
                 
                     if(!yes) {
                     	flag = true;
                         start = ba;
                         yes = true;
                         size2++;                                
                     }                          
                      else{
                           flag=true;
                           ba.next = c;
                           ba=ba.next;
                           size2++;
                          }
             }                
         }
        
         size=size2;
         head = start;*/
		
            int time=0;
            Ballot temp = this.head;       
//            int i=0;
            
            time = head.timestamp.compareTo(b.timestamp);
            if(time == 1 || time == 0) {
            	head = new Ballot(b.id,head);
                head.candidate=b.candidate;
                head.timestamp=b.timestamp;
                head.filled=b.filled;
                size++;
            } else if(tail.timestamp.compareTo(b.timestamp) == -1 || tail.timestamp.compareTo(b.timestamp) == 0) {
            	tail = tail.next = new Ballot(b.id, null, b.candidate, b.filled, b.timestamp);
            	size++;
            } else {
            
	            while(temp!=null){
	            	//System.out.println(temp.timestamp.compareTo(b.timestamp)+"  "+i+"temp"+temp.id);
	                time = temp.timestamp.compareTo(b.timestamp);
	                if(time == 1 || time==0){
	                	temp.next = new Ballot(b.id,temp.next);
	    	            temp.next.candidate=b.candidate;
	    	            temp.next.timestamp=b.timestamp;
	    	            temp.next.filled=b.filled; 
	    	            size++;
	                    return;
	                }                 
	              temp = temp.next;  
	            }
	            tail = tail.next = new Ballot(b.id, null, b.candidate, b.filled, b.timestamp);
            	size++;
//	            System.out.println(h.equals(temp.next));
		}
	}
	
	/**
	 * 5 marks - Pass level
	 * 
	 * Remove from this list all ballots that was added after the 
	 * cutoff time (given as Timestamp t), that is remove
	 * all ballots that has a timestamp strictly greater than t.
	 * 
	 * @param t - the out-of-time limit
	 * @return - true if at least one ballot was removed, false otherwise
	 *           (including if the list was empty)
	 */
	public boolean removeLateBallots(Timestamp t) {
		//
		// TODO - 5 marks
                if(this.head==null)
                    return false;
                
                Ballot b = null;
                Ballot start = null;
                int time;
                boolean flag = false;
                boolean yes = false;
                int size2 = 0;
                   
                for(Ballot temp=this.head; temp!=null; temp=temp.next){              
                    time = temp.timestamp.compareTo(t);
                    if(time==-1){
                      Ballot c = new Ballot(temp.id,null); 
                      c.candidate=temp.candidate;
                      c.filled=temp.filled;
                      c.timestamp=temp.timestamp; 
                      
                        if (b==null)
                            b = c;
                        
                            if(!yes) {
                            	flag = true;
                                start = b;
                                yes = true;
                                size2++;                                
                            }                          
                             else{
                                  flag=true;
                                  b.next = c;
                                  b=b.next;
                                  size2++;
                                 }
                    }                
                }
               
                size=size2;
                head = start;
		return flag;
	}
	
	/**
	 * 5 marks - Credit level
	 * 
	 * Remove all blank ballots from the list, that is,
	 * remove all ballots where the candidate field is
	 * not filled. 
	 * 
	 * You can assume that if the candidate field of a
	 * ballot is not empty, then it must have at least
	 * one alpha-numeric character (i.e. it cannot be
	 * just white spaces)
	 * 
	 * @return - true if at least one ballot was removed,
	 * 			 false otherwise (including if the list
	 *           is empty)
	 */
	
	
	public boolean removeBlankBallots() {
		//
		// TODO - 5 marks
		
                 if(this.head==null)
                    return false;              
                Ballot b = null;
                Ballot start = null;
                boolean flag = false;
                boolean yes = false;               
                int size2=0;
                
                
                for(Ballot temp=this.head; temp!=null; temp=temp.next){
                	
                    if(temp.candidate.length()==0 ||  temp.candidate.trim().isEmpty() || temp.candidate==null){
                        // only check for condition
                    }
                    else{
                         Ballot c = new Ballot(temp.id,null); 
                      c.candidate=temp.candidate;
                      c.filled=temp.filled;
                      c.timestamp=temp.timestamp;
                      size2++;
                        if (b==null)
                            b = c;

                            if(!yes) {
                                start = b;
                                yes = true;                            
                            }
                             else{
                                  flag=true;
                                  b.next = c;
                                  b=b.next;                               
                                 }
                    }
                }                              
                
                if(this.size==size2)
                	flag = false;
                if(size2==0)
                	flag = true;
                
                head = start;
                this.size = size2;
                
		return flag;
	}
        
	/**
	 * 5 marks - Credit level
	 * 
	 * Remove all ballots from the list with an invalid candidate
	 * name. The list of valid candidate names is given as
	 * an input. 
	 * 
	 * Important: you must NOT modify the input array (String[] candidates)
	 * 
	 * @param candidates - an array containing valid candidate
	 *                     names
	 * @return true if at least one ballot was removed, 
	 *         false otherwise (including if the list
	 *         is empty or null)
	 */
	public boolean removeInvalidBallots(String[] candidates) {
		//
		// TODO - 5 marks
		 if(this.head==null)
                    return false;                
                
                Ballot b = null;
                Ballot start = null;
                boolean yes = false;
                boolean flag=false;
                int size2 = 0 ;
                
                for(Ballot temp=this.head; temp!=null; temp=temp.next){

                    for(int i=0; i<candidates.length; i++){
                        
                    if(candidates[i].equals(temp.candidate)){ 
                        
                      Ballot c = new Ballot(temp.id,null); 
                      c.candidate=temp.candidate;
                      c.filled=temp.filled;
                      c.timestamp=temp.timestamp;  
                      size2++;
                        if (b==null)
                            b = c;

                        if(!yes) {
                           start = b;
                           yes = true;
                          }
                         else{
                           flag=true;
                           b.next = c;
                           b=b.next;
                          }
                    }
                }                
             }
                
                if(this.size==size2)
                	flag = false;
                if(size2==0)
                	flag = true;
                
                head = start;
                this.size = size2;
              
		return flag;
	}
	
	

	/**
	 * 5 marks - D level
	 * 
	 * Find the percentage (out of 100) of valid votes obtained by each 
	 * candidate.
	 * 
	 * @param candidates - the list of candidates
	 * @return an array of Double containing the percentage of valid votes
	 *         obtained by the candidates (the percentage of votes
	 *         obtained by candidates[i] should be returned in index i
	 *         of the array)
	 */
	public Double[] findPercentages(String[] candidates) {
		//
		// TODO - 5 marks
                Double votePercentage[] = new Double[candidates.length];
                double votes =0;                

                
                removeInvalidBallots(candidates);
                
                for(int i=0; i<candidates.length; i++){
                    	 votes = countVoteFor(candidates[i]);   
                         if(votes == 0.0 && this.size==0)
                         	votePercentage[i] = 0.0;
                         else
                         votePercentage[i] = (votes*100)/this.size;                  
                }
                
		return votePercentage;
	}


	/* 5 marks - D level
	 * 
	 * Find the candidate with the majority vote, defined to be at 
	 * least half of the valid votes + 1. You may assume that the 
	 * list contains only valid Ballots. 
	 * 
	 * Return null if no candidate received the majority vote, or if
	 * the list is empty.
	 * 
	 */
	public String findMajority() {
		//
		// TODO - 5 marks
                if(this.head==null)
                    return null;
                
                String majorityVotesHolder="";
                Ballot temp = this.head;
                
                while(temp!=null){
                   int  votes = countVoteFor(temp.candidate);
                    if(votes>=((size/2)+1)){
                        majorityVotesHolder = temp.candidate;
                  }
                    temp = temp.next;
                }
                
                if(majorityVotesHolder.length()!=0)
                    return majorityVotesHolder;  
                
		return null;		
	}
	
	/** (8 marks - HD level)
	 * 
	 * Constructor - creates a new FilledBallots by combining two 
	 *               sorted FilledBallots
	 * 
	 * For this task, you need to write a constructor that creates a new
	 * FilledBallots object by combining two other FilledBallots object,
	 * list1 and list2. You must not make new ballots in the process
	 * (i.e. you should transfer the ballots from both list to the new one).
	 * 
	 * You can assume that list1 and list2 are valid FilledBallots (that is,
	 * all Ballot objects in both lists are valid as defined in the assignment
	 * specification), and that they are sorted according to the Ballots'
	 * timestamps. 
	 * 
	 * The resulting FilledBallot must also be sorted according to the ballots'
	 * timestamp. Please see UnitTest.java for a sample input and the expected
	 * output. 
	 * 
	 * If both list1 and list2 are empty, then construct an empty FilledBallots. 
	 * Do the same if both lists are null. If only one of the lists are empty
	 * or null, then you should return the other.
	 * 
	 * You may assume that list1 and list2 are not going to be used beyond
	 * this constructor (i.e. you can modify list1 and list2 as you please)
	 * 
	 * @param list1 - the first FilledBallots 
	 * @param list2 - the second FilledBallots
	 */
	public FilledBallots(FilledBallots list1, FilledBallots list2) {
		//
		// TODO - 8 marks
                if((list1==null && list2==null)){
                	this.head = null;
                    this.size=0;
                 } 
                else if(list1==null){
                    if(list2!=null){
                        if(list2.size==0){
                            this.head =null;
                        }
                        else{
                        	this.head = list2.head;
                        	this.size = list2.size;
//                            this.head = new Ballot(list2.head.id,null);
//	                        this.head.candidate = list2.head.candidate;
//	                        this.head.timestamp = list2.head.timestamp;
//	                        this.head.filled = list2.head.filled;
//	                        Ballot temp = this.head;
//	                        Ballot b = list2.head;
//	                        while(b!=null){
//	                            temp.next = b.next;
//	                            temp = temp.next;
//	                            b = b.next;
//	                        }  
                        }                                                                                                        
                    }        
                    return;
                }
                else if(list2==null){
                    if(list1!=null){
                         if(list1.size==0){
                            this.head =null;
                        }
                         else{
                        	 this.head = list1.head;
                        	 this.size = list1.size;
//                             this.head = new Ballot(list1.head.id,null);
//                        this.head.candidate = list1.head.candidate;
//                        this.head.timestamp = list1.head.timestamp;
//                        this.head.filled = list1.head.filled;
//                        Ballot temp = this.head;
//                        Ballot b = list1.head;
//                        while(b!=null){
//                            temp.next = b.next;
//                            temp = temp.next;
//                            b = b.next;
//                        }   
                         }
                    }   
                    return;
                }
                else if( (list1.size == 0 && list2.size == 0)) {
                	this.head = null;
                    this.size=0;
                }
                else{
                    Ballot l1 = list1.head;
                    Ballot l2 = list2.head;
//                    Ballot temp = this.head;
                    if(l1 == null && l2 == null) {
                    	this.head = null;
                    	this.size = 0;
                    } else if (l1 == null) {
                    	this.head = l2;
                    	this.tail = list2.tail;
                    	this.size = list2.size;
//                    	temp = l2;
//                    	while(temp.next != null) {
//                    		if(temp.next == null) {
//                    			this.tail = temp;
//                    		}
//                    	}
                    } else if(l2 == null) {
                    	this.head = l1;
                    	this.tail = list1.tail;
                    	this.size = list1.size;
//                    	temp = l1;
//                    	while(temp.next != null) {
//                    		if(temp.next == null) {
//                    			this.tail = temp;
//                    		}
//                    	}
                    } else {
                    	Ballot temp1 = list1.head, temp2 = list2.head;
                    	ArrayList<Ballot> listA = new ArrayList<Ballot>();
                    	for(int i = 0; i < list1.size; ++i) {
                    		if(temp1 != null) listA.add(temp1);
                    		temp1 = temp1.next;
                    	}
                    	for(int i = 0; i < list2.size; ++i) {
                    		if(temp2 != null) listA.add(temp2);
                    		temp2 = temp2.next;
                    	}
                    	Collections.sort(listA, new Comparator<Ballot>() {
                    		  public int compare(Ballot o1, Ballot o2) {
                    		      return o1.timestamp.compareTo(o2.timestamp);
                    		  }
                    		});
                    	this.head = null;
                    	for(Ballot t:listA) {
                    		if(this.head == null) {
                    			this.head = t;
                    			this.head.next = null;
                    			this.tail = this.head;
                    		} else {
                    			this.tail = this.tail.next = t;
                    			this.tail.next = null;
                    		}
                    	}
                    	
//                    	int time = l1.timestamp.compareTo(l2.timestamp);
//                        if(time == -1){
//                        	this.head = l1;
//                        	this.tail = list1.tail;
//                        	
////                        	temp = l2;
////                        	while(temp.next != null) {
////                        		if(temp.next == null) {
////                        			this.tail = temp;
////                        		}
////                        	}
//                        }
//                        else{
//                        	this.head = l2;
//                        	this.tail = list2.tail;
////                        	this.size += list2.size;
////                        	temp = l2;
////                        	while(temp.next != null) {
////                        		if(temp.next == null) {
////                        			this.tail = temp;
////                        		}
////                        	}
//                        }
                        
                        this.size = list2.size+ list1.size;
                        
                    }
                    
                }	
	}
	
	/** (8 marks - HD level)
	 * 
	 * Constructor - creates a new FilledBallots by combining all the sorted
	 *               FilledBallots in an array.
	 *
	 * For this task, you need to write another constructor that combines
	 * FilledBallots objects, but this time all the FilledBallots you need
	 * to combine are stored in an array. Note that as in the previous task,
	 * you must transfer the ballots instead of making their copies.
	 * 
	 * As before, you can assume that list1 and list2 are valid FilledBallots,
	 * and that they are sorted according to the Ballots' timestamps, and
	 * the resulting FilledBallot must also be sorted according to the ballots'
	 * timestamp. 
 	 * 
 	 * If all the FilledBallots in the array are empty, then you need to construct
 	 * an empty FilledBallot as well. Do the same if the input list is null,
 	 * or only contain nulls.
 	 * 
 	 * You may modify any of the FilledBallots object in the array as they will
 	 * not be used beyond this constructor.
	 * 
	 * @param list - the array containing the FilledBallots to be combined
	 */
	public FilledBallots(FilledBallots[] list) {
		//
		// TODO - 8 marks
		if(list == null){
            this.head = null;
            this.size=0;
        }
		
//		ArrayList<Ballot> listA = new ArrayList<Ballot>();
		TreeSet<Ballot> set = new TreeSet<Ballot>(new Comparator<Ballot>() {
	  		  public int compare(Ballot o1, Ballot o2) {
	  		      return o1.timestamp.compareTo(o2.timestamp);
	  		  }
	  		});
    	
    	
		Ballot temp;
		for(int i = 0; i < list.length; i++) {
			if(list[i] != null) {
				temp = list[i].head;
				while(temp != null) {
					set.add(temp);
					temp = temp.next;
				}
			}
		}
		
//		Collections.sort(listA, new Comparator<Ballot>() {
//  		  public int compare(Ballot o1, Ballot o2) {
//  		      return o1.timestamp.compareTo(o2.timestamp);
//  		  }
//  		});
		
		for(Ballot t : set) {
//			System.out.println("timestamp: "+t.timestamp.getTime());
			if(this.head == null) {
    			this.head = t;
    			this.head.next = null;
    			this.tail = this.head;
    		} else {
    			this.tail = this.tail.next = t;
    			this.tail.next = null;
    		}
			this.size++;
		}
		
                
//                int flag1 = 0;               
//                for(int i=0; i<list.length; i++){
//                    if(list[i]==null || list[i].size==0)
//                        flag1++;
//                }
//                /* for(int j=i+1; j<list.length-1; j++){
//                           if(list[i]!=null && list[j]!=null)
//                            time= list[i].head.timestamp.compareTo(list[j+1].head.timestamp);
//                           if(time == -1)*/
//		if(flag1==list.length){
//                    this.head = null;
//                    this.size = 0;
//                }
//                else{
//                   int time=0;
//                   flag1 = 0;
//                   int flag2 = 0;
//                   Ballot b;
//                   Ballot temp=this.head;
//                   for(int i=0; i<list.length-1; i++){
//                       
//                       if(list[i]!=null && list[i+1]!=null)
//                            time= list[i].head.timestamp.compareTo(list[i+1].head.timestamp);
//                       
//                       if(time==-1){
//                           flag1++;                                             
//                       }
//                       else{
//                           flag2++;
//                       }
//                       
//                      // if(flag1==list.length)
//                       
//                   }                  
//                }
		
	}

}
