public class Barcode implements Comparable<Barcode>{
// instance variables
   private String _zip;
   private int _checkDigit;

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
	  throw new IllegalArgumentException("Zip code must only contain digits");
      }
      }
  _zip = zip;
  _checkDigit = checkSum();
}

// postcondition: Creates a copy of a bar code.
  public Barcode clone(){
      Barcode b = new Barcode(_zip);
      return b;
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
 String[] codes = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:",
			    ":||::", "|:::|", "|::|:", "|:|::"};
      for (int i = 0; i < _zip.length(); i++){
	  total += codes[_zip.charAt(i) - '0'];
      }
      total += codes[_checkDigit];
      return total + "|";
}


// postcondition: compares the zip + checkdigit, in numerical order. 
public int compareTo(Barcode other){
    return (_zip +  _checkDigit).compareTo(other._zip+other._checkDigit);
}
}
