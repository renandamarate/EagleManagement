/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.Abstract;

import Modelos.Endereco;
import java.sql.Date;

/**
 *
 * @author Damarate
 */
public abstract class Pessoa {
    private int id;
    private String documentoRG;
    private String documentoCPF;
    private String nome;
    private Date dataNascimento;
    private char sexo;
    private Endereco endereco;
    private boolean Status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }
    
    
    public String getDocumentoRG() {
        return documentoRG;
    }

    public void setDocumentoRG(String documentoRG) {
        this.documentoRG = documentoRG;
    }

    public String getDocumentoCPF() {
        return documentoCPF;
    }

    public void setDocumentoCPF(String documentoCPF) {
        this.documentoCPF = documentoCPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }    

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
