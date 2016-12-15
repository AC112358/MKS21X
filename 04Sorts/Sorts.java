
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
	  //	  System.out.println(data[mindex] + " switch with " + data[index]);
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
	    temp = data[index-1];
	    for (int i = index; i > 0; i--){
		found = false;
		if (data[i] < data[index] && !found){
		    data[i] = data[index];
		   
		}else if (!found){
		    temp2 = data[i];
		    data[i] = temp;
		    temp = temp2;
		}
	    }
	    printArray(data);
		index++;
	}
    }

    public static void printArray(int[] array){
	for (int i : array){
	    System.out.print(i + " ");
	}
	System.out.println();
    }
}
