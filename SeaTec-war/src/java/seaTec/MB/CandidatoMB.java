package seaTec.MB;

import seaTec.ejb.CandidatoEJB;
import seaTec.entidades.Candidato;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "CandidatoMB")
@SessionScoped
public class CandidatoMB implements Serializable {

    @EJB
    private CandidatoEJB candidatoEJB;
    private List<Candidato> listCandidato;
    private Candidato candidato;

    public CandidatoMB() {
    }


    public List<Candidato> getListCandidato() {
        return listCandidato;
    }

    public void setListCandidato(List<Candidato> listCandidato) {
        this.listCandidato = listCandidato;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public List<Candidato> listar() {
        if (listCandidato == null) {
            listCandidato = candidatoEJB.listar();
        }
        return listCandidato;
    }

    public String inserir() {
    candidato = new Candidato();
        return "incluir";
    }

    public String alterar(Candidato candidato) {
        this.candidato = candidato;
        return "editar";
    }

    public void apagar(Candidato candidato) {
        candidatoEJB.excluir(candidato);
        listCandidato = candidatoEJB.listar();
    }

    public String salvar(boolean novo) {
            
        if (novo) {
            candidatoEJB.criar(candidato);
        } else {
            candidatoEJB.editar(candidato);
        }
        listCandidato = candidatoEJB.listar();
        return "index";
    }
    
   
}
