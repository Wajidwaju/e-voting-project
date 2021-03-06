//ID, NAME (For example, "40404040, Janet Kim")
//Put x inside [] below:
//[] 	This assignment is entirely my own work and 
// 		I have not seen anyone else's code or design
package comp1010_s2_2021_ass3_for_students;

/*
 * class representing a voting card (ballot)
 * 
 * is also a node in the two kind of linked lists to construct and manipulate
 * 
 * 
 */




public class Ballot {

	public int id; // unique identifier of voting card
	public String candidate; // name of candidate for vote (possibly incorrect/invalid/null)
	public Ballot next;     // reference to next ballot in appropriate Linked List
	public Timestamp timestamp; // unique time stamp (provided at voting time)
	public boolean filled;  // becomes true when vote is casted
	
	/** 
	 * 
	 * @param id 
	 * represents the official identity number of the Ballot
	 * @param next
	 * is the reference to the next Ballot in the relevant list
	 * other parameters need to be set with default values
	 */
	
	public Ballot(int id, Ballot next) {
		// Provided - not to be changed
		candidate = null;
		this.id = id;
		this.next = next;
		this.filled = false;
		this.timestamp = null;
	}
	
	public static Ballot fromBallot(Ballot e) {
		return new Ballot(e.id, e.next, e.candidate, e.filled, e.timestamp);
	}
	
	public Ballot(int id, Ballot next, String candidate, boolean filled, Timestamp timestamp) {
		this.candidate = candidate;
		this.id = id;
		this.next = next;
		this.filled = filled;
		this.timestamp = timestamp;
	}

    Ballot(int i, Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
	/**
	 * Voting: the voting card is filled
	 * 
	 * @param name of (possibly incorrect) candidate name
	 * @param time stamp of the vote
	 * 
	 * need to fill the ballot: the vote
	 * need to check whether has been already filled (used for voting)
	 * and both name and time stamp are not null 
	 * 
	 * @return - true if ballot was successfully filled, false otherwise
	 */
	public boolean fill(String name, Timestamp time) {
		if(name==null || time==null)
			return false;
            if(this.filled && this.candidate!=null && this.timestamp!=null)
                return false;
            if(this.candidate==null && this.timestamp==null){
                    this.candidate=name;
                    this.timestamp=time;
                    this.filled=true;
                    return true;
                }               
		return false;                
	}
	
	/**
	 * 
	 * You may assume that the input array (String[] candidates) will
	 * not be null or empty.
	 * 
	 * @param first - first valid id
	 * @param last  - last valid id
	 * 
	 * A ballot is valid if it is: filled, time-stamped, 
	 * and have an official id and a vote for one of the candidate listed
     * @param candidates
	 * 
	 * @return true if the Ballot is valid based on the criteria listed above,
	 *         false otherwise
	 */
	public boolean isValid(int first, int last, String[] candidates) {

                boolean isCandidateMatch = false;
                
            for (String candidate1 : candidates) {
                if (candidate1.equals(candidate)) {
                    isCandidateMatch = true;
                    break;
                }
            }
            
            if(this.filled && isCandidateMatch && this.timestamp != null && (this.id==first || this.id==last)){
                return true;
            }
		return false;
		
	}
}
