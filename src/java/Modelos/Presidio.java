/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.sql.Date;

/**
 *
 * @author Damarate
 */
public class Presidio {
    private int id;
    private String CNPJ;
    private String razaoSocial;
    private String nomeFantasia;
    private Date dataAbertura;
    private Endereco endereco;
    private int capacidadeTotal;
    private int qtdeRefeitorios;
    private int qtdeGalerias;
    private int qtdePatios;
    private int qtdeSolitaria; //Fazer em banco
    private int qtdeConsultorioMedico;
    private int qtdeConsultorioOdontologico;
    private int qtdeAlojamentos;
    private double areaContruida;
    private double areaTerreno;
}
