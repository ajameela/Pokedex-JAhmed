package code;
import java.io.IOException;
import java.util.Scanner;

public class PokedexApp {
	
	public static ChainingHashTable<String, Pokemon> pokedex = new ChainingHashTable<>(11);
	
    public static void main(String[] args) {
    	
        
        String filename = args.length == 0 ? "pokemon.csv" : args[0];
        try {
            int loaded = PokemonLoader.load(filename, pokedex);
            System.out.println("Loaded " + loaded + " Pokemon records.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Could not load CSV: " + e.getMessage());
            System.out.println("Put pokemon.csv in the project root (working directory).");
            return;
        }
        
        //Check 1 - for step 9 in the 1st step (step 9 also extra credit)
        Pokemon first = new Pokemon (25, "PIKACHU", 4, 60, 112);
        Pokemon second = new Pokemon (25, "PIKACHU", 4, 60, 112);

        System.out.println("Check quality" + first.equals(second));

        Scanner input = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("\n1. Search\n2. Add/update\n3. Remove\n4. Show buckets\n0. Exit");
            System.out.print("Choice: ");
            String choice = input.nextLine().trim();
            switch (choice) {
                case "1": searchPokemon(input); break;
                case "2": addOrUpdatePokemon(input); break;
                case "3": removePokemon(input); break;
                case "4": pokedex.printTable(); break;
                case "0": running = false; break;
                default: System.out.println("Choose 0 through 4.");
            }
        }
    }

    private static void searchPokemon(Scanner input) {
        // TODO 1: Complete this menu action. must search for pokemon
    	//			if pokemon is there then print it out.
    	// DONE/COMPLETED
    	
        System.out.println("Enter in the Pokemon you want to find: ");
        String name = input.nextLine();
        
        Pokemon pokeLookFor = pokedex.get(name);
        if(pokeLookFor != null) 
        	System.out.println(pokeLookFor);
        else
        	System.out.println("NOT FOUND IN CURRENT LIST, SORRY!");
        
    }

    private static void addOrUpdatePokemon(Scanner input) {
        // TODO 2: Complete this menu action.
    	// DONE/COMPLETE
        System.out.println("Enter in the name of the Pokemon you'd like to add: ");
        String name = input.nextLine();
        
        // boolean insert(K key, V value)
        int id = readNonNegativeInt(input,"Please enter in ID for Pokemon: ");
        
        int height = readNonNegativeInt(input, "Please enter height in decimeters: ");
               
        int weight = readNonNegativeInt(input, "Please enter weight in hectorgrams: ");
        
        int baseExperience = readNonNegativeInt(input, "Enter in the experience level: ");
        
        // When constructing, the parameters must be in the same order as the constructor!!!
        Pokemon newPokemon = new Pokemon(id, name, height, weight, baseExperience);              
        
        if(pokedex.get(name) != null)
        	// if found and does not equal null
        	// then its already in there and just needs an update.
        	System.out.println("updating pokemon now");
        else
        	System.out.println("inserting pokemon now");
        
        // if it exists already, it overrides it. 
        // if it does NOT exist it makes/creates it
        pokedex.insert(name, newPokemon);
       
    }

    private static void removePokemon(Scanner input) {
    	// When removing the pokemon this method is similar to the searchPokemon method
        // TODO 3: Complete this menu action.
    	// DONE/COMPLETED
    	System.out.println("Enter in the Pokemon you want to remove: ");
        String name = input.nextLine();
        
        Pokemon pokeRemove = pokedex.get(name);
        if(pokeRemove != null) {
        	System.out.println(name + " was found and removal!");
        	pokedex.remove(name);
        }        
        else
        	System.out.println("Sorry, " + name + " was NOT found");
        	
        	
    }

    // Provided: reads a non-negative integer using nextLine(), avoiding leftover newlines.
    private static int readNonNegativeInt(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(input.nextLine().trim());
                if (value >= 0) { return value; }
            } catch (NumberFormatException e) {
                // Explain the error and ask again.
            	System.out.println("You entered a negative number, uh oh try again: ");
            }
            System.out.println("Enter a whole number of zero or more.");
        }
    }
}
