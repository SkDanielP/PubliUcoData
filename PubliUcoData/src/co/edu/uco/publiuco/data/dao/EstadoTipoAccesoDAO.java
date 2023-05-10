package co.edu.uco.publiuco.data.dao;
import java.util.List;

import co.edu.uco.publiuco.entities.EstadoTipoAccesoEntity;

public interface EstadoTipoAccesoDAO {
	
	void create(EstadoTipoAccesoEntity entity);
	
	List<EstadoTipoAccesoEntity> read(EstadoTipoAccesoEntity entity);
	
	void update(EstadoTipoAccesoEntity entity);
	
	void delete(EstadoTipoAccesoEntity entity);
}
