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
public enum TipoAlaEnum{
	
    A1M("A-1 - Masculina"),
    A2M("A-2 - Masculina"),
    A1F("A-1 - Feminina");

    private String preso;

    private TipoAlaEnum(String preso) {
        this.preso = preso;
    }

    public String getPreso() {
            return preso;
    }
	
    public static TipoAlaEnum getBy(char tipo){
        switch (tipo){
            case '1':
                return A1M;
            case '2':
                return A2M;
            case '3':
                return A1F;
        }
        return null;
    }
    public static String getBy(TipoAlaEnum tipo){
        switch (tipo){
            case A1M:
                return "1";
            case A2M:
                return "2";
            case A1F:
                return "3";
        }
        return null;
    }
}