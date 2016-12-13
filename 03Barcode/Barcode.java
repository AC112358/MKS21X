public class Barcode implements Comparable<Barcode>{
// instance variables
   private String _zip;
 private static String[] codes = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:",
			    ":||::", "|:::|", "|::|:", "|:|::"};
// constructors
//precondtion: _zip.length() = 5 and zip contains only digits.
//postcondition: throws a runtime exception zip is not the correct length
//               or zip contains a non digit
//               _zip and _checkDigit are initialized.
  public Barcode(String zip) {
      if (zip.length() != 5){
	  throw new IllegalArgumentException("Zip code must be length 5");
      }
      for (int i = 0; i < zip.length(); i++){
	  if ("0123456789".indexOf(zip.charAt(i)) < 0){
	      throw new IllegalArgumentException("Zip code must only contain digits: " + zip.charAt(i));
      }
      }
  _zip = zip;
}


// postcondition: computes and returns the check sum for _zip
  private int checkSum(){
      int sum = 0;
      for (int i = 0; i < _zip.length(); i++){
	  sum += _zip.charAt(i) - '0';
      }
      sum %= 10;
      return sum;
}

//postcondition: format zip + check digit + Barcode 
//ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
  public String toString(){
      String total = "|";

      for (int i = 0; i < _zip.length(); i++){
	  total += codes[_zip.charAt(i) - '0'];
      }
      total += codes[checkSum()];
      return "" + _zip + checkSum() + " " + total + "|";
}


// postcondition: compares the zip + checkdigit, in numerical order. 
public int compareTo(Barcode other){
    return (_zip + checkSum()).compareTo(other._zip+other.checkSum());
}


    public static String toCode(String zip){
	Barcode b = new Barcode(zip);
	return b.toString().substring(7);
    }

    public static String toZip(String barcode){
	final int ZIP_DIGS = 6;
	if (barcode.length() != ZIP_DIGS*5 + 2){
	    throw new IllegalArgumentException("Barcode must be " + (ZIP_DIGS*5 + 2) + " characters long");
	}
	if (barcode.charAt(0) != '|' || barcode.charAt(barcode.length()-1) != '|'){
	    throw new IllegalArgumentException("Barcode must begin & end with '|'");
	}
	barcode = barcode.substring(1, barcode.length()-1);
	String zipcode = "";
	int totalSum = 0;
	for (int i = 0; i < ZIP_DIGS; i++){
	    String total = "";
	    for (int j = 0; j < 5; j++){
		char c = barcode.charAt(i*5 + j);
		if (c != '|' && c != ':'){
		    throw new IllegalArgumentException("Barcode can only contain '|' or ':'");
		}
		total = total + c;
	    }
	    int temp = searchCodes(total);
	    if (temp == -1){
		throw new IllegalArgumentException("A portion of barcode doesn't translate to a digit: " + total);
	    }
	    zipcode = zipcode + temp;
	    totalSum += temp;
	}
	int checkSum = zipcode.charAt(zipcode.length()-1) - '0';
	if (checkSum != (totalSum - checkSum)%10){ //if checkSum > totalSum, zip code cannot be valid so % 10 is fine
	    throw new IllegalArgumentException("Check digit invalid: " + checkSum);
	}
	return zipcode.substring(0, zipcode.length()-1);
    }

    private static int searchCodes(String toFind){
	for (int i = 0; i < codes.length; i++){
	    if (codes[i].equals(toFind)){
		return i;
	    }
	}
	return -1;
    }
}
