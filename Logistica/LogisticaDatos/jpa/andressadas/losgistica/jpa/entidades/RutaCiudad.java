package andressadas.losgistica.jpa.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ruta_ciudad database table.
 * 
 */
@Entity
@Table(name="ruta_ciudad")
@NamedQuery(name="RutaCiudad.findAll", query="SELECT r FROM RutaCiudad r")
public class RutaCiudad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_ruta_ciudad")
	private int idRutaCiudad;

	private String punto;

	private int tarifa;

	@Column(name="tarifa_adicional")
	private int tarifaAdicional;

	//bi-directional many-to-one association to Ruta
	@ManyToOne
	@JoinColumn(name="ruta")
	private Ruta rutaBean;

	//bi-directional many-to-one association to Ciudad
	@ManyToOne
	@JoinColumn(name="ciudad")
	private Ciudad ciudadBean;

	public RutaCiudad() {
	}

	public int getIdRutaCiudad() {
		return this.idRutaCiudad;
	}

	public void setIdRutaCiudad(int idRutaCiudad) {
		this.idRutaCiudad = idRutaCiudad;
	}

	public String getPunto() {
		return this.punto;
	}

	public void setPunto(String punto) {
		this.punto = punto;
	}

	public int getTarifa() {
		return this.tarifa;
	}

	public void setTarifa(int tarifa) {
		this.tarifa = tarifa;
	}

	public int getTarifaAdicional() {
		return this.tarifaAdicional;
	}

	public void setTarifaAdicional(int tarifaAdicional) {
		this.tarifaAdicional = tarifaAdicional;
	}

	public Ruta getRutaBean() {
		return this.rutaBean;
	}

	public void setRutaBean(Ruta rutaBean) {
		this.rutaBean = rutaBean;
	}

	public Ciudad getCiudadBean() {
		return this.ciudadBean;
	}

	public void setCiudadBean(Ciudad ciudadBean) {
		this.ciudadBean = ciudadBean;
	}

}