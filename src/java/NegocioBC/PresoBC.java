package NegocioBC;

import Modelos.Preso;
import PersistenciaDAO.PresoDAO;
import java.util.List;

public class PresoBC {
	
    private static PresoBC instance = new PresoBC();

    private PresoBC() {
    }

    public static PresoBC getInstance() {
            return instance;
    }

    ///////////////////////////////////////////////////////////////////
    // METODOS DE MODIFICACAO
    ///////////////////////////////////////////////////////////////////

    public void cadastrarPreso(Preso preso) {
        PresoDAO.getInstance().salvarPreso(preso);
    }

    public void atualizarPreso(Preso preso) {
        PresoDAO.getInstance().atualizarPreso(preso);
    }

    public void inativarPreso(Preso preso) {
        PresoDAO.getInstance().atualizarPreso(preso);
    }

    ///////////////////////////////////////////////////////////////////
    // METODOS DE BUSCA
    ///////////////////////////////////////////////////////////////////

    public Preso pesquisarPresoCPF(String filtro){
        return PresoDAO.getInstance().pesquisarPresoCPF(filtro);
    }
    
    public Preso pesquisarPresoNome(String filtro){
        return PresoDAO.getInstance().pesquisarPresoNome(filtro);
    }
    
    public Preso pesquisarPresoRG(String filtro){
        return PresoDAO.getInstance().pesquisarPresoRG(filtro);
    }

}