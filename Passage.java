class Passage{
	public static void main(String args[]){
		String s=",madhu lovEs, madhu";
		int sp=1,d=1,ch=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)==' ')
				sp++;
			else if(s.charAt(i)=='.'){
				d++;ch++;
			}
			else
			ch++;
		}
		System.out.println("THE NUMBER OF LINES "+d);
		System.out.println("THE NUMBER OF CHARECTERS "+(ch));
		System.out.println("THE NUMBER OF WORDS "+sp);
	}
}
