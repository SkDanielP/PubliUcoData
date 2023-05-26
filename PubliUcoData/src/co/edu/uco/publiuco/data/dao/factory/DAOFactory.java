package co.edu.uco.publiuco.data.dao.factory;

import co.edu.uco.publiuco.data.dao.AdministradorCategoriaDAO;
import co.edu.uco.publiuco.data.dao.CalificacionDAO;
import co.edu.uco.publiuco.data.dao.CategoriaDAO;
import co.edu.uco.publiuco.data.dao.EstadoAdministradorCategoriaDAO;
import co.edu.uco.publiuco.data.dao.EstadoCategoriaDAO;
import co.edu.uco.publiuco.data.dao.EstadoComentarioLectorDAO;
import co.edu.uco.publiuco.data.dao.EstadoEscritorDAO;
import co.edu.uco.publiuco.data.dao.EstadoLectorDAO;
import co.edu.uco.publiuco.data.dao.EstadoObservacionRevisorDAO;
import co.edu.uco.publiuco.data.dao.EstadoPlanDAO;
import co.edu.uco.publiuco.data.dao.EstadoPreferenciaDAO;
import co.edu.uco.publiuco.data.dao.EstadoPublicacionDAO;
import co.edu.uco.publiuco.data.dao.EstadoRevisionDAO;
import co.edu.uco.publiuco.data.dao.EstadoRevisorDAO;
import co.edu.uco.publiuco.data.dao.EstadoSuscripcionDAO;
import co.edu.uco.publiuco.data.dao.EstadoTipoAccesoDAO;
import co.edu.uco.publiuco.data.dao.EstadoTipoEscritorDAO;
import co.edu.uco.publiuco.data.dao.EstadoTipoRelacionInstitucionDAO;
import co.edu.uco.publiuco.data.dao.LectorDAO;
import co.edu.uco.publiuco.data.dao.PublicacionDAO;
import co.edu.uco.publiuco.data.dao.TipoAccesoDAO;
import co.edu.uco.publiuco.data.dao.TipoComentarioRevisorDAO;
import co.edu.uco.publiuco.data.dao.TipoEscritorDAO;
import co.edu.uco.publiuco.data.dao.TipoIdentificacionDAO;
import co.edu.uco.publiuco.data.dao.TipoRelacionInstitucionDAO;
import co.edu.uco.publiuco.data.dao.TipoReporteDAO;
import co.edu.uco.publiuco.data.dao.TipoRevisionDAO;
import co.edu.uco.publiuco.data.dao.factory.relational.sqlserver.SqlServerDAOFactory;
import co.edu.uco.publiuco.data.dao.relational.postgresql.PostgreSqlDAOFactory;

public abstract class DAOFactory {
	
	public static DAOFactory getFactory(final Factory factory) {
		
		DAOFactory daoFactory;
		
		switch (factory) {
		case SQLSERVER: {
			daoFactory = new SqlServerDAOFactory();
			break;
		}
		
		case POSTGRESQL: {
			daoFactory = new PostgreSqlDAOFactory();
			break;
		}
		
		default:
			throw new IllegalArgumentException("Not implement yes!");
		}
		return daoFactory;
	}
	
	protected abstract void abrirConexion();
	
	public abstract void cerrarConexion();
	
	public abstract void iniciarTransaccion();
	
	public abstract void confirmarTransaccion();
	
	public abstract void cancelarTransaccion();
	
	public abstract EstadoTipoRelacionInstitucionDAO getEstadoTipoRelacionInstitucionDAO();
	
	public abstract TipoRelacionInstitucionDAO getTipoRelacionInstitucionDAO();

	public abstract AdministradorCategoriaDAO getAdmniAdministradorCategoriaDAO();
	
	public abstract CalificacionDAO getCalificacionDAO();
	
	public abstract PublicacionDAO getPublicacionDAO();
	
	public abstract CategoriaDAO getCategoriaDAO();
	
	public abstract EstadoAdministradorCategoriaDAO getAdministradorCategoriaDAO();
	
	public abstract EstadoCategoriaDAO getEstadoCategoriaDAO();
	
	public abstract EstadoComentarioLectorDAO getEstadoComentarioLectorDAO();
	
	public abstract EstadoEscritorDAO getEstadoEscritorDAO();
	
	public abstract EstadoLectorDAO getEstadoLectorDAO();
	
	public abstract EstadoObservacionRevisorDAO getEstadoObservacionRevisorDAO();
	
	public abstract EstadoPlanDAO getEstadoPlanDAO();
	
	public abstract EstadoPreferenciaDAO getEstadoPreferenciaDAO();
	
	public abstract EstadoPublicacionDAO estadoPublicacionDAO();
	
	public abstract EstadoRevisionDAO getEstadoRevisionDAO();
	
	public abstract EstadoRevisorDAO getEstadoRevisorDAO();
	
	public abstract EstadoSuscripcionDAO getEstadoSuscripcionDAO();
	
	public abstract EstadoTipoAccesoDAO getEstadoTipoAccesoDAO();
	
	public abstract EstadoTipoEscritorDAO getEstadoTipoEscritorDAO();
	
	public abstract LectorDAO getLectorDAO();
	
	public abstract PublicacionDAO getEstadoPublicacionDAO();
	
	public abstract TipoAccesoDAO getTipoAccesoDAO();
	
	public abstract TipoComentarioRevisorDAO getTipoComentarioRevisorDAO();
	
	public abstract TipoEscritorDAO getTipoEscritorDAO();
	
	public abstract TipoIdentificacionDAO getTipoIdentificacionDAO();
	
	public abstract TipoReporteDAO getTipoReporteDAO();
	
	public abstract TipoRevisionDAO getTipoRevisionDAO();

}
