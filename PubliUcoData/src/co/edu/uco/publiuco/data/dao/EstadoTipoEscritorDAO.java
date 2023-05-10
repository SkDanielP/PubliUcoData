package co.edu.uco.publiuco.data.dao;
import java.util.List;

import co.edu.uco.publiuco.entities.EstadoTipoEscritorEntity;

public interface EstadoTipoEscritorDAO {
	
	void create(EstadoTipoEscritorEntity entity);
	
	List<EstadoTipoEscritorEntity> read(EstadoTipoEscritorEntity entity);
	
	void update(EstadoTipoEscritorEntity entity);
	
	void delete(EstadoTipoEscritorEntity entity);
}
