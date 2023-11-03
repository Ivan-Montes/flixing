package ime.flixing.dao.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ime.flixing.entity.Flix;
import ime.flixing.entity.FlixPersonPositionId;
import ime.flixing.entity.Genre;
import ime.flixing.entity.Person;
import ime.flixing.entity.Position;

@ExtendWith(MockitoExtension.class)
class FlixPersonPositionDaoImplTest {
	@Mock
	private SessionFactory sessionFactory;
	
	@Mock
	private Session session;
	
	@Mock
	private Transaction transTest;
	
	@InjectMocks
	private PersonDaoImplTest personDaoImplTest;
	
	private Flix flixTest;
	private Long flixTestId = 1L;
	private Person personTest;
	private Long personTestId = 1L;
	private Position positionTest;
	private Long positionTestId = 1L;
	private FlixPersonPositionId flixPersonPositionIdTest;
	
	@BeforeEach
	private void createObjects() {
		
		flixTest = new Flix();
		flixTest.setFlixId(flixTestId);
		flixTest.setTitle("Test Title");
		flixTest.setGenre(new Genre());
		flixTest.setFlixPersonPosition(null);

		personTest = new Person();
		personTest.setPersonId(personTestId);
		personTest.setName("Taro");
		personTest.setSurname("Misaki");
		
		positionTest = new Position();
		positionTest.setPositionId(positionTestId);
		positionTest.setName("Master");
		positionTest.setDescription("Leader in dungeon");
		
		flixPersonPositionIdTest = new FlixPersonPositionId(flixTestId, personTestId, positionTestId);	
	}
	
	@Test
	void test() {
		assertTrue( true );
	}

}
