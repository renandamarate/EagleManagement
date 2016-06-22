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
public enum TipoRegimeEnum{
	
    ABERTO("Aberto"),
    SEMIABERTO("Semi-aberto"),
    FECHADO("Fechado");

    private String preso;

    private TipoRegimeEnum(String preso) {
        this.preso = preso;
    }

    public String getPreso() {
            return preso;
    }
	
    public static TipoRegimeEnum getBy(char tipo){
        switch (tipo){
            case 'A':
                return ABERTO;
            case 'S':
                return SEMIABERTO;
            case 'F':
                return FECHADO;
        }
        return null;
    }
    public static String getBy(TipoRegimeEnum tipoRegimeEnum){
        switch (tipoRegimeEnum){
            case ABERTO:
                return "A";
            case SEMIABERTO:
                return "S";
            case FECHADO:
                return "F";
        }
        return null;
    }
}