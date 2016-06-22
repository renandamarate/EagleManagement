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
public enum TipoNaturalidadeEnum{
	
    CURITIBA("Curitiba"),
    SAOPAULO("São Paulo"),
    OUTROS("Outros");

    private String preso;

    private TipoNaturalidadeEnum(String preso) {
        this.preso = preso;
    }

    public String getPreso() {
            return preso;
    }
	
    public static TipoNaturalidadeEnum getBy(char tipo){
        switch (tipo){
            case 'C':
                return CURITIBA;
            case 'S':
                return SAOPAULO;
            case 'O':
                return OUTROS;
        }
        return null;
    }
    public static String getBy(TipoNaturalidadeEnum tipo){
        switch (tipo){
            case CURITIBA:
                return "C";
            case SAOPAULO:
                return "S";
            case OUTROS:
                return "O";
        }
        return null;
    }
}