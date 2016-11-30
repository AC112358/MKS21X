public class CirculatingBook extends LibraryBook{
    String currentHolder;
    String dueDate;

    public CirculatingBook(String a, String t, String i, String c){
	super(a,t,i,c);
	currentHolder = null;
	dueDate = null;
    }

    public String getCurrentHolder(){
	return currentHolder;
    }
    public String getDueDate(){
	return dueDate;
    }

    public void setCurrentHolder(String ch){
	currentHolder = ch;
    }
    public void setDueDate(String d){
	dueDate = d;
    }

    public void checkout(String patron, String due){
	setCurrentHolder(patron);
	setDueDate(due);
    }

    public void returned(){
	currentHolder = null;
	dueDate = null;
    }

    public String circulationStatus(){
	if (currentHolder == null){
	    return "book available on shelves";
	}
	return getCurrentHolder() + ", " + getDueDate();
    }

    public String toString(){
	return super.toString();
    }
}
