/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import model.Veiculo;

/**
 *
 * @author Jéssica Petersen
 */
public class VeiculoDao extends Dao{
    
    private static final long serialVersionUID = 1L;
    
    public List<Veiculo> buscaVeiculos(){
         EntityManager em = getEntity();
         Query q = em.createQuery("SELECT v FROM Veiculo v ORDER BY v.nome");
         return q.getResultList();
    }
    
    public EntityManager getEntity(){
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("desafio1");
        return emf.createEntityManager();
    }
    
    public List<Veiculo> buscaVeiculosByTipo(String tipo) {
        EntityManager em = getEntity();
        Query buscar = em.createNamedQuery("tipoVeiculo");
        buscar.setParameter("tipo", tipo);
        return buscar.getResultList();
    }

    public List<Veiculo> buscarVeiculoByMontadora(String montadora) {
        EntityManager em = getEntity();
        Query buscar = em.createNamedQuery("montadoraVeiculo");
        buscar.setParameter("montadora", montadora);
        return buscar.getResultList();
    }

    public List<Veiculo> buscarVeiculoByoMotor(String motor) {
        EntityManager em = getEntity();
        Query buscar = em.createNamedQuery("motorVeiculo");
        buscar.setParameter("motor", motor);
        return buscar.getResultList();
    }

    public List<Veiculo> buscarVeiculoByTipoMontadoraKm(String tipo, String montadora, int quilometragem) {
        EntityManager em = getEntity();
        Query buscar = em.createNamedQuery("VeiculoTipoMontadoraKm");
        buscar.setParameter("tipo", tipo);
        buscar.setParameter("montadora", montadora);
        buscar.setParameter("quilometragem", quilometragem);
        return buscar.getResultList();
    }

    public Veiculo getVeiculoById(long id) {
        return (Veiculo) ler(Veiculo.class, id);
    }

    public void removeVeiculo(long id) {
        Veiculo veiculo = getVeiculoById(id);
        remover(veiculo);
    }

    public void modificarVeiculo(Veiculo veiculo) {
        Veiculo valida = getVeiculoById(veiculo.getId());
        if (valida != null) {
            update(veiculo);
        }
    }
}
