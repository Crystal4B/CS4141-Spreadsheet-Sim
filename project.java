//Authors: Marcin Sek - 18254187
//         Jelizaveta Lapteva - 18229115
//         Jamie Doupe - 18233112
//         James Cusack - 18250416
public class project{
    private String[] words;
    private int nextPosition = 0;
    public project(){
        words = new String[256];
        //runs the add function three times
        for(int i = 0; i < 3; i++){
            add();
        }
    }
    public boolean add(){
        //if operation is successful adds a sheet and adds 1 to next position
        //and sheet number for future sheets generated, and returns true
        //if operation fails it returns false
        if(nextPosition < words.length){
            words[nextPosition] = new String("Sheet" + findSheetNumber());
            nextPosition++;
			return true;
        }
        return false;
    }
    public int rename(String currentName, String newName){
		//renames string given its current name and new name
		//if index(newName) returns -1 newName is available
		//if the new name is already in use rename returns -1
		if(index(newName) == -1){
			int i = index(currentName);
			words[i] = newName;
			return i;
        }
        return -1;
    }
    public int index(String sheetName){
        //finds index of a string given its contents
        //if string doesnt exist returns -1
        for(int i = 0; i < nextPosition; i++){
            if(words[i].compareToIgnoreCase(sheetName) == 0) {
                return i;
            }
        }
        return -1;
    }
    public String sheetName(int index){
        //returns string given its index
        //if string is empty or index is over the limit returns null
        if(index > length()){
            return null;
        }
        return words[index];
    }
    public String remove(int index){
		//removes string given its index and takes 1 away from nextPosition
		//if successful returns removed word, if failure returns null
        String returnValue = words[index];
		if(index < length()){
			if(length() == 256){
				//if the all slots in the array are full function takes 1 away from length skiping the final entry
				//so it doesnt attempt to get the name of a string that would 
				while(index < length()-1){
					//renames string to next word on the list, doesnt rename the last string
					words[index] = words[index+1];
					index++;
				}
				//string 256 gets renamed here to null as there should be a copy of it instead of 255
				words[256] = null;
			} else {
				while(index < length()){
					//renames string to next word on the list, last string gets renamed to null
					words[index] = words[index+1];
					index++;
				}	
			}
			//nextPosition-- as there is now one less string in the array
			nextPosition--;
			return returnValue;
		}
        return null;
    }
    public int remove(String sheetName){
		//removes string given its contents and takes 1 away from nextPosition
		//if successful returns index of string removed if it fails it returns -1
		//if index returns != -1 then the string exists
		if(index(sheetName) != -1){
			//finds the index of the string and calls upon remove(int index) to remove the String
			int i = index(sheetName);
			int returnvalue = i;
			remove(i);
			return returnvalue;
		}
        return -1;
    }
    public int move(String from, String to, boolean before){
		//moves string from one index to another given the contents of the strings
		//if from = to, String from is empty, or string to is empty the operation returns null
		//if successful retuns the index of the position the string was moved to
		if(from == to || index(from) == -1 || index(to) == -1){
			return -1;
		}
		int index = index(to);
		int length = length();
		String temp = from;
		//remove: moves all the strings down to fill the gap created
		remove(from);
		//nextPosition++ to counter act remove nextPostion--
		nextPosition++;
		if(before == true){
			//if true move sheet before "to"
			index = index-1;
			if(index < length){
				//moves all the strings from length down until it reaches index
				while(index < length){
					words[length] = words[length-1];
					length--;
				}
			}
			words[index] = temp;
		} else {
			//if false move sheet after "to"
			if(index < length){
				//moves all the strings from length down until it reaches index
				while(index < length){
					words[length] = words[length-1];
					length--;
				}
			}
			words[index] = temp;
		}
		return index;
    }
    public String move(int from, int to, boolean before){
        //moves string from one index to another given the index of the string
        //if from = to, String from is empty, or string to is empty the operation returns null
        //if succesful returns the name of the from sheet
        if(from == to || sheetName(from) == null || sheetName(to) == null){
            return null;
        }
        //code gets sheetNames and inputs them into move(string from, string to, boolean before)
        String from1 = sheetName(from);
        String to1 = sheetName(to);
        move(from1, to1, before);
        return from1;
    }
    public int moveToEnd(String from){
        //moves string to the end by deleting it
		//and adding it at the end of the list
		//given its Name
        if(nextPosition < words.length){
            words[nextPosition] = new String(from);
            nextPosition++;
        }
        for(int i = 0; i < nextPosition; i++){
            if(words[i].compareToIgnoreCase(from) == 0){
                remove(i);
                return nextPosition-1;
            }
        }
        return -1;
    }
    public String moveToEnd(int index){
		//moves string to the end by deleting it and adding it back onto the end
        //and then moves all the strings down to fill the gap created
		//given its index
		String returnValue = words[index];
        if(nextPosition < words.length){
            words[nextPosition] = new String (words[index]);
            nextPosition++;
			remove(index);
			return returnValue;
        }
        return null;
    }
    public int length(){
		//calculates the length of the array
		//by counting the amount of strings that are not null
        int count = 0;
        for(int i = 0; i < words.length; i++){
            if(words[i] != null){
                count++;
            }
        }
        return count;
    }
    public int findSheetNumber(){
        //tests for the next sheetNumber required for the array
        int a = 0;
        //loop checks every word in the array
        for(int i = 0; i<length(); i++){
            String sheetName = words[i];
            if(sheetName.contains("Sheet")){
                //splits string from t into 2 parts, part 1 contains the number
                //part0 contains the word shee splits makes t not appear in either part
                String[] parts = sheetName.split("t");
                	String part0 = parts[0];
                	String part1;
	        if(part0.equals("Shee")){
	            //if part0 is = to Shee part1 becomes the rest of the string
	            part1 = parts[1];
	            for(int c = 0; c < part1.length(); c++){
	                //tests if the right side of t is just a number
	                if(Character.isLetter(part1.charAt(c))){
	                    //if part1 also contains a letter its value gets changed
	                    // to 0
	                    part1 = "0";
	                }
	            }
	        } else{
	            //if part0 isnt "Shee" that means the string was renamed
	            //so part1 becomes 0
	            part1 = "0";
	        }
	        //converts to intiger
	        int b = Integer.parseInt(part1);
	        if(a<b){
	            //if b (sheetNumber of sheet check) is greater then a it
	            //it becomes the next a for the test
	            a = b;
	        }
            }
        }
        //returns a+1, a should be the largest sheetNumber in the array + 1 for
        //for the next sheet made
        return a+1;
    }
    public void display(){
	//prints list of strings on the screen
        for(int i = 0 ; i < nextPosition ; i++){
            System.out.println(words[i]);
        }
    }
}