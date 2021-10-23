package one.digitalinnovation.personapi.utils;

import java.time.LocalDate;
import java.util.Collections;

import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.entity.Person;

public class PersonUtils {
	
	private static final Long PERSON_ID = 1L;
	private static final String FIRST_NAME = "Pedro";
	private static final String LAST_NAME = "Paulo";
	private static final String CPF_NUMBER = "158.011.893-35";
	private static final LocalDate BIRTH_DATE = LocalDate.of(2000, 10, 10);
	
	public static PersonDTO createFakeDTO() {
		return PersonDTO.builder()
				.firstName(FIRST_NAME)
				.lastName(LAST_NAME)
				.cpf(CPF_NUMBER)
				.birthDate(BIRTH_DATE)
				.phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
				.build();
	}
	
	public static Person createFakeDEntity() {
		return Person.builder()
				.id(PERSON_ID)
				.firstName(FIRST_NAME)
				.lastName(LAST_NAME)
				.cpf(CPF_NUMBER)
				.birthDate(BIRTH_DATE)
				.phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
				.build();
	}

}
