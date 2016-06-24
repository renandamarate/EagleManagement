package PersistenciaDAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Classe que realiza o trabalho de obter a conexao do banco de dados, lendo
 * as informacoes que estao gravadas dentro do arquivo conexao.conf
 * @author Mauda
 *
 */
public class Conexao {
	private static final String ARQ_CONF = "resources/conexao.conf";
	private static Conexao instancia = new Conexao();
	private static Properties configuracoes;
	
        
	private static String driver = configuracoes.getProperty("driver");
	private static String url = configuracoes.getProperty("url");
	private static String usuario = configuracoes.getProperty("usuario");
	private static String senha = configuracoes.getProperty("senha");
	
	/**
	 * Construtor Privado para o padrão singleton
	 */
	private Conexao() {
		lerConfiguracoes();
		driver = configuracoes.getProperty("driver");
		url = configuracoes.getProperty("url");
		usuario = configuracoes.getProperty("usuario");
		senha = configuracoes.getProperty("senha");
	}
	
	//////////////////////////////////////////////////////
	// METODOS ESTATICOS
	//////////////////////////////////////////////////////
	
	/**
	 * Metodo obrigatorio para o padrao Singleton 
	 * @return
	 */
	public static Conexao getInstance() {
		return instancia;
	}
	
	/**
	 * Metodo que obtem a instancia de Connection com o BD
	 * @return
	 */
	public static Connection getConnection(){
		return Conexao.getInstance().obterConexao();
	}
	
	/**
	 * Metodo responsavel por fechar um ResultSet
	 * @param rs
	 */
	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception excp) {
				// Ignore, we don't care, we do care when we open it
			}
		}
	}

	/**
	 * Metodo responsavel por fechar uma Connection
	 * @param cn
	 */
	public static void close(Connection cn) {
		if (cn != null) {
			try {
				cn.close();
			} catch (Exception excp) {
				// Ignore, we don't care, we do care when we open it
			}
		}
	}


	/**
	 * Metodo responsavel por fechar uma Statement
	 * @param stmt
	 */
	public static void close(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception excp) {
				// Ignore, we don't care, we do care when we open it
			}
		}
	}

	/**
	 * Metodo responsavel por fechar ResultSet, Statement e Connection realizando
	 * um overload de metodos
	 * @param rs
	 * @param ps
	 * @param conn
	 */
	public static void close(ResultSet rs, Statement ps, Connection conn) {
		close(rs);
		close(ps);
		close(conn);
	}
	
	
	//////////////////////////////////////////////////////
	// METODOS COMUNS
	//////////////////////////////////////////////////////
	
	/**
	 * Metodo que realiza a leitura das configurações do arquivo de properties
	 */
	private void lerConfiguracoes() {
		try {
			File arqConf = new File(ARQ_CONF);
			if (!arqConf.exists())
				throw new IllegalArgumentException(
						"Arquivo de configuração não existe " + ARQ_CONF);
			FileInputStream entrada = new FileInputStream(arqConf);
			configuracoes = new Properties();
			configuracoes.load(entrada);
			entrada.close();
		} catch (IOException e) {
			throw new RuntimeException("Erro de E/S",e);
		}
	}
	
	/**
	 * Metodo responsavel por obter a instancia da classe connection do BD
	 * @return
	 */
	public Connection obterConexao() {
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, usuario, senha);
			return con;
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Classe não encontrada. " +
					"Verifique driver no classpath",e);
		} catch (SQLException e) {
			throw new RuntimeException("Erro SQL",e);
		}
	}
}
