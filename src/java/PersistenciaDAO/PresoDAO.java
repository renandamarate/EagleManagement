/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersistenciaDAO;

import Modelos.Preso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jeferson.zavaski
 */
public class PresoDAO {
    
    private static PresoDAO instance = new PresoDAO();

    private PresoDAO() {
    }

    public static PresoDAO getInstance() {
        return instance;
    }
    
    ///////////////////////////////////////////////////////////////////
    // METODOS DE MODIFICACAO
    ///////////////////////////////////////////////////////////////////
    
    public void salvarPreso(Preso preso) {
        int cont = 1;
        Connection connection = null; //Conexao.getInstance().obterConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(insertSQL.toString(), Statement.RETURN_GENERATED_KEYS);
            ps.setString(cont++, preso.getNome());
            ps.setString(cont++, preso.getDocumentoRG());
            ps.setString(cont++, preso.getDocumentoCPF());
            ps.setDate(cont++, preso.getDataNascimento());
            ps.setString(cont++, preso.getNome());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //Conexao.close(rs, ps, connection);
        }
    }
    
    public void atualizarPreso(Preso preso) {
        
    }

    ///////////////////////////////////////////////////////////////////
    // METODOS DE BUSCA
    ///////////////////////////////////////////////////////////////////

    public Preso pesquisarPresoCPF(String filtro){
        return null;
    }
    
    public Preso pesquisarPresoNome(String filtro){
        return null;
    }
    
    public Preso pesquisarPresoRG(String filtro){
        return null;
    }
}
