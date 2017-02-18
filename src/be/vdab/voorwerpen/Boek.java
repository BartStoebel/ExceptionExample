package be.vdab.voorwerpen;


import be.vdab.exceptions.ISBN13Exception;
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
public abstract class Boek implements Voorwerp{

    private String titel;
    private String auteur;
    private String eigenaar;
    private float aankoopPrijs;
    private String genre;
    private String ISBN13;
    
    public Boek(String titel, String auteur, float aankoopPrijs, String genre, 
            String ISBN13) throws ISBN13Exception{
        setTitel(titel);
        setAuteur(auteur);
        setEigenaar("VDAB");
        setAankoopPrijs(aankoopPrijs);
        setGenre(genre);
        setISBN13(ISBN13);
    }

    /**
     * checks if ISBNcode is valid:
     * discard '-' and place all other values in temp.
     * Check length = 13, where first 12 must be digits %10
     * @param ISBN13
     * @return 
     */
    private boolean checkISBN13(String ISBN13){
    if (ISBN13!=null && !ISBN13.isEmpty()){
            String temp = "";
            for(int a = 0; a<ISBN13.length(); a++){
                //check if this char is an integer
                if(ISBN13.charAt(a)!='-'){
                        temp = temp + ISBN13.charAt(a); //temp does not contain -, and only digits
                }
            }
            if (temp.length()==13){
                int rest = 0;
                int test13;
                try{
                    for (int a = 0; a<12; a+=2){
                        rest = rest + Integer.parseInt( temp.substring(a,a+1));  //maak een string van integers!!
                        rest = rest + (Integer.parseInt( temp.substring(a+1,a+2)) * 3);
                    }
                    test13 = Integer.parseInt(temp.substring(12,13));   
                    rest = rest % 10;
                    rest = 10-rest;
                    if (rest == 10){rest = 0;}
                    if (rest == test13){
                        return true;
                    } else {
                        return false;
                    }
                } catch (NumberFormatException e){
                    return false;
                } 
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public String toString(){
        return getTitel() + ", " + getAuteur()+", "+getEigenaar()+", " + 
                getAankoopPrijs()+ ", " + getGenre() + ", " + getISBN13();
    }
    
    @Override
    public abstract void gegevensTonen();

    @Override
    public abstract float winstBerekenen();

    /**
     * @return the titel
     */
    public String getTitel() {
        return titel;
    }

    /**
     * @param titel the titel to set
     */
    public final void setTitel(String titel) {
        if (titel!=null && !titel.isEmpty()){
        this.titel = titel;
        }
    }

    /**
     * @return the auteur
     */
    public String getAuteur() {
        return auteur;
    }

    /**
     * @param auteur the auteur to set
     */
    public final void setAuteur(String auteur) {
        if (auteur!=null && !auteur.isEmpty()){
        this.auteur = auteur;
        }
    }

    /**
     * @return the eigenaar
     */
    public String getEigenaar() {
        return eigenaar;
    }

    /**
     * @param eigenaar the eigenaar to set
     */
    public final void setEigenaar(String eigenaar) {
        if (eigenaar!=null && !eigenaar.isEmpty()){
        this.eigenaar = eigenaar;
        }
    }

    /**
     * @return the aankoopPrijs
     */
    public float getAankoopPrijs() {
        return aankoopPrijs;
    }

    /**
     * @param aankoopPrijs the aankoopPrijs to set
     */
    public final void setAankoopPrijs(float aankoopPrijs) {
        if (aankoopPrijs>0){
            this.aankoopPrijs = aankoopPrijs;
        }
    }

    /**
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @param genre the genre to set
     */
    public final void setGenre(String genre) {
        if (genre!=null && !genre.isEmpty()){
            this.genre = genre;
        }
    }

    /**
     * @return the ISBN13
     */
    public String getISBN13() {
        return ISBN13;
    }

    /**
     * @param ISBN13 the ISBN13 to set
     * @throws be.vdab.exceptions.ISBN13Exception
     */
    public final void setISBN13(String ISBN13) throws ISBN13Exception {
        if (checkISBN13(ISBN13)){
            this.ISBN13 = ISBN13;
        } else{
            throw new ISBN13Exception("Ongeldig ISBN nummer", ISBN13);
            
        }
    }
    
}
