/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jéssica Petersen
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "tipoVeiculo",
            query = "select v from Veiculo v where v.tipo = :tipo")
    ,@NamedQuery(name = "montadoraVeiculo",
            query = "select v from Veiculo v where v.montadora = :montadora")
    ,@NamedQuery(name = "motorVeiculo",
            query = "select v from Veiculo v where v.motor = :motor")
    ,@NamedQuery(name = "VeiculoTipoMontadoraKm",
            query = "select v from Veiculo v where v.tipo = :tipo and v.montadora = :montadora and v.quilometragem > :quilometragem")})
@XmlRootElement
public class Veiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String montadora;
    private String modelo;
    private String cor;
    private String quilometragem;
    private String motor;
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMontadora() {
        return montadora;
    }

    public void setMontadora(String montadora) {
        this.montadora = montadora;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(String quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Veiculo)) {
            return false;
        }
        Veiculo other = (Veiculo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
       return "Id: " + getId()
                + "\nMontadora: " + getMontadora()
                + "\nModelo: " + getModelo()
                + "\nCor: " + getCor()
                + "\nKM: " + getQuilometragem()
                + "\nMotor: " + getMotor()
                + "\nTipo: " + getTipo();
    }
    
}
