/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Modelos.Enum.TipoAlaEnum;
import java.util.List;

/**
 *
 * @author Damarate
 */
public class Cela {
    private int id;
    private String código;
    private Presidio presidio;
    private int capacidade;
    private TipoAlaEnum TipoAlaEnum;
    private List<Preso> presos;
}
