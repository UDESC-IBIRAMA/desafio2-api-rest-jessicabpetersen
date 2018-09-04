/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.VeiculoDao;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.Veiculo;

/**
 * REST Web Service
 *
 * @author Jéssica Petersen
 */
@Path("veiculo")
public class VeiculoResource {

    @Context
    private UriInfo context;
    private VeiculoDao persistencia = new VeiculoDao();

    /**
     * Creates a new instance of VeiculoResource
     */
    public VeiculoResource() {
    }

    /**
     * Retrieves representation of an instance of service.VeiculoResource
     * @return an instance of model.Veiculo
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> getJson() {
        return persistencia.buscaVeiculos();
  
    }
    
     @GET
    @Path("/getId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Veiculo buscaVeiculoId(@PathParam("id") int idVehicle) {
        Veiculo oVeiculo = null;
        try {
            oVeiculo = persistencia.getVeiculoById(idVehicle);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return oVeiculo;
    }
    
    @GET
    @Path("/{tipo}/{montadora}/{km}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> getFiltrado(
            @PathParam("tipo") String tipo,
            @PathParam("montadora") String montadora,
            @PathParam("km") int km) {
        VeiculoDao persistencia = new VeiculoDao();
        return persistencia.buscarVeiculoByTipoMontadoraKm(tipo, montadora, km);
    }
    
    @GET
    @Path("/{tipo}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> buscaVeiculoTipo(@PathParam("tipo") String tipo) {
        List<Veiculo> veiculos = null;
        try {
            veiculos = persistencia.buscaVeiculosByTipo(tipo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return veiculos;
    }
    
    @GET
    @Path("/{montadora}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> buscaVeiculoMontadora(@PathParam("montadora") String montadora) {
        List<Veiculo> veiculos = null;
        try {
            veiculos = persistencia.buscarVeiculoByMontadora(montadora);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return veiculos;
    }
    
    @GET
    @Path("/{motor}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> buscaVeiculoMotor(@PathParam("motor") String motor) {
        List<Veiculo> veiculos = null;
        try {
            veiculos = persistencia.buscarVeiculoByoMotor(motor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return veiculos;
    }

    /**
     * PUT method for updating or creating an instance of VeiculoResource
     * @param content representation for the resource
     */
    @PUT
    @Path("/editar")
    @Consumes(MediaType.APPLICATION_JSON)
    public void editarVeiculo(Veiculo model) {
        try {
            persistencia.modificarVeiculo(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @POST
    @Path("/addViculo")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String adicionarVeiculo(Veiculo model) {
        String feedback = "";
        try {
            persistencia.salvar(model);
            return "Veículo inserido com sucesso";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao inserir dados!\n" + e.getMessage();
        }
    }
    
     @DELETE
    @Path("/deletar/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deletarVeiculo(@PathParam("id") int id) {
        try {
            persistencia.removeVeiculo(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
