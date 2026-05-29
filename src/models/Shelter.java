package models;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Shelter {
	private String name;
	private String number;
	private String address;
	private ArrayList<User> users;
	private ArrayList<Animal> animals;
	private ArrayList<AdoptionApplication> applications;
	
	public Shelter( String name, String number, String address){
		setName(name);
        setNumber(number);
        setAddress(address);
		this.users = new ArrayList<>();
		this.animals = new ArrayList<>();
		this.applications = new ArrayList<>();
	}


        public String getName() {
        	return name;
        }
        
        public String getNumber() {
        	return number;
        }
        
        public String getAddress() {
        	return address;
        }
        
        public ArrayList<User> getUsers() {
        	return users;
        }
        
        public ArrayList<Animal> getAnimals() {
        	return animals;
        }
        
        public ArrayList<AdoptionApplication> getApplications () {
        	return applications;
        }
        
        public void  setName(String name) {
        	if(name == null) {
        		throw new IllegalArgumentException("Το name δεν μπορεί να είναι null!"+"\n");
        	}
        	this.name = name;
        }
        
        public void  setNumber(String number) {
        	// Ελέγχεται η ορθότητα του αριθμού.
        	if(number == null || number.length() != 10) {
        		throw new IllegalArgumentException("Το number πρέπει να είναι 10 ψηφία!"+"\n");
        	}
        	for (int i=0; i<number.length(); i++) {
        	if(!Character.isDigit(number.charAt(i))) {
        		throw new IllegalArgumentException("Λανθασμένος αριθμός τηλεφώνου!"+"\n");
        	}
        	}
        	
        	this.number = number;
        }
        
        public void setAddress(String address) {
        	if(address == null) {
        		throw new IllegalArgumentException("Το address δεν μπορεί να είναι null!"+"\n");
        	}
        	this.address = address;
        }
        
           // Μέθοδος μέσω της οποίας προστίθεται καινούργιος user.
        public void addUser(User user) {
        	if (user == null) {
        		throw new IllegalArgumentException("Ο χρήστης δεν μπορεί να είναι null!"+"\n");
        	}
        	// Έλεγχος για την εγκυρότητα του τηλεφώνου και του email.
        	if(!user.getPhone().matches("\\d{10}")) {
        		throw new IllegalArgumentException("Το τηλέφωνω πρέπει να αποτελείται απο ακριβώς 10 νούμερα!"+"\n");
        	}
        	if(!user.getEmail().contains("@")) {
        		throw new IllegalArgumentException("Λανθασμένη μορφή email!"+"\n");
        	}
        	// Ελέγχεται άμα το username του νέου χρήστη υπάρχει ήδη.
        	for(int i=0; i<users.size(); i++) {
        		if(users.get(i).getUsername().equals(user.getUsername())) {
        			throw new IllegalArgumentException("Το username χρησιμοποιείται ήδη!"+"\n");
        		}
        	}
        	users.add(user);
        	System.out.println("Ο χρήστης προστέθηκε με επιτυχία."+"\n");
        }
        
        
        // Μέθοδος μέσω της οποίας επεξεργάζονται τα στοιχεία ενός χρήστη.
        public void editUser(User editedUser) {
        	if(editedUser == null) {
        		throw new IllegalArgumentException("Ο χρήστης δεν μπορεί να είναι null!"+"\n");
        	}
        // Έλεγχος για την ύπαρξη του χρήστη που θα επεξεργαστούν τα στοιχεία του.	
        	for(int i=0; i<users.size(); i++) {
        		if(users.get(i).getUsername().equals(editedUser.getUsername())) {
        			users.set(i, editedUser);
        		System.out.println("Τα στοιχεία του χρήστη"+ users.get(i).getUsername()+" επεξεργάστηκαν με επιτυχία."+"\n");	
        			return;
        		}
        	}
        		throw new IllegalArgumentException("Ο χρήστης δεν βρέθηκε!"+"\n");
        }
        // Μέθοδος μέσω της οποίας διαγράφεται ένας χρήστης.
       public void removeUser(User removedUser) {
    	   if(removedUser == null) {
    		   throw new IllegalArgumentException("Ο χρήστης δεν μπορεί να είναι null!"+"\n");
    	   }
    	 // Έλεγχος για την ύπαρξη του χρήστη που  επιθυμείται η διαγραφή του.  
    	   for(int i=0; i<users.size(); i++) {
    		   if(users.get(i).getUsername().equals(removedUser.getUsername())) {
    			   System.out.println("Ο χρήστης"+ users.get(i).getUsername()+" διεγράφη με επιτυχία."+"\n");
    			   users.remove(i);
    			   return;
    		   }
    	   }
    	   throw new IllegalArgumentException("Ο χρήστης δεν βρέθηκε!"+"\n");
    	   }
       
    // Μέθοδος μέσω της οποίας προστίθεται καινούργιο κατοικίδιο.
       public void addAnimal(Animal animal) {
       	if (animal == null) {
       		throw new IllegalArgumentException("Το κατοικίδιο δεν μπορεί να είναι null!"+"\n");
       	}
       	// Ελέγχεται άμα το ID του νέου κατοικιδίου υπάρχει ήδη.
       	for(int i=0; i<animals.size(); i++) {
       		if(animals.get(i).getId().equals(animal.getId())) {
       			throw new IllegalArgumentException("Το ID υπάρχει ήδη!"+"\n");
       		}
       	}
       	animals.add(animal);
       	System.out.println("Το κατοικίδιο προστέθηκε με επιτυχία."+"\n");
       }
       
       
       // Μέθοδος μέσω της οποίας επεξεργάζονται τα στοιχεία ενός κατοικιδίου.
       public void editAnimal(Animal editedAnimal) {
       	if(editedAnimal == null) {
       		throw new IllegalArgumentException("Το κατοικίδιο δεν μπορεί να είναι null!"+"\n");
       	}
       // Έλεγχος για την ύπαρξη του κατοικιδίου που θα επεξεργαστούν τα στοιχεία του.	
       	for(int i=0; i<animals.size(); i++) {
       		if(animals.get(i).getId().equals(editedAnimal.getId())) {
       			animals.set(i, editedAnimal);
       		System.out.println("Τα στοιχεία του κατοικιδίου"+ animals.get(i).getId()+" επεξεργάστηκαν με επιτυχία."+"\n");	
       			return;
       		}
       	}
       		throw new IllegalArgumentException("Το κατοικίδιο δεν βρέθηκε!"+"\n");
       }
       // Μέθοδος μέσω της οποίας διαγράφεται ένα κατοικίδιο.
      public void removeAnimal(Animal removedAnimal) {
   	   if(removedAnimal == null) {
   		   throw new IllegalArgumentException("Το κατοικίδιο δεν μπορεί να είναι null!"+"\n");
   	   }
   	 // Έλεγχος για την ύπαρξη του κατοικιδίου που  επιθυμείται η διαγραφή του.  
   	   for(int i=0; i<animals.size(); i++) {
   		   if(animals.get(i).getId().equals(removedAnimal.getId())) {
   			   System.out.println("Το κατοικίδιο"+ animals.get(i).getId()+" διαγράφη με επιτυχία."+"\n");
   			   animals.remove(i);
   			   return;
   		   }
   	   }
   	   throw new IllegalArgumentException("Το κατοικίδιο δεν βρέθηκε!"+"\n");
   	   }
      
      // Μέθοδος μέσω της οποίας εγκρίνεται μια αίτηση.
      public void approveApplication(AdoptionApplication application) {
    	  if(application == null) {
    		  throw new IllegalArgumentException("Η αίτηση δεν μπορεί να είναι null"+"\n");
    	  }
    	  for(int i=0; i<applications.size(); i++) {
    		  //Έλεγχος για την ύπαρξη της αίτησης.
    		  if(applications.get(i).getAdopter().getUsername().equals(application.getAdopter().getUsername()) &&
    			applications.get(i).getAnimal().getId().equals(application.getAnimal().getId())) {
    		  //Έλεγχος για το αν η αίτηση έχει ήδη εξεταστεί.  
    			  if(applications.get(i).getStatus() != ApplicationStatus.PENDING) {
    				  throw new IllegalArgumentException("Η αίτηση έχει ήδη εξεταστεί"+"\n");
    			  }
    				  else {
    					  applications.get(i).setStatus(ApplicationStatus.APPROVED);
    					  System.out.println("Η αίτηση εγκρίθηκε"+\"n");
    					  // Αυτόματη απόρριψη όλων των υπόλοιπων αιτήσεων για το ίδιο κατοικίδιο.
    					  String animlaId = applications.get(i).getAnimal().getId();
    					  for (int j =0; j <applications.size(); j++) {
    						  if (applications.get(j).getAnimal().getId().equals(animalId) &&
    						      applications.get(j).getStatus() == ApplicationStatus.PENDING) {
    							  applications.get(j).setStatus(ApplicationStatus.REJECTED);
    						  }
    					  }
    					  return;
    				  }
    			  
    		  }
    			 
    		  }
    			throw new IllegalArgumentException("Η αίτηση δεν υπάρχει!"+"\n");
    		  }
      
   // Μέθοδος μέσω της οποίας απορρίπτεται μια αίτηση.
      public void rejectApplication(AdoptionApplication application) {
    	  if(application == null) {
    		  throw new IllegalArgumentException("Η αίτηση δεν μπορεί να είναι null"+"\n");
    	  }
    	  for(int i=0; i<applications.size(); i++) {
    		  //Έλεγχος για την ύπαρξη της αίτησης.
    		  if(applications.get(i).getAdopter().getUsername().equals(application.getAdopter().getUsername()) &&
    			applications.get(i).getAnimal().getId().equals(application.getAnimal().getId())) {
    		  //Έλεγχος για το αν η αίτηση έχει ήδη εξεταστεί.  
    			  if(applications.get(i).getStatus() != ApplicationStatus.PENDING) {
    				  throw new IllegalArgumentException("Η αίτηση έχει ήδη εξεταστεί"+"\n");
    			  }
    				  else {
    					  applications.get(i).setStatus(ApplicationStatus.REJECTED);
    					  System.out.println("Η αίτηση αππορίφθηκε."+"\n");
    				  return;
    				  }
    			  
    		  }
    			 
    	  }
    			throw new IllegalArgumentException("Η αίτηση δεν υπάρχει!"+"\n");
      }
      
     // Μέθοδος μέσω της οποίας προστίθεται μια καινούργια αίτηση.
      public void addApplication(AdoptionApplication application) {
    	  if(application == null) {
    		  throw new IllegalArgumentException("Η αίτηση δεν μπορεί να ειναι null"+"\n");
    	  }
    //Έλεγχος για το αν ο χρήστης έχει υποβάλει ήδη αίτηση. 
    	  for(int i=0; i<applications.size(); i++) {
    		  if(applications.get(i).getAdopter().getUsername().equals(application.getAdopter().getUsername())) {
    			  throw new IllegalArgumentException("Ο χρήστης έχει υποβάλει ήδη αίτηση!");
    		  }
    	  }
    	  applications.add(application);
    	  System.out.println("Η αίτηση καταχωρήθηκε με επιτυχία"+"\n");
      }
      public void saveData() {
      FileOutputStream fileOut = null;
      ObjectOutputStream out = null;
      
      try {
    	// Αποθήκευση χρηστών σε αρχείο.
    	  fileOut = new FileOutputStream("users.ser");
    	  out = new ObjectOutputStream(fileOut);
    	  out.writeObject(users);
    	  out.close();
    	  fileOut.close();
    	
    	  // Αποθήκευση κατοικιδίων σε αρχείο.  
    	  fileOut = new FileOutputStream("animals.ser");
    	  out = new ObjectOutputStream(fileOut);
    	  out.writeObject(animals);
    	  out.close();
    	  fileOut.close();
    	  
    	// Αποθήκευση αιτήσεων σε αρχείο.
    	  fileOut = new FileOutputStream("applications.ser");
    	  out = new ObjectOutputStream(fileOut);
    	  out.writeObject(applications);
    	  out.close();
    	  fileOut.close();
    	  
    	  System.out.println("Serialized data is saved.");
      }
      catch (IOExeption e) {
    	  e.printStackTrace();
      }
      }
      
      public void loadData() {
    	FileInputStream fileIn = null;
    	ObjectInputStream in = null;
    	
    	
    	try {
    	    // Ανάκτηση χρηστών απο αρχείο.
    		fileIn = new FileInputStream("users.ser");
    		in = new ObjectInputStream(fileIn);
    		
    		users = (ArrayList<User>) in.readObject();
    		in.close();
    		fileIn.close();
    		
    		// Ανάκτηση κατοικιδίων απο αρχείο.
    		fileIn = new FileInputStream("animals.ser");
    		in = new ObjectInputStream(fileIn);
    		
    		animals = (ArrayList<Animal>) in.readObject();
    		in.close();
    		fileIn.close();
    		
    		// Ανάκτηση αιτήσεων απο αρχείο.
    		fileIn = new FileInputStream("applications.ser");
    		in = new ObjectInputStream(fileIn);
    		
    		applications = (ArrayList<AdoptionApplication>) in.readObject();
    		in.close();
    		fileIn.close();
    	}
    	catch (IOException | ClassNotFoundException e) {
    		e.printStackTrace();
    	}
      }
      public void initializeDefaultData() {
    	    if (!users.isEmpty() || !animals.isEmpty()) {
    	        return;
    	    }

    	    // Αρχικοποίηση με default δεδομένα
    	    users.add(new Adopter("user1", "pass1", "Γιάννης","Παπαδόπουλος","6946293540","john@gmail.com"));
    	    users.add(new Adopter("user2", "pass2", "Μαρία", "Κουφού","6983627453","markou@gmail.com")); 
    	    users.add(new Adopter("user3", "pass3", "Νίκος","Πλέυρης","6906389894","nick@gmail.com"));
    	    users.add(new Adopter("user4", "pass4", "Ελένη","Εμίρη" ,"6982534193","el@gmail.com"));
    	    users.add(new Adopter("user5", "pass5", "Πέτρος","Μάνταλος","6945437829","petran@gmail.com")); 
    	    users.add(new Adopter("user6", "pass6", "Γεωργία","Ράπτη","6973249056","georg@gmail.com)")); 

    	    
    	        animals.add(new Animal("A01", "Rex", AnimalType.DOG, 3, "Φιλικό"));
    	        animals.add(new Animal("A02", "Luna", AnimalType.CAT, 2, "Ήρεμο"));
    	        animals.add(new Animal("A03", "Max", AnimalType.DOG, 5, "Γεμάτο ενέργεια"));
    	        animals.add(new Animal("A04", "Bella", AnimalType.CAT, 1, "Αξιαγάπητο"));
    	        animals.add(new Animal("A05", "Charlie", AnimalType.DOG, 4, "Λατρεύει τις βόλτες"));
    	        animals.add(new Animal("A06", "Lucy", AnimalType.CAT, 6, "Φιλελεύθερο"));
    	        animals.add(new Animal("A07", "Cooper", AnimalType.DOG, 2, "Κατάληλο για παιδιά"));
    	        animals.add(new Animal("A08", "Milo", AnimalType.CAT, 3, "Πιστό"));
    	        animals.add(new Animal("A09", "Rocky", AnimalType.DOG, 7, "Ήρεμο ηλικιωμένο"));
    	        animals.add(new Animal("A10", "Daisy", AnimalType.DOG, 1, "Λατρεύει τα παιχνίδια"));
    	        animals.add(new Animal("A11", "Simba", AnimalType.CAT, 2, "Έξυπνο"));

    	       
    	    }

    	    
    	}
    		
    	
      
    	  
    	  
    	  
    	  
      
      
    	  
       
       
       
        
        
    
