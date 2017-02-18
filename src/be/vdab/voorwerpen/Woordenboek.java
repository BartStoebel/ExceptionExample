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
public class Woordenboek extends Boek{
    
    private String taal;
    private float winstmarge;
    
    public Woordenboek(String titel, String auteur, float aankoopPrijs, 
            String genre, String ISBN13, String taal) throws ISBN13Exception{
        super(titel, auteur, aankoopPrijs, genre, ISBN13);
        setTaal(taal);
        setWinstmarge(super.getAankoopPrijs());
    }
    
    /**
     *
     * @return all the fields of this class
     */
    @Override
    public String toString(){
        return super.toString() + ", " + getTaal() + ", " + getWinstmarge();
    }

    /**
     * @return the taal
     */
    public String getTaal() {
        return taal;
    }

    /**
     * @param taal the taal to set
     */
    public final void setTaal(String taal) {
        if(taal!=null && !taal.isEmpty()){
            this.taal = taal;
        }
    }

    /**
     * @return the winstmarge
     */
    public float getWinstmarge() {
        return winstmarge;
    }

    /**
     * @param aankoopPrijs to calculate the winstmarge to set
     * this.winstmarge = aankoopPrijs * 1.75F;
     */
    public final void setWinstmarge(float aankoopPrijs) {
        if (aankoopPrijs>0){
            this.winstmarge = aankoopPrijs * 1.75F;
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
