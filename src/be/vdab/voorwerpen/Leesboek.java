package be.vdab.voorwerpen;

import be.vdab.exceptions.ISBN13Exception;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vinnie
 */
public class Leesboek extends Boek{
    
    private String onderwerp;
    private float winstmarge;
    
    public Leesboek(String titel, String auteur, float aankoopPrijs, 
            String genre, String ISBN13, String onderwerp) throws ISBN13Exception{
        super(titel, auteur, aankoopPrijs, genre, ISBN13) ;
        setOnderwerp(onderwerp);
        setWinstmarge(super.getAankoopPrijs());
    }
    
    @Override
    public String toString(){
        return super.toString()+ ", " + getOnderwerp() + ", " + getWinstmarge();
    }

    /**
     * @return the onderwerp
     */
    public String getOnderwerp() {
        return onderwerp;
    }

    /**
     * @param onderwerp the onderwerp to set
     */
    public final void setOnderwerp(String onderwerp) {
        if(onderwerp!=null && !onderwerp.isEmpty()){
            this.onderwerp = onderwerp;
        }
    }

    /**
     * @return the winstmarge
     */
    public float getWinstmarge() {
        return winstmarge;
    }

    /**
     * @param aankoopPrijs calculates winstmarge to set
     * this.winstmarge = aankoopPrijs * 1.5F
     */
    public final void setWinstmarge(float aankoopPrijs) {
        if (aankoopPrijs>0){
            this.winstmarge = aankoopPrijs *1.5F;
        }
    }

    @Override
    public float winstBerekenen() {
        return getWinstmarge();
    }
    @Override
    public void gegevensTonen() {
        System.out.println(toString());
    }
}
