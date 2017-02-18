package be.vdab.voorwerpen;


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
public class Boekenrek implements Voorwerp{
    
    private String eigenaar;
    private int hoogte;
    private int breedte;
    private float aankoopPrijs;
    private float winstMarge;   

    public Boekenrek(int hoogte, int breedte, float aankoopPrijs){
        setEigenaar("VDAB");
        setHoogte(hoogte);
        setBreedte(breedte);
        setAankoopPrijs(aankoopPrijs);
        
    }
    
    @Override
    public String toString(){
        return getEigenaar() + ", " + getHoogte() + ", " + getBreedte() + ", " 
                + getAankoopPrijs() + ", " + getWinstMarge();
    }
    
    @Override
    public void gegevensTonen() {
        System.out.println(toString());
    }

    @Override
    public float winstBerekenen() {
        return getWinstMarge();
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
    public void setEigenaar(String eigenaar) {
        if (eigenaar !=null && !eigenaar.isEmpty()){
            this.eigenaar = eigenaar;
        }
    }

    /**
     * @return the hoogte
     */
    public int getHoogte() {
        return hoogte;
    }

    /**
     * @param hoogte the hoogte to set
     */
    public void setHoogte(int hoogte) {
        if (hoogte>0){
            this.hoogte = hoogte;
        }
    }

    /**
     * @return the breedte
     */
    public int getBreedte() {
        return breedte;
    }

    /**
     * @param breedte the breedte to set
     */
    public void setBreedte(int breedte) {
        if(breedte > 0){
            this.breedte = breedte;
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
     * this will also set the winstmarge to a new value!
     */
    public void setAankoopPrijs(float aankoopPrijs) {
        if (aankoopPrijs>0){
            this.aankoopPrijs = aankoopPrijs;
            setWinstMarge(aankoopPrijs);
        }
        
    }

    /**
     * @return the winstMarge
     */
    public float getWinstMarge() {
        return winstMarge;
    }

    /**
     * @param aankoopPrijs the winstMarge to set
     */
    public void setWinstMarge(float aankoopPrijs) {
        if(aankoopPrijs>0){
            this.winstMarge = aankoopPrijs * 2F;
        }
    }
    
}
