package co.edu.uco.publiuco.data.dao.relational;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import co.edu.uco.publiuco.crosscutting.exception.PubliucoDataException;
import co.edu.uco.publiuco.crosscutting.utils.UtilSql;

public abstract class SqlDAO<E> {
	
	private Connection connection;
	
	protected SqlDAO(final Connection connection) {
		setConnection(connection);
	}

	protected final Connection getConnection() {
		return connection;
	}

	private final void setConnection(final Connection connection) {
		if(!UtilSql.connectionIsOpen(connection)) {
			var userMessage = "Se ha presentado un error tratando de llevar a cabo la operacion deseada por favor intente de nuevo y si el problema persiste contecte al administrador del sistema";
			var technicalMessage = "No se ha podido crear el SqlDAO debido a que la conexion no esta abierta";
			
			throw PubliucoDataException.create(technicalMessage, userMessage);
		}
		
		this.connection = connection;
	}
	
	protected abstract String prepareSelect();
	
	protected abstract String prepareFrom();
	
	protected abstract String prepareWhere(E entity, List<Object> parameters);
	
	protected abstract String prepareOrderBy();
	
	protected abstract void setParameters(PreparedStatement preparedStament, List<Object> parameters);
	
	protected abstract List<E> executeQuery(PreparedStatement preparedStament);

}
