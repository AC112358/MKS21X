public class Sorts{
  /**EDIT THIS METHOD TO MATCH YOUR NAME 
  */
  public static String name(){
    return "10.Caplin.Ann"; 
  }

  /**Selection sort of an int array. 
  *Upon completion, the elements of the array will be in increasing order.
  *@param data  the elements to be sorted.
  */
  public static void selectionSort(int[] data){ 
      int index = 0;
      int mindex = 0;
      while (index < data.length){
      mindex = index;
      for (int j = index; j < data.length; j++){
          // System.out.println("looping thru " + j);
          if (data[mindex] > data[j]){
          // System.out.println(data[mindex] + " --> " + data[j]);
          mindex = j;
          }
      }
      //      System.out.println(data[mindex] + " switch with " + data[index]);
      int temp = data[mindex];
      data[mindex] = data[index];
      data[index] = temp;
      //  printArray(data);
      index++;
      }
 }

    public static void insertionSort(int[] data){
    int index = 1;
    int temp = 0;
    int temp2 = 0;
    boolean found = false;
    while (index < data.length){
        temp = data[index];
	System.out.println(temp);
	found = false;
        for (int i = index; i > 0; i--){
	    if (data[i] < temp && !found && i < data.length - 1){
		//	System.out.println("Inserting " + temp + " at " + (i+1));
		data[i+1] = temp;
		found = true;
	    }else if (!found){	
		data[i] = data[i-1];
		//	System.out.println("set " + data[i+1] + " to " + data[i]);
		printArray(data);
	    }
        }
	if (!found){
	    data[0] = temp;
	    // System.out.println("put " + temp + " at front");
	}
	//	System.out.println("k done");
        printArray(data);
	System.out.println();
        index++;
    }
    }

    public static void bubbleSort(int[] data){
	int temp = 0;
	boolean done = true;
	for ( int i = 0; i < data.length; i++){
	    done = true;
	    for (int j = 1; j < data.length - i; j++){
		if (data[j] < data[j-1]){
		    temp = data[j-1];
		    data[j-1] = data[j];
		    data[j] = temp;
		    done = false;
		}
	    }
	    if (done){
		return;
	    }
	}
    }

    public static void printArray(int[] array){
    for (int i : array){
        System.out.print(i + " ");
    }
    System.out.println();
    }

}
