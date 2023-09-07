/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ds_day01teammembers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author mysel
 */
public class DS_Day01TeamMembers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

         String filePath = "teams.txt";

         //Create HashMap To store all players by team
        HashMap<String, ArrayList<String>> teamAndPlayers = new HashMap<>();
        
        //Read from file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                //System.out.println(line);
                // Split the data by colon to get Team
                String[] parts = line.split(":");
                String teamName = parts[0];
                // Split the data by comma to get Player
                String[] playersArray = parts[1].split(",");
                                
                for (String player : playersArray){
                    //teamAndPlayers.put(player, allLinePlayers);
                    
                    //Verify is player exists.  If not add
                    if (teamAndPlayers.containsKey(player)){
                        ArrayList<String> teams = teamAndPlayers.get(player);
                        teams.add(teamName);
                        teamAndPlayers.put(player, teams);
                    } else {//Add team to existing value of player.
                        ArrayList<String> teams = new ArrayList<>();
                        teams.add(teamName);
                       teamAndPlayers.put(player, teams);
                    }                    
                }
                
                 //How to put data
                        //.put(key, value) for one item.
                        //.put(Map...) to put multiple data in Map
                        //.putIifNotEmpty(key, value), put data if not exists
                 //How to delete data
                        //.clear() to delete all
                        //.remove(key) to delete one by key
                 //How to get data
                        //Verify .contains(key)
                        //get .get(key)
                 //How to loop data
                
                
            }
            
        } catch (IOException e) {
            // Handle any IOException that may occur (e.g., file not found)
            System.err.println("An error occurred while reading the file: " + e.getMessage());
            e.printStackTrace();
        }
        
        //Display all players info
        for (Map.Entry<String, ArrayList<String>> entry : teamAndPlayers.entrySet()) {
                System.out.println(entry.getKey() + " plays in: " + String.join(",", entry.getValue()));
        }

    }

}
