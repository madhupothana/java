
class Ticket{
	private int ticketNum;
	private String source;
	private String destination;
	private String startTime;
	private String endTime;
	private Passenger passengers[];
	public Ticket(int t,String s,String d,String st,String et){
		ticketNum=t;
		source=s;
		destination=d;
		startTime=st;
		endTime=et;
	}
	public String getDestination(){
		return destination;
	}
	public int getTickNum(){
		return ticketNum;
	}
	public String getStartTime(){
		return startTime;
	}
	public String getEndTime(){
		return endTime;
	}
	public String getSource(){
		return source;
	}
	public void setPassengers(Passenger[] p){
		passengers=p;
	}
	public void madhu(){
		System.out.println(source);
	}
}
class Passenger{
	private String name;
	private int age;
	private String gender;
	public Passenger(String s,int d,String st){
		name=s;
		age=d;
		gender=st;
	}
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	public String getGender(){
		return gender;
	}
	public static void main(String[] args){
		Ticket tt=new Ticket(123,"jrg","vizag","5:30AM","12:30PM");
		Passenger[] travels=new Passenger[3];
		travels[0]=new Passenger("madhu",21,"male");
		travels[0]=new Passenger("padhu",28,"female");
		travels[0]=new Passenger("tadhu",29,"male");
		tt.setPassengers(travels);
		tt.madhu();
}

}	


