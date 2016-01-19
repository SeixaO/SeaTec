/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seaTec.ejb;

import seaTec.entidades.Candidato;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author seixa
 */
@Stateless
public class CandidatoEJB {
    @PersistenceContext(unitName = "SeaTec-ejbPU")
    private EntityManager gerente;
    
    
    public void criar(Candidato entidade){
        gerente.persist(entidade);
    }
    
    public void editar(Candidato entidade){
        gerente.merge(entidade);
    }
    
    public void excluir(Candidato entidade){
        gerente.remove(gerente.merge(entidade));
    }
    
    public Candidato achar(Object id){
        return gerente.find(Candidato.class, id);
    }
    
    public List<Candidato> listar(){ //faz uma busca e retorna registros da tabela
        CriteriaQuery crit = gerente.getCriteriaBuilder().createQuery();
        crit.select(crit.from(Candidato.class));
        return gerente.createQuery(crit).getResultList();
    }
}
