//Authors: Marcin Sek - 18254187
//         Jelizaveta Lapteva - 18229115
//         Jamie Doupe - 18233112
//         James Cusack - 18250416
public class driver {
    public static void main(String[] args) {
        // Create an instance of the Sheets class
        project myWorkBook = new project();
        System.out.println("Sheets list instance created for 8 items.");
        System.out.println("Current contents...");
        myWorkBook.display();
        System.out.println("Adding 8 items...");
        
        for(int i = 0; i < 8; i++) {
            if(myWorkBook.add()) { // Alternatively,    if(myWorkBook.add() == true) {
                System.out.println("Successful add...");
            } else {
                System.out.println("Unsuccessful add...");
            }
        }
        
        if(myWorkBook.length() == 11) {
            System.out.println(".length operation successful");
        } else { 
            System.out.println(".length operation unsuccessful");
        }
        
        myWorkBook.rename("Sheet1", "mynameis");
        
        if (myWorkBook.sheetName(0) == "mynameis") {
            System.out.println(".rename successful"); 
        } else {
            System.out.println(".rename unsuccessful"); 
        }
                
        myWorkBook.rename("Sheet2", "what?");
        
        myWorkBook.rename("Sheet3", "mynameisJohn");
        
        myWorkBook.rename("Sheet4", "helloJohn");
        
        myWorkBook.rename("sheet5", "mynameisJane");
        
        if (myWorkBook.index("what?")== 1) {
            System.out.println(".index operation successful"); 
        } else {
            System.out.println(".index operation unsuccessful"); 
        }
        
        if (myWorkBook.sheetName(1)== "what?") {
            System.out.println(".sheetName successful");
        } else {
            System.out.println(".sheetName unsuccessful");
        }
        
        myWorkBook.remove("mynameis"); 
        
        if (myWorkBook.index("mynameis")== -1) {
            System.out.println(".remove by sheetname operation successful");
        } else {
            System.out.println(".remove by sheetname operation unsuccessful");
        }
         
        myWorkBook.remove(0);
        
        if (myWorkBook.index("what?")== -1) {
            System.out.println(".remove by index operation successful"); 
        } else {
            System.out.println(".remove by index operation unsuccessful");
        }
        
        myWorkBook.move(0, 2 ,true);
        if (myWorkBook.index("mynameisJohn") == 1) {
            System.out.println(".move before by index operation successful");
        } else { 
            System.out.println(".move before by index operation unsuccessful");
        }
        
        myWorkBook.move(0, 2, false);
        if (myWorkBook.index("helloJohn") == 2) {
            System.out.println(".move after by index operation successful");
        } else {
            System.out.println(".move after by index operation unsuccessful");
        }
        
        myWorkBook.move("mynameisJohn", "heLLoJohn",true); 
        if (myWorkBook.index("mynameisJohn") == 1) {
            System.out.println(".move before by sheetname operation successful");
        } else {
            System.out.println(".move before by sheetname operation successful");
        }
          
        myWorkBook.move("mynameisJane", "HelloJohn", false);
        if (myWorkBook.index("mynameisJane") == 2) {
            System.out.println(".move after by sheetname operation successful");
        } else {
            System.out.println(".move after by sheetname operation unsuccessful");
        }
        
        myWorkBook.moveToEnd("HelloJohn");
        if (myWorkBook.index("HelloJohn") == 8) {
            System.out.println(".moveToEnd by sheetname operation successful");
        } else {
            System.out.println(".moveToEnd by sheetname operation unsuccessful");
        }
        
        myWorkBook.moveToEnd(0);
        if (myWorkBook.index("mynameisJohn") == 8) {
            System.out.println(".moveToEnd by index operation successful");
        } else {
            System.out.println(".moveToEnd by index operation unsuccessful");
        }
        System.out.println("Current contents...");
        myWorkBook.display();
        
        // Create another instance of the Sheets class
        project anotherWorkBook = new project(); // using default constructor for 256 items
        System.out.println("Sheets list instance created for 256 items.");
        System.out.println("Current contents...");
        anotherWorkBook.display();
        System.out.println("Adding 22 items...");
        for(int i = 0; i < 22; i++) {
            if(anotherWorkBook.add()) { // Alternatively,    if(anotherWorkBook.add() == true) {
                System.out.println("Successful add...");
            } else {
                System.out.println("Unsuccessful add...");
            }
        }        
        
        System.out.println("Current contents...");
        anotherWorkBook.display();
    }
}