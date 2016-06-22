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
public enum TipoEscolaridadeEnum{
	
    ANALFABETO("Analfabeto"),
    MEDIO("Ensino médio"),
    SUPERIOR("Ensino superior");

    private String preso;

    private TipoEscolaridadeEnum(String preso) {
        this.preso = preso;
    }

    public String getPreso() {
            return preso;
    }
	
    public static TipoEscolaridadeEnum getBy(char tipo){
        switch (tipo){
            case '1':
                return ANALFABETO;
            case '2':
                return MEDIO;
            case '3':
                return SUPERIOR;
        }
        return null;
    }
    public static String getBy(TipoEscolaridadeEnum tipo){
        switch (tipo){
            case ANALFABETO:
                return "1";
            case MEDIO:
                return "2";
            case SUPERIOR:
                return "3";
        }
        return null;
    }
}