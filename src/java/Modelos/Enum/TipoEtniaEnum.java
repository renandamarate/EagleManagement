/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.Enum;

/**
 *
 * @author Damarate
 */
public enum TipoEtniaEnum{
	
    BRANCO("Branco"),
    NEGRO("Negro"),
    PARDO("Pardo");

    private String preso;

    private TipoEtniaEnum(String preso) {
        this.preso = preso;
    }

    public String getPreso() {
            return preso;
    }
	
    public static TipoEtniaEnum getBy(char tipo){
        switch (tipo){
            case 'B':
                return BRANCO;
            case 'N':
                return NEGRO;
            case 'P':
                return PARDO;
        }
        return null;
    }
    public static String getBy(TipoEtniaEnum tipo){
        switch (tipo){
            case BRANCO:
                return "B";
            case NEGRO:
                return "N";
            case PARDO:
                return "P";
        }
        return null;
    }
}