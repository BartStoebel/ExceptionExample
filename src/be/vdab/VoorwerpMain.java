package be.vdab;


import be.vdab.exceptions.ISBN13Exception;
import be.vdab.voorwerpen.Boekenrek;
import be.vdab.voorwerpen.Leesboek;
import be.vdab.voorwerpen.Woordenboek;
import be.vdab.util.Voorwerp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vinnie
 */
public class VoorwerpMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Voorwerp[] voorwerp = new Voorwerp[5];
        voorwerp[0] = new Boekenrek(7, 2, 10F);
        voorwerp[1] = new Boekenrek(5, 5, 5F);
        try{
            voorwerp[2] = new Leesboek("Angst", "auteur1", 15.5F, "Psychologie", "978-0306-40615-7", "geen onderwerp");
            //voorwerp[4] = new Woordenboek("Van Daele", "Vele auteurs", 10F, "informatief", "978-0306-40610-7", "Nederlands");
            
        } catch (ISBN13Exception ex){
            System.out.println(ex.getISBN13() + ": " + ex.getMessage());
        }
        try{
           voorwerp[3] = new Leesboek("Angst2", "ik niet", 10.3F, "genre", "978-0306-4061e-7", "onderwerp");
        } catch (ISBN13Exception ex){
            System.out.println(ex.getISBN13() + ": " + ex.getMessage());
        }
        try{
            //voorwerp[2] = new Leesboek("Angst", "auteur1", 15.5F, "Psychologie", "978-0306-40615-7", "geen onderwerp");
            voorwerp[4] = new Woordenboek("Van Daele", "Vele auteurs", 10F, "informatief", "978-0306-40610-7", "Nederlands");
            
        } catch (ISBN13Exception ex){
            System.out.println(ex.getISBN13() + ": " + ex.getMessage());
        }
        
        
        
        float winst = 0;
        for (Voorwerp v : voorwerp){
            if( v!=null){
                v.gegevensTonen();
                winst += v.winstBerekenen();
            }
        }
        System.out.println("\nDe totale winst bedraagt: " + winst);
    }
    
}
