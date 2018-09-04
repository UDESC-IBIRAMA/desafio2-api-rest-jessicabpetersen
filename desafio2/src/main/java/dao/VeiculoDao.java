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

    //condicionando crud conforme campo da tabela, no caso aqui o Id
    public Veiculo getVeiculoById(long id) {
        return (Veiculo) ler(Veiculo.class, id);
    }

    public void removeVeiculo(int id) {
        Veiculo oVeiculo = getVeiculoById(id);
        //chama o método remove do dao genérico
        remover(oVeiculo);
    }

    public void modificarVeiculo(Veiculo oVeiculo) {
        Veiculo valida = getVeiculoById(oVeiculo.getId());
        if (valida != null) {
            update(oVeiculo);
        }
    }
}
