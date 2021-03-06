/*
 * Copyright 2011 Dividato. All rights reserved
 *
 * Copyright Version 1.0
 *
 * Create on 21/07/2011
 */
package com.security.modelo.configuraciongeneral;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.security.modelo.administracion.ClienteAsp;
import com.security.modelo.jerarquias.TipoRequerimiento;
import com.security.modelo.seguridad.User;
import com.security.utils.Constantes;
import com.security.utils.EAN13;


/**
 * @author Gonzalo Noriega
 *
 */
@Entity
@Table(name = "elementos")
public class Elemento implements Cloneable{
	private Long id;
	private String codigo;
	private String codigoAlternativo;
	private TipoElemento tipoElemento;
	private Long nroPrecinto;
	private Long nroPrecinto1;
	private ClienteEmp clienteEmp;
	private Elemento contenedor;
	private Boolean generaCanonMensual;
	private String estado;	
	private Posicion posicion;	
	private ClienteAsp clienteAsp;
	private Deposito depositoActual;
	private Date fechaModificacion;
	private User usuarioModificacion;
	private Date fechaModificacionPrecinto;
	private User usuarioModificacionPrecinto;
	private String tipoTrabajo;
	private String estadoTrabajo;
	private String ubicacionProvisoria;
	private Boolean cerrado;
	private Boolean habilitadoCerrar;
	
	private transient String accion;
	private transient String codigoCliente;
	private transient String codigoElemento;
	private transient String codigoTipoElemento;
	private transient String codigoPosicion;
	private transient String codigoSucursal;
	private transient String codigoEmpresa;
	private transient String codigoDeposito;
	private transient String codigoDesde;
	private transient String codigoHasta;
	private transient String codigoContenedor;
	private transient String codigoClasificacionDocumental;
	private transient Integer cantidad;
	private transient String hasta;
	private transient String codigoSinPrefijo;
	private transient String codigoLectura;
	private transient Posicion posicionFutura;
	private transient Integer numeroPagina;
	private transient Integer tamaņoPagina;
	private transient String fieldOrder;
	private transient String sortOrder;
	private transient Long orden;
	private transient Boolean sinReferencia;
	private transient Boolean cajasVacias;
	private transient ClasificacionDocumental clasificacionDocumental;
	private transient TipoRequerimiento tipoRequerimiento;
	
	public Elemento() {
		super();
		this.generaCanonMensual = false;
		this.estadoTrabajo = Constantes.ELEMENTO_ESTADO_TRABAJO_PENDIENTE;
	}
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	public TipoElemento getTipoElemento() {
		return tipoElemento;
	}

	public void setTipoElemento(TipoElemento tipoElemento) {
		this.tipoElemento = tipoElemento;
	}
	
	public Long getNroPrecinto() {
		return nroPrecinto;
	}

	public void setNroPrecinto(Long nroPrecinto) {
		this.nroPrecinto = nroPrecinto;
	}

	public Long getNroPrecinto1() {
		return nroPrecinto1;
	}

	public void setNroPrecinto1(Long nroPrecinto1) {
		this.nroPrecinto1 = nroPrecinto1;
	}

	@OneToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	public ClienteEmp getClienteEmp() {
		return clienteEmp;
	}

	public void setClienteEmp(ClienteEmp clienteEmp) {
		this.clienteEmp = clienteEmp;
	}

	@OneToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE},fetch=FetchType.EAGER)
	public Elemento getContenedor() {
		return contenedor;
	}

	public void setContenedor(Elemento contenedor) {
		this.contenedor = contenedor;
	}

	public Boolean getGeneraCanonMensual() {
		return generaCanonMensual;
	}

	public void setGeneraCanonMensual(Boolean generaCanonMensual) {
		this.generaCanonMensual = generaCanonMensual;
	}

	@Column(length=60)
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@Column(columnDefinition = "VARCHAR(12)")
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Column(columnDefinition = "VARCHAR(30)")
	public String getCodigoAlternativo() {
		return codigoAlternativo;
	}

	public void setCodigoAlternativo(String codigoAlternativo) {
		this.codigoAlternativo = codigoAlternativo;
	}

	@OneToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	@OneToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	public ClienteAsp getClienteAsp() {
		return clienteAsp;
	}

	public void setClienteAsp(ClienteAsp clienteAsp) {
		this.clienteAsp = clienteAsp;
	}

	@OneToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	public Deposito getDepositoActual() {
		return depositoActual;
	}

	public void setDepositoActual(Deposito depositoActual) {
		this.depositoActual = depositoActual;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	public User getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(User usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public Date getFechaModificacionPrecinto() {
		return fechaModificacionPrecinto;
	}

	public void setFechaModificacionPrecinto(Date fechaModificacionPrecinto) {
		this.fechaModificacionPrecinto = fechaModificacionPrecinto;
	}

	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	public User getUsuarioModificacionPrecinto() {
		return usuarioModificacionPrecinto;
	}

	public void setUsuarioModificacionPrecinto(User usuarioModificacionPrecinto) {
		this.usuarioModificacionPrecinto = usuarioModificacionPrecinto;
	}

	public String getTipoTrabajo() {
		return tipoTrabajo;
	}

	public void setTipoTrabajo(String tipoTrabajo) {
		this.tipoTrabajo = tipoTrabajo;
	}

	public String getEstadoTrabajo() {
		return estadoTrabajo;
	}

	public void setEstadoTrabajo(String estadoTrabajo) {
		this.estadoTrabajo = estadoTrabajo;
	}

	@Transient
	public String getAccion() {
		return accion;
	}
	@Transient
	public void setAccion(String accion) {
		this.accion = accion;
	}
	@Transient
	public String getCodigoCliente() {
		return codigoCliente;
	}
	@Transient
	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	@Transient
	public String getCodigoElemento() {
		return codigoElemento;
	}
	@Transient
	public void setCodigoElemento(String codigoElemento) {
		this.codigoElemento = codigoElemento;
	}
	@Transient
	public String getCodigoTipoElemento() {
		return codigoTipoElemento;
	}
	@Transient
	public void setCodigoTipoElemento(String codigoTipoElemento) {
		this.codigoTipoElemento = codigoTipoElemento;
	}

	@Transient
	public String getCodigoPosicion() {
		return codigoPosicion;
	}
	@Transient
	public void setCodigoPosicion(String codigoPosicion) {
		this.codigoPosicion = codigoPosicion;
	}
	@Transient
	public String getCodigoSucursal() {
		return codigoSucursal;
	}
	@Transient
	public void setCodigoSucursal(String codigoSucursal) {
		this.codigoSucursal = codigoSucursal;
	}
	@Transient
	public String getCodigoEmpresa() {
		return codigoEmpresa;
	}
	@Transient
	public void setCodigoEmpresa(String codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}
	@Transient
	public String getCodigoDeposito() {
		return codigoDeposito;
	}
	@Transient
	public void setCodigoDeposito(String codigoDeposito) {
		this.codigoDeposito = codigoDeposito;
	}
	@Transient
	public String getCodigoDesde() {
		return codigoDesde;
	}
	@Transient
	public void setCodigoDesde(String codigoDesde) {
		this.codigoDesde = codigoDesde;
	}
	@Transient
	public String getCodigoHasta() {
		return codigoHasta;
	}
	@Transient
	public void setCodigoHasta(String codigoHasta) {
		this.codigoHasta = codigoHasta;
	}
	@Transient
	public Integer getCantidad() {
		return cantidad;
	}
	@Transient
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	@Transient
	public String getHasta() {
		return hasta;
	}
	@Transient
	public void setHasta(String hasta) {
		this.hasta = hasta;
	}
	@Transient
	public String getCodigoSinPrefijo() {
		return codigoSinPrefijo;
	}
	@Transient
	public void setCodigoSinPrefijo(String codigoSinPrefijo) {
		this.codigoSinPrefijo = codigoSinPrefijo;
	}
	@Transient
	public String getCodigoLectura() {
		return codigoLectura;
	}
	@Transient
	public void setCodigoLectura(String codigoLectura) {
		this.codigoLectura = codigoLectura;
	}	
	@Transient
	public Posicion getPosicionFutura() {
		return posicionFutura;
	}
	@Transient
	public void setPosicionFutura(Posicion posicionFutura) {
		this.posicionFutura = posicionFutura;
	}
	@Transient
	public String getDigitoControlCodigoEAN13(){
		if(codigo==null)
			return "";
		return String.valueOf(EAN13.EAN13_CHECKSUM(codigo));
	}
	@Transient
	public String getCodigoBarra(){
		if(codigo==null)
			return "";
		return codigo + String.valueOf(EAN13.EAN13_CHECKSUM(codigo));
	}
	public Elemento clone(){
        Elemento obj=null;
        try{
            obj=(Elemento)super.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println(" no se puede duplicar");
        }
        return obj;
    }

	@Override
	/**
	 * Genera el codigo hash por id de elemento
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	/**
	 * Compara por id de elemento
	 */
	public boolean equals(Object obj) {
		int i=1;
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Elemento)) {
			return false;
		}
		
		Elemento other = (Elemento) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		
		if (clienteEmp == null) {
			if (other.clienteEmp != null) {
				return false;
			}
		}else if(other.clienteEmp == null){
			return false;
		}else if (!clienteEmp.getId().equals(other.clienteEmp.getId())) {
			return false;
		}
		
		if (contenedor == null) {
			if (other.contenedor != null) {
				return false;
			}
		}else if(other.contenedor == null){
			return false;
		} else if (!contenedor.getId().equals(other.contenedor.getId())) {
			return false;
		}
		
		if (!estado.equals(other.estado)) {
			return false;
		}
		
		if (tipoTrabajo == null) {
			if (other.tipoTrabajo != null) {
				return false;
			}
		}else if(other.tipoTrabajo == null){
			return false;
		} else if (!tipoTrabajo.equals(other.tipoTrabajo)) {
			return false;
		}
		
		if (nroPrecinto == null) {
			if (other.nroPrecinto != null) {
				return false;
			}
		}else if(other.nroPrecinto == null){
			return false;
		} else if (!nroPrecinto.equals(other.nroPrecinto)) {
			return false;
		}
		
		if (nroPrecinto1 == null) {
			if (other.nroPrecinto1 != null) {
				return false;
			}
		}else if(other.nroPrecinto1 == null){
			return false;
		} else if (!nroPrecinto1.equals(other.nroPrecinto1)) {
			return false;
		}
		
		if (!generaCanonMensual.equals(other.generaCanonMensual)) {
			return false;
		}
		
		
		return true;
		

	}
	
	/**
	 * Devuelve el codigo de la forma Ej: (01) - 2 utilizado en la etiqueta mediana
	 */
	@Transient
	public String getCodigoEtiqueta()
	{
		if(codigo == null)
			return "";
		String prefijo = codigo.substring(0,2);
		Long codigoSinPrefijo = parseLongCodigo(codigo.substring(2, codigo.length()));
		return prefijo+"-"+codigoSinPrefijo;
	}
	/**
	 * Devuelve el codigo del estante de la forma E: 0001 utilizado en la etiqueta mediana
	 */
	@Transient
	public String getCodigoEstante()
	{
		if(posicion == null)
			return "";
		return "E : "+posicion.getEstante().getCodigo();
	}
	/**
	 * Devuelve el nombre de la empresa utilizado en la etiqueta
	 */
	@Transient
	public String getEmpresaEtiqueta()
	{
		if(clienteEmp == null)
			return "";
		return clienteEmp.getEmpresa().getNombreRazonSocial();
	}
	/**
	 * Devuelve el nombre del clienteEmp utilizado en la etiqueta
	 */
	@Transient
	public String getClienteEmpEtiqueta()
	{
		if(clienteEmp == null)
			return "";
		return "C: "+clienteEmp.getCodigo();
	}
	@Transient
	public Integer getNumeroPagina() {
		return numeroPagina;
	}
	@Transient
	public void setNumeroPagina(Integer numeroPagina) {
		this.numeroPagina = numeroPagina;
	}
	@Transient
	public Integer getTamaņoPagina() {
		return tamaņoPagina;
	}
	@Transient
	public void setTamaņoPagina(Integer tamaņoPagina) {
		this.tamaņoPagina = tamaņoPagina;
	}
	@Transient
	public String getFieldOrder() {
		return fieldOrder;
	}
	@Transient
	public void setFieldOrder(String fieldOrder) {
		this.fieldOrder = fieldOrder;
	}
	@Transient
	public String getSortOrder() {
		return sortOrder;
	}
	@Transient
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	@Transient
	public Long getOrden() {
		return orden;
	}
	@Transient
	public void setOrden(Long orden) {
		this.orden = orden;
	}
	@Transient
	public String getCodigoContenedor() {
		return codigoContenedor;
	}
	@Transient
	public void setCodigoContenedor(String codigoContenedor) {
		this.codigoContenedor = codigoContenedor;
	}
	@Transient
	public Boolean getSinReferencia() {
		return sinReferencia;
	}
	@Transient
	public void setSinReferencia(Boolean sinReferencia) {
		this.sinReferencia = sinReferencia;
	}

	@Transient
	public String getLecturaOrden()
	{
		if(codigoLectura == null)
			return "";
		return "L/O: "+ codigoLectura +"/"+orden;
	}

	private Long parseLongCodigo(String codigo){
		Long result= null;
		//si el codigo es distinto de vacio o null
		if(codigo!=null && codigo.length()>0){
			//cuenta el primer digito diferente de 0
			int cont = 0;
			while(codigo.substring( cont, cont).equals("0")){
				cont++;
			}
			//si el codigo esta formado solo por 0
			if(cont == codigo.length()-1){
				result = new Long(0);
			}else{
				//devuelve el Integer formado por el substring desde el cont hasta el final del codigo
				result = Long.parseLong(codigo.substring(cont));
			}
		}else{
			result = new Long(0);
		}
		return result;
	}

	public String getUbicacionProvisoria() {
		return ubicacionProvisoria;
	}

	public void setUbicacionProvisoria(String ubicacionProvisoria) {
		this.ubicacionProvisoria = ubicacionProvisoria;
	}

	public Boolean getCerrado() {
		return cerrado;
	}

	public void setCerrado(Boolean cerrado) {
		this.cerrado = cerrado;
	}

	public Boolean getHabilitadoCerrar() {
		return habilitadoCerrar;
	}

	public void setHabilitadoCerrar(Boolean habilitadoCerrar) {
		this.habilitadoCerrar = habilitadoCerrar;
	}
	@Transient
	public Boolean getCajasVacias() {
		return cajasVacias;
	}
	@Transient
	public void setCajasVacias(Boolean cajasVacias) {
		this.cajasVacias = cajasVacias;
	}
	@Transient
	public String getCodigoClasificacionDocumental() {
		return codigoClasificacionDocumental;
	}
	@Transient
	public void setCodigoClasificacionDocumental(String codigoClasificacionDocumental) {
		this.codigoClasificacionDocumental = codigoClasificacionDocumental;
	}
	@Transient
	public ClasificacionDocumental getClasificacionDocumental() {
		return clasificacionDocumental;
	}
	@Transient
	public void setClasificacionDocumental(ClasificacionDocumental clasificacionDocumental) {
		this.clasificacionDocumental = clasificacionDocumental;
	}
	@Transient
	public TipoRequerimiento getTipoRequerimiento() {
		return tipoRequerimiento;
	}
	@Transient
	public void setTipoRequerimiento(TipoRequerimiento tipoRequerimiento) {
		this.tipoRequerimiento = tipoRequerimiento;
	}

	
}
