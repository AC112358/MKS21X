import java.util.Iterator;

public class SuperArray implements Iterable<String>{
  private String[] data;
  private int size;
  private final int INIT_SIZE = 3;
   
  //0
  //constructor make an empty superArray should make size 0, 
  //but the data capacity 10.
    public SuperArray(){
    size = 0;
    data = new String[INIT_SIZE];
    }
    public SuperArray(int initialCapacity){
    if (initialCapacity < 0){
        throw new IllegalArgumentException();
    }
    size = initialCapacity;
    data = new String[initialCapacity];
}
     
 
  public int size(){
    return size;
  }
 
    public String get(int index){
    if (index < 0 || index >= size()){
        throw new IndexOutOfBoundsException();
    }
    return data[index];
     
    }
    public void clear(){
    size = 0;
    }
    public boolean isEmpty(){
    return size() == 0;
    }
    public String set(int index,String element){
       if (index < 0 || index >= size()){
        throw new IndexOutOfBoundsException();
    }
       String orig = get(index);
       data[index] = element;
       return orig;
    }
    public void add(int index, String element){
       if (index < 0 || index > size()){
        throw new IndexOutOfBoundsException();
       } 
       if (size >= data.length){
       grow();
       }
       size++;
       String lastElmt = "";
       if (index < size()){
       lastElmt = get(index);
       for (int i = index+1; i < size(); i++){
        String temp = get(i);
        data[i] = lastElmt;
        lastElmt = temp;
        }
       }
       data[index] = element;
    }
    public String remove (int index){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	String orig = get(index);
	String lastElmt = "";
	if (index >= size()-1){
	    size -= 1;
	    return orig;
	}
	lastElmt = get(index+1); //doesn't matter what lastElmt is
	data[index] = lastElmt;
	for (int i = size()-1; i >= index; i--){
	    String temp = get(i);
	    data[i] = lastElmt;
	    lastElmt = temp;
	}
	size -= 1;
	return orig;
    }
    public String[] toArray(){
    String[] toReturn = new String[size()];
    for (int i = 0; i < size(); i++){
        toReturn[i] = get(i);
    }
    return toReturn;
    }
    public int indexOf(String i){
    for (int j = 0; j < size(); j++){
        if (get(j).equals(i)){
        return j;
        }
    }
    return -1;
    }
 
    public int lastIndexOf(String i){
    for (int j = size()-1; j >= 0; j--){
        if (get(j).equals(i)){
        return j;
        }
    }
    return -1;
    }
     
  //1
/**add the value n to the next available slot in the superArray.
 *this will change the size. This function should always work
 *And will resize the SuperArray if needed.*/
  public boolean add(String n){
      if (size == data.length){
      grow();
      }
      data[size] = n;
      size++;
      return true;
  }
 
  //2
/**Resize the data, by making a new array, then copying over elements, use this as your data.
*/
 
  private void grow(){
      String[] temp = new String[data.length*2+1];
      for (int i = 0; i < data.length; i++){
	  temp[i] = data[i];
      }
      data = temp;
  }
    public void trimToSize(){
	String[] temp = new String[size];
	for (int i = 0; i < size; i++){
	    temp[i] = data[i];
	}
	data = temp;
    }
  //3
   /**format the super array like this :   [ 1, 3, 6, 8, 23, 99, -4, 5] 
    *commas between... square bracket start/end and no comma at end.*/
  public String toString(){
      String total = "[";
      for (int i = 0; i < size; i++){
	  total += " " + data[i];
	  if (i < size-1){
	      total += ",";
	  }
      }
      total += "]";
      return total;
  }
 
  //4
    /**format the super array like this :   [ 1, 8, 23, 99, -4, 5, _, _, _, _]   
    *(capacity is 10, but only 6 are used)
    *commas between... square bracket start/end and no comma at end.
    *unused slots should be printed as _ (underscores) */
  public String toStringDebug(){
      String s = toString();
      s = s.substring(0, s.length()-1);
      if (size == 0){
	  s += "_";
      }
      for (int i = size; i < data.length; i++){
	  s += ", _";
      }
      s += "]";
      return s;
  }

    public Iterator<String> iterator(){
	return new SuperArrayIterator(this);
    }
    public class SuperArrayIterator implements Iterator<String>{
	    SuperArray arr = null;
	    int index;
	    public SuperArrayIterator(SuperArray sa){
		arr = sa;
		index = 0;
	    }
	    public boolean hasNext(){
		return index < arr.size();
	    }
	    public String next(){
		index++;
		return arr.get(index-1);
	    }
	    public void remove(){
		throw new UnsupportedOperationException();
	    }
    }
}
