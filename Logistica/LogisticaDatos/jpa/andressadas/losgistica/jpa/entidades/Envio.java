package andressadas.losgistica.jpa.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the envio database table.
 * 
 */
@Entity
@NamedQuery(name="Envio.findAll", query="SELECT e FROM Envio e")
public class Envio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_envio")
	private int idEnvio;

	@Column(name="costo_adicional_envio")
	private int costoAdicionalEnvio;

	@Column(name="costo_envio")
	private int costoEnvio;

	@Column(name="costo_total_envio")
	private int costoTotalEnvio;

	@Column(name="descripcion_envio")
	private String descripcionEnvio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_entrega")
	private Date fechaEntrega;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_recive")
	private Date fechaRecive;

	@Column(name="peso_adicional")
	private int pesoAdicional;

	@Column(name="peso_neto")
	private int pesoNeto;

	//bi-directional many-to-one association to Ruta
	@ManyToOne
	@JoinColumn(name="ruta")
	private Ruta rutaBean;

	//bi-directional many-to-one association to Ciudad
	@ManyToOne
	@JoinColumn(name="ciudad_destino")
	private Ciudad ciudad;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="cliente")
	private Cliente clienteBean;

	public Envio() {
	}

	public int getIdEnvio() {
		return this.idEnvio;
	}

	public void setIdEnvio(int idEnvio) {
		this.idEnvio = idEnvio;
	}

	public int getCostoAdicionalEnvio() {
		return this.costoAdicionalEnvio;
	}

	public void setCostoAdicionalEnvio(int costoAdicionalEnvio) {
		this.costoAdicionalEnvio = costoAdicionalEnvio;
	}

	public int getCostoEnvio() {
		return this.costoEnvio;
	}

	public void setCostoEnvio(int costoEnvio) {
		this.costoEnvio = costoEnvio;
	}

	public int getCostoTotalEnvio() {
		return this.costoTotalEnvio;
	}

	public void setCostoTotalEnvio(int costoTotalEnvio) {
		this.costoTotalEnvio = costoTotalEnvio;
	}

	public String getDescripcionEnvio() {
		return this.descripcionEnvio;
	}

	public void setDescripcionEnvio(String descripcionEnvio) {
		this.descripcionEnvio = descripcionEnvio;
	}

	public Date getFechaEntrega() {
		return this.fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public Date getFechaRecive() {
		return this.fechaRecive;
	}

	public void setFechaRecive(Date fechaRecive) {
		this.fechaRecive = fechaRecive;
	}

	public int getPesoAdicional() {
		return this.pesoAdicional;
	}

	public void setPesoAdicional(int pesoAdicional) {
		this.pesoAdicional = pesoAdicional;
	}

	public int getPesoNeto() {
		return this.pesoNeto;
	}

	public void setPesoNeto(int pesoNeto) {
		this.pesoNeto = pesoNeto;
	}

	public Ruta getRutaBean() {
		return this.rutaBean;
	}

	public void setRutaBean(Ruta rutaBean) {
		this.rutaBean = rutaBean;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Cliente getClienteBean() {
		return this.clienteBean;
	}

	public void setClienteBean(Cliente clienteBean) {
		this.clienteBean = clienteBean;
	}

}