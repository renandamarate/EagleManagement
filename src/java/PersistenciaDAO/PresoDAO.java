/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersistenciaDAO;

import Modelos.Enum.TipoEscolaridadeEnum;
import Modelos.Enum.TipoEtniaEnum;
import Modelos.Enum.TipoMotivadorEnum;
import Modelos.Enum.TipoNacionalidadeEnum;
import Modelos.Enum.TipoNaturalidadeEnum;
import Modelos.Enum.TipoRegimeEnum;
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
    private static StringBuilder insertPessoaSQL = new StringBuilder()
		.append("insert into Preso")
		.append("(dataPrisao, necessidadeEspecial, altura, peso, tipoMotivador, tipoRegime"
                        + "tipoNacionalidade, tipoNaturalidade, tipoReligiao, tipoEtnia, tipoEscolaridade, Status)")
		.append("values ")
		.append("(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, true)");
    private static StringBuilder updatePessoaSQL = new StringBuilder()
		.append("insert into Preso")
		.append("(dataPrisao, necessidadeEspecial, altura, peso, tipoMotivador, tipoRegime"
                        + "tipoNacionalidade, tipoNaturalidade, tipoReligiao, tipoEtnia, tipoEscolaridade)")
		.append("values ")
		.append("(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

    private PresoDAO() {
    }

    public static PresoDAO getInstance() {
        return instance;
    }
    
    ///////////////////////////////////////////////////////////////////
    // METODOS DE MODIFICACAO
    ///////////////////////////////////////////////////////////////////
    
    public void salvarPreso(Preso preso) throws SQLException {
        
        PessoaDAO.getInstance().salvarPessoa(preso);
        
        int cont = 1;
        Connection connection = null; //Conexao.getInstance().obterConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(insertPessoaSQL.toString(), Statement.RETURN_GENERATED_KEYS);
            ps.setDate(cont++, preso.getDataPrisao());
            ps.setBoolean(cont++, preso.isNecessidadeEspecial());
            ps.setDouble(cont++, preso.getAltura());
            ps.setDouble(cont++, preso.getPeso());
            ps.setString(cont++, TipoMotivadorEnum.getBy(preso.getTipoMotivadorEnum()));
            ps.setString(cont++, TipoRegimeEnum.getBy(preso.getTipoRegimeEnum()));
            ps.setString(cont++, TipoNacionalidadeEnum.getBy(preso.getTipoNacionalidadeEnum()));
            ps.setString(cont++, TipoNaturalidadeEnum.getBy(preso.getTipoNaturalidadeEnum()));
            ps.setString(cont++, TipoRegimeEnum.getBy(preso.getTipoRegimeEnum()));
            ps.setString(cont++, TipoEtniaEnum.getBy(preso.getTipoEtniaEnum()));
            ps.setString(cont++, TipoEscolaridadeEnum.getBy(preso.getTipoEscolaridadeEnum()));
            ps.executeUpdate();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            //Conexao.close(rs, ps, connection);
        }
    }
    
    public void atualizarPreso(Preso preso) throws SQLException {
        
        PessoaDAO.getInstance().atualizarPessoa(preso);
        
        int cont = 1;
        Connection connection = null; //Conexao.getInstance().obterConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(updatePessoaSQL.toString());
            ps.setDate(cont++, preso.getDataPrisao());
            ps.setBoolean(cont++, preso.isNecessidadeEspecial());
            ps.setDouble(cont++, preso.getAltura());
            ps.setDouble(cont++, preso.getPeso());
            ps.setString(cont++, TipoMotivadorEnum.getBy(preso.getTipoMotivadorEnum()));
            ps.setString(cont++, TipoRegimeEnum.getBy(preso.getTipoRegimeEnum()));
            ps.setString(cont++, TipoNacionalidadeEnum.getBy(preso.getTipoNacionalidadeEnum()));
            ps.setString(cont++, TipoNaturalidadeEnum.getBy(preso.getTipoNaturalidadeEnum()));
            ps.setString(cont++, TipoRegimeEnum.getBy(preso.getTipoRegimeEnum()));
            ps.setString(cont++, TipoEtniaEnum.getBy(preso.getTipoEtniaEnum()));
            ps.setString(cont++, TipoEscolaridadeEnum.getBy(preso.getTipoEscolaridadeEnum()));
            ps.executeUpdate();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            //Conexao.close(rs, ps, connection);
        }
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
