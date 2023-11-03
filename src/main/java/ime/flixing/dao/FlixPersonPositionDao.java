package ime.flixing.dao;

import ime.flixing.entity.FlixPersonPosition;

public interface FlixPersonPositionDao {

	FlixPersonPosition saveFlixPersonPosition(Long flixId, Long personId, Long positionId);
	void deleteFlixPersonPosition(Long flixId, Long personId, Long positionId);
	
}
