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
public enum TipoNacionalidadeEnum{
	
    BR("Brasil"),
    AR("Argentina"),
    OUTROS("Outros");

    private String preso;

    private TipoNacionalidadeEnum(String preso) {
        this.preso = preso;
    }

    public String getPreso() {
            return preso;
    }
	
    public static TipoNacionalidadeEnum getBy(char tipo){
        switch (tipo){
            case 'B':
                return BR;
            case 'A':
                return AR;
            case 'O':
                return OUTROS;
        }
        return null;
    }
    public static String getBy(TipoNacionalidadeEnum tipo){
        switch (tipo){
            case BR:
                return "B";
            case AR:
                return "A";
            case OUTROS:
                return "O";
        }
        return null;
    }
}