package co.edu.uco.publiuco.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.crosscutting.exception.PubliucoDataException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilSql;
import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;
import co.edu.uco.publiuco.data.dao.EstadoTipoRelacionInstitucionDAO;
import co.edu.uco.publiuco.data.dao.relational.SqlDAO;
import co.edu.uco.publiuco.entities.EstadoTipoRelacionInstitucionEntity;

public class EstadoTipoRelacionInstitucionSqlServerDAO extends SqlDAO <EstadoTipoRelacionInstitucionEntity> implements EstadoTipoRelacionInstitucionDAO {

	public EstadoTipoRelacionInstitucionSqlServerDAO(final Connection connection) {
		super(connection);
		
	}
	
	
	@Override
	public final void create(EstadoTipoRelacionInstitucionEntity entity) {
		
		var sqlStament = "INSERT INTO EstadoTipoRelacionInstitucion(identificador, nombre, descripcion VALUES (?, ?, ?, ?))";

		try (var preparedStatement = getConnection().prepareStatement(sqlStament)) {
			preparedStatement.setObject(1, entity.getIdentificador());
			preparedStatement.setString(2, entity.getNombre());
			preparedStatement.setString(3, entity.getDescripcion());
			
			preparedStatement.executeUpdate();
		}catch (final SQLException exception) {
			var userMessage = "Se ha presentado un problema tratando de registrar la informacion del nuevo estado tipo relacion institucion";
			var technicalMessage ="Se ha presentado un problema de tipo SQLException dentro del metodo create de la clase EstadoTipoRelacionInstitucionSqlServerDAO, Por favor verifique la traza completa del error";
			
			throw PubliucoDataException.create(technicalMessage, userMessage, exception);
		}catch (final Exception exception) {
			var userMessage = "Se ha presentado un problema inesperado tratando de registrar la informacion del nuevo estado tipo relacion institucion";
			var technicalMessage ="Se ha presentado un problema inesperado dentro del metodo create de la clase EstadoTipoRelacionInstitucionSqlServerDAO, Por favor verifique la traza completa del error";
			throw PubliucoDataException.create(technicalMessage, userMessage, exception);
		}	
	
	}

	@Override
	public final List<EstadoTipoRelacionInstitucionEntity> read(final EstadoTipoRelacionInstitucionEntity entity) {
		var sqlStatement = new StringBuilder();
		var parameters = new ArrayList<>();
		
		sqlStatement.append(prepareSelect());
		sqlStatement.append(prepareFrom());
		sqlStatement.append(prepareWhere(entity, parameters));
		sqlStatement.append(prepareOrderBy());
		
		try (var preparedStament = getConnection().prepareStatement(sqlStatement.toString())){
			
			setParameters(preparedStament, parameters);
			
			return executeQuery(preparedStament);
			
		}catch (PubliucoException exception) {
			throw exception;
			
		}catch (final SQLException exception) {
				var userMessage = "Se ha presentado un problema tratando de consultar la informacion de los estados de los tipos relacion institucion";
				var technicalMessage ="Se ha presentado un problema de  SQLException dentro del metodo read de la clase EstadoTipoRelacionInstitucionSqlServerDAO, Por favor verifique la traza completa del error";
				
				throw PubliucoDataException.create(technicalMessage, userMessage, exception);
			
		}catch (final Exception exception) {
			var userMessage = "Se ha presentado un problema inesperado tratando de consultar la informacion del nuevo estado tipo relacion institucion";
			var technicalMessage ="Se ha presentado un problema inesperado dentro del metodo executeQuery de la clase EstadoTipoRelacionInstitucionSqlServerDAO, Por favor verifique la traza completa del error";
			
			throw PubliucoDataException.create(technicalMessage, userMessage, exception);
			
		}
	}

	@Override
	public final void update(EstadoTipoRelacionInstitucionEntity entity) {
		var sqlStament = "UPDATE EstadoTipoRelacionInstitucion SET nombre=?, descripcion = ? WHERE identificador=?)";

		try (var preparedStatement = getConnection().prepareStatement(sqlStament)) {
			preparedStatement.setString(1, entity.getNombre());
			preparedStatement.setString(2, entity.getDescripcion());
			preparedStatement.setObject(3, entity.getIdentificador());
			
			preparedStatement.executeUpdate();
		}catch (final SQLException exception) {
			var userMessage = "Se ha presentado un problema tratando de modificar la informacion del nuevo estado tipo relacion institucion";
			var technicalMessage ="Se ha presentado un problema de tipo SQLException dentro del metodo update de la clase EstadoTipoRelacionInstitucionSqlServerDAO, Por favor verifique la traza completa del error";
			
			throw PubliucoDataException.create(technicalMessage, userMessage, exception);
		}catch (final Exception exception) {
			var userMessage = "Se ha presentado un problema inesperado tratando de mofificar la informacion del nuevo estado tipo relacion institucion";
			var technicalMessage ="Se ha presentado un problema inesperado dentro del metodo update de la clase EstadoTipoRelacionInstitucionSqlServerDAO, Por favor verifique la traza completa del error";
			throw PubliucoDataException.create(technicalMessage, userMessage, exception);
		}
		
		
	}

	@Override
	public final void delete(EstadoTipoRelacionInstitucionEntity entity) {
		var sqlStament = "DELETE FROM EstadoTipoRelacionInstitucion WHERE identificador=?)";

		try (var preparedStatement = getConnection().prepareStatement(sqlStament)) {
			preparedStatement.setObject(1, entity.getIdentificador());
			
			preparedStatement.executeUpdate();
		}catch (final SQLException exception) {
			var userMessage = "Se ha presentado un problema tratando de eliminar la informacion del nuevo estado tipo relacion institucion";
			var technicalMessage ="Se ha presentado un problema de tipo SQLException dentro del metodo delete de la clase EstadoTipoRelacionInstitucionSqlServerDAO, Por favor verifique la traza completa del error";
			
			throw PubliucoDataException.create(technicalMessage, userMessage, exception);
		}catch (final Exception exception) {
			var userMessage = "Se ha presentado un problema inesperado tratando de eliminar la informacion del nuevo estado tipo relacion institucion";
			var technicalMessage ="Se ha presentado un problema inesperado dentro del metodo delete de la clase EstadoTipoRelacionInstitucionSqlServerDAO, Por favor verifique la traza completa del error";
			throw PubliucoDataException.create(technicalMessage, userMessage, exception);
		}
		
		
		
	}


	@Override
	protected String prepareSelect() {
		return "SELECT identificador, nombre, descripcion ";
	}


	@Override
	protected String prepareFrom() {
		return "FROM EstadoTipoRelacionInstitucion";
	}


	@Override
	protected String prepareWhere(final EstadoTipoRelacionInstitucionEntity entity, List<Object> parameters) {
		final var where = new StringBuilder("");
		parameters = UtilObject.getDefault(parameters, new ArrayList<>());
		
		var setWhere = true;
		
		if(!UtilObject.isNull(entity)) {
			
			if(!UtilUUID.isDefault(entity.getIdentificador())) {
				parameters.add(entity.getIdentificador());
				where.append("WHERE identificador=? ");
				setWhere = false;
			}
			
			if(!UtilText.getUtilText().isEmpty(entity.getNombre())) {
				parameters.add(entity.getNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("nombre=? ");
				setWhere = false;
			}
			if(!UtilText.getUtilText().isEmpty(entity.getDescripcion())) {
				parameters.add(entity.getDescripcion());
				where.append("WHERE descripcion LIKE %?% ");
	
			}
			
		}
		
		return where.toString();
	}


	@Override
	protected String prepareOrderBy() {
		return "ORDER BY nombre ASC";
	}


	@Override
	protected final void setParameters(final PreparedStatement preparedStament, final List<Object> parameters) {
		try {
			
		if(!UtilObject.isNull(parameters) && !UtilObject.isNull(preparedStament)){
			for(int index = 0; index < parameters.size(); index ++) {
				preparedStament.setObject(index + 1, parameters.get(index));
			}
		}
	}catch (final SQLException exception) {
		var userMessage = "Se ha presentado un problema tratando de consultar la informacion de los estados de los tipos relacion institucion";
		var technicalMessage ="Se ha presentado un problema de  SQLException dentro del metodo setParameters de la clase EstadoTipoRelacionInstitucionSqlServerDAO, Por favor verifique la traza completa del error";
		
		throw PubliucoDataException.create(technicalMessage, userMessage, exception);
	}catch (final Exception exception) {
		var userMessage = "Se ha presentado un problema inesperado tratando de consultar la informacion del nuevo estado tipo relacion institucion";
		var technicalMessage ="Se ha presentado un problema inesperado dentro del metodo setParameters de la clase EstadoTipoRelacionInstitucionSqlServerDAO, Por favor verifique la traza completa del error";
		throw PubliucoDataException.create(technicalMessage, userMessage, exception);
	}
		
	}


	@Override
	protected List<EstadoTipoRelacionInstitucionEntity> executeQuery(PreparedStatement preparedStament) {
		
		try(var resultSet = preparedStament.executeQuery()){
			
			final List<EstadoTipoRelacionInstitucionEntity> result = new ArrayList<>();
			
			while(resultSet.next()) {
				var entityTmp = new EstadoTipoRelacionInstitucionEntity(resultSet.getObject("identificador", UUID.class),
						resultSet.getString("nombre"), resultSet.getString("descripcion"));
				
				result.add(entityTmp);
			}
			
		}catch (final SQLException exception) {
			var userMessage = "Se ha presentado un problema tratando de consultar la informacion de los estados de los tipos relacion institucion";
			var technicalMessage ="Se ha presentado un problema de  SQLException dentro del metodo executeQuery de la clase EstadoTipoRelacionInstitucionSqlServerDAO, Por favor verifique la traza completa del error";
			
			throw PubliucoDataException.create(technicalMessage, userMessage, exception);
		}catch (final Exception exception) {
			var userMessage = "Se ha presentado un problema inesperado tratando de consultar la informacion del nuevo estado tipo relacion institucion";
			var technicalMessage ="Se ha presentado un problema inesperado dentro del metodo executeQuery de la clase EstadoTipoRelacionInstitucionSqlServerDAO, Por favor verifique la traza completa del error";
			throw PubliucoDataException.create(technicalMessage, userMessage, exception);
		}
		return null;
	}

}
