package andressadas.losgistica.jpa.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ruta database table.
 * 
 */
@Entity
@NamedQuery(name="Ruta.findAll", query="SELECT r FROM Ruta r")
public class Ruta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_ruta")
	private int idRuta;

	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	@Column(name="nombre_ruta")
	private String nombreRuta;

	//bi-directional many-to-one association to Envio
	@OneToMany(mappedBy="rutaBean")
	private List<Envio> envios;

	//bi-directional many-to-one association to RutaCiudad
	@OneToMany(mappedBy="rutaBean")
	private List<RutaCiudad> rutaCiudads;

	public Ruta() {
	}

	public int getIdRuta() {
		return this.idRuta;
	}

	public void setIdRuta(int idRuta) {
		this.idRuta = idRuta;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getNombreRuta() {
		return this.nombreRuta;
	}

	public void setNombreRuta(String nombreRuta) {
		this.nombreRuta = nombreRuta;
	}

	public List<Envio> getEnvios() {
		return this.envios;
	}

	public void setEnvios(List<Envio> envios) {
		this.envios = envios;
	}

	public Envio addEnvio(Envio envio) {
		getEnvios().add(envio);
		envio.setRutaBean(this);

		return envio;
	}

	public Envio removeEnvio(Envio envio) {
		getEnvios().remove(envio);
		envio.setRutaBean(null);

		return envio;
	}

	public List<RutaCiudad> getRutaCiudads() {
		return this.rutaCiudads;
	}

	public void setRutaCiudads(List<RutaCiudad> rutaCiudads) {
		this.rutaCiudads = rutaCiudads;
	}

	public RutaCiudad addRutaCiudad(RutaCiudad rutaCiudad) {
		getRutaCiudads().add(rutaCiudad);
		rutaCiudad.setRutaBean(this);

		return rutaCiudad;
	}

	public RutaCiudad removeRutaCiudad(RutaCiudad rutaCiudad) {
		getRutaCiudads().remove(rutaCiudad);
		rutaCiudad.setRutaBean(null);

		return rutaCiudad;
	}

}