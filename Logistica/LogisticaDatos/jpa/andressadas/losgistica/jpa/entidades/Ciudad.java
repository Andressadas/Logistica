package andressadas.losgistica.jpa.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ciudad database table.
 * 
 */
@Entity
@NamedQuery(name="Ciudad.findAll", query="SELECT c FROM Ciudad c")
public class Ciudad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_ciudad")
	private int idCiudad;

	@Column(name="nombre_ciudad")
	private String nombreCiudad;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="id_departamento")
	private Departamento departamento;

	//bi-directional many-to-one association to Envio
	@OneToMany(mappedBy="ciudad")
	private List<Envio> envios;

	//bi-directional many-to-one association to RutaCiudad
	@OneToMany(mappedBy="ciudadBean")
	private List<RutaCiudad> rutaCiudads;

	public Ciudad() {
	}

	public int getIdCiudad() {
		return this.idCiudad;
	}

	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getNombreCiudad() {
		return this.nombreCiudad;
	}

	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Envio> getEnvios() {
		return this.envios;
	}

	public void setEnvios(List<Envio> envios) {
		this.envios = envios;
	}

	public Envio addEnvio(Envio envio) {
		getEnvios().add(envio);
		envio.setCiudad(this);

		return envio;
	}

	public Envio removeEnvio(Envio envio) {
		getEnvios().remove(envio);
		envio.setCiudad(null);

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
		rutaCiudad.setCiudadBean(this);

		return rutaCiudad;
	}

	public RutaCiudad removeRutaCiudad(RutaCiudad rutaCiudad) {
		getRutaCiudads().remove(rutaCiudad);
		rutaCiudad.setCiudadBean(null);

		return rutaCiudad;
	}

}