public class Book{
    String author;
    String title;
    String isbn;

    public Book(){
    }

    public Book(String a, String t, String i){
	setAuthor(a);
	setTitle(t);
	setISBN(i);
    }

    public String getAuthor(){
	return author;
    }
    public String getTitle(){
	return title;
    }
    public String getISBN(){
	return isbn;
    }

    public void setAuthor(String a){
	author = a;
    }
    public void setTitle(String t){
	title = t;
    }
    public void setISBN(String i){
	isbn = i;
    }


    public String toString(){
	return title + "," + author + "," + isbn;
    }
}
