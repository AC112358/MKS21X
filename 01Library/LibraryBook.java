abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    String callNumber;

    public LibraryBook(String a, String t, String i, String c){
	super(a, t, c);
	setCallNumber(c);
    }

    public String getCallNumber(){
	return callNumber;
    }
    public String setCallNumber(String c){
	callNumber = c;
    }

    public abstract void checkout(String patron, String due);
    public abstract void returned();
    public abstract String circulationStatus();

    public int compareTo(LibraryBook b){
	return callNumber.compareTo(b.callNumber);
    }

    public String toString(){
	return super.toString() + "," + circulationStatus() + "," + callNumber;
    }
}