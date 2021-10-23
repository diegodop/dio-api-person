package one.digitalinnovation.personapi.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.repository.PersonRepository;
import one.digitalinnovation.personapi.utils.PersonUtils;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
	
	@Mock
	private PersonRepository personRepository;
	
	@InjectMocks
	private PersonService personService;
	
	@Test
	void testGivenPersonDTOThenReturnSavedMessage() {
		PersonDTO personDTO = PersonUtils.createFakeDTO();
		Person expectedSavedPerson = PersonUtils.createFakeDEntity();
		
		Mockito.when(personRepository.save(Mockito.any(Person.class))).thenReturn(expectedSavedPerson);
		
		MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedPerson.getId(), "Created person with ID = ");
		
		MessageResponseDTO successMessage = personService.createPerson(personDTO);
		
		Assertions.assertEquals(expectedSuccessMessage, successMessage);
	}

	private MessageResponseDTO createExpectedMessageResponse(Long id, String message) {
		return MessageResponseDTO.builder()
				.message(message + id)
				.build();
	}
	

}
