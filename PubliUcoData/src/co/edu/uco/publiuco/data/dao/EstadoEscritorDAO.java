package co.edu.uco.publiuco.data.dao;

import java.util.List;

import co.edu.uco.publiuco.entities.EstadoEscritorEntity;

public interface EstadoEscritorDAO {
	
	void create(EstadoEscritorEntity entity);
	
	List<EstadoEscritorEntity> read(EstadoEscritorEntity entity);
	
	void update(EstadoEscritorEntity entity);
	
	void delete(EstadoEscritorEntity entity);
}
