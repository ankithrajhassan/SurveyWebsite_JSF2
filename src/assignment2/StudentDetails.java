package assignment2;

import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.io.FileReader;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.FileWriter;
import java.io.File;

@ManagedBean
@ApplicationScoped


public class StudentDetails {
    private String firstName;
    private String lastName;
    private String telephone;
    private String address;
    private String zip;
    private String city;
    private String state;
    private String email;
    private String knowAbout;
    private String likelihood;
    private String date;
    private String raffle;
    private String comments;
    
    
       	    
   	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}	
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	public String getKnowAbout() {
		return knowAbout;
	}
	public void setKnowAbout(String knowAbout) {
		this.knowAbout = knowAbout;
	}
	public String getLikelihood() {
		return likelihood;
	}
	public void setLikelihood(String likelihood) {
		this.likelihood = likelihood;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getComments() {
	   return comments;
	}
    public void setComments(String comments) {
	        this.comments = comments;
    }    
    public String getRaffle() {
        return raffle;
    }
    public void setRaffle(String raffle) {
        this.raffle = raffle;
    }



	//  private Student studentInfo = new Student();
	  private WinningResult winner = new WinningResult();
	  private String showVal;
	  private ArrayList<Student> studData = new ArrayList <Student>();
	
    
	public WinningResult getWinner() {
		return winner;
	}

	public void setWinner(WinningResult winner) {
		this.winner = winner;
	}

	public String getShowVal() {
		return showVal;
	}

	public void setShowVal(String showVal) {
		this.showVal = showVal;
	}

	public ArrayList<Student> getStudData() {
		return studData;
	}

	public void setStudData(ArrayList<Student> studData) {
		this.studData = studData;
	}


    public void main (String[] args) throws IOException{
       try{ readData();
   }
       catch (FileNotFoundException e) {
	e.printStackTrace();
	} catch (IOException e) {
	e.printStackTrace();
	}
   }

	  
	public void Calculations () throws IOException,NullPointerException {
		 
		int i = 0;
	    double sum = 0, StdDevSum = 0;	   
	    int[] numbers = new int [10];
	    String[] RafData;

	    try{
	        
	        if(!getRaffle().isEmpty())
	        {
	    		 RafData = getRaffle().split(",");
	             for(String j:RafData){
	            	numbers[i] = Integer.parseInt(j);
	                sum = sum + numbers[i];
	             }	       
	            winner.setMean(sum/RafData.length);
	            for ( i=0; i<RafData.length ; i++)
			    {
	            StdDevSum = StdDevSum + Math.pow(numbers[i] - winner.getMean(), 2);
			    }
			    winner.setSd(Math.sqrt(StdDevSum/(numbers.length)));
			}
	        
	    }
	        
	    catch(Exception e)
	        {
	            System.out.println("exception");
	        }
	    }
	    
	 public void addData() throws IOException, java.io.IOException {

	    FileWriter add = new FileWriter("Information.txt",true);
	    try
	        {
	    	System.out.println("getfirstname"+getFirstName()+" "+this.firstName);
	    	add.append(getFirstName()+"^"+getLastName()+"^"+getTelephone()+"^"+getAddress()+"^"
	                 +getZip()+"^"+getCity()+"^"+getState()+"^"+getEmail()+"^"+getKnowAbout()+"^"+
	                 getLikelihood()+"^"+getDate()+"^"+getRaffle()+"^"+getComments()+"^"+System.getProperty( "line.separator" ));
	       
	         }
	        
	    finally
	        {
	    	add.close();
	        }
	    }

	 public String readData() throws FileNotFoundException, IOException{
	        
		String Info = null; 
	      
	    try {
	    	
	        BufferedReader readerData = new BufferedReader(new FileReader("Information.txt"));

	        StringBuilder buildData = new StringBuilder();
	        
	        String dataEntry = readerData.readLine();
		       
	        while (dataEntry != null) {
		    String element[]=dataEntry.split("\\^");
		    System.out.println("Inside file writer");
		    
		    Student st=new Student();
		    
		    st.setFirstName(element[0]);
		    st.setLastName(element[1]);
		    st.setTelephone(element[2]);
		    st.setAddress(element[3]);
		    st.setZip(element[4]);
		    st.setCity(element[5]);
		    st.setState(element[6]);
		    st.setEmail(element[7]);
		    st.setKnowAbout(element[8]);
		    st.setLikelihood(element[9]);
		    st.setDate(element[10]);
		    st.setRaffle(element[11]);
		    st.setComments(element[12]);
		    
		    //add every emelent in the st object
		    //studData.add(element[0]);
		    //,element[1],element[2],element[3],element[4],element[5],element[6],element[7],element[8],element[9],element[10],element[11],element[12]))
            studData.add(st);
		    System.out.println("Data" +studData.get(0).getFirstName());
		    dataEntry = readerData.readLine();
	        }  
	
	        Info = buildData.toString();

	      
	    }
	    catch(Exception e){ 
	         System.out.println("Error");
	    }
	    
	    System.out.println("Info" + Info);
	    return Info;
	      
	    }
	 
	public String showData() throws IOException, java.io.IOException
	    {
	            
		  Calculations();
		  addData();
	  
	        if(winner.getMean()<90)
	           return "thankyou";
	        else 
	            return "winner";
	    }   

	 
     public String populate() throws IOException {
	        try
	        {
	        	showVal = readData();
	        }
	        catch (FileNotFoundException e) {
		        e.printStackTrace();
	        }
	        return "display";
	    }

}
