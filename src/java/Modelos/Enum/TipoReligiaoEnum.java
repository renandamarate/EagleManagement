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
public enum TipoReligiaoEnum{
	
    CATOLICO("Católico"),
    EVANGELICO("Evangelico"),
    NENHUM("Nenhum"),
    OUTROS("Outros");

    private String preso;

    private TipoReligiaoEnum(String preso) {
        this.preso = preso;
    }

    public String getPreso() {
            return preso;
    }
	
    public static TipoReligiaoEnum getBy(char tipo){
        switch (tipo){
            case 'C':
                return CATOLICO;
            case 'E':
                return EVANGELICO;
            case 'N':
                return NENHUM;
            case 'O':
                return OUTROS;
        }
        return null;
    }
    public static String getBy(TipoReligiaoEnum tipo){
        switch (tipo){
            case CATOLICO:
                return "C";
            case EVANGELICO:
                return "E";
            case NENHUM:
                return "N";
            case OUTROS:
                return "O";
        }
        return null;
    }
}