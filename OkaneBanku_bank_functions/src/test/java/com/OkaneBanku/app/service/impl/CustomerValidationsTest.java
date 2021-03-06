package com.OkaneBanku.app.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.OkaneBanku.app.model.customer;

class CustomerValidationsTest {
	
	@BeforeAll
	public static void setupService() {
		
	}
	
	@Test
	void testIsFirstNameValidletters() {
		assertEquals(true, (CustomerValidations.isFirstNameValid("s")));
	}
	@Test
	void testIsFirstNameValidNull() {
		assertEquals(false, CustomerValidations.isFirstNameValid(null));
	}
	

	@Test
	void testIsLastNameValidletters() {
		assertEquals(true, (CustomerValidations.isLastNameValid("sss")));
	}
	@Test
	void testIsLastNameValidNull() {
		assertEquals(false, CustomerValidations.isLastNameValid(null));
	}

	@Test
	void testIsPasswordValidl() {
		assertFalse(CustomerValidations.isPasswordValid("sadfsd"));
	}
	
	@Test
	void testIsPasswordValid() {
		assertTrue(CustomerValidations.isPasswordValid("1!Stevennnnnnnn1!"));
	}
	
	void isAmountValidnulllessthan0(){
		assertFalse(CustomerValidations.isAmountValid(-100));
	}
	void isAmountValid(){
		assertTrue(CustomerValidations.isAmountValid(100));
	}
	
	@ParameterizedTest(name = "#{index} - Run test with username = {0}")
    @MethodSource("validUsernameProvider")
    void test_username_regex_valid(String username) {
        assertTrue(CustomerValidations.isUsernameValid(username));
    }

    @ParameterizedTest(name = "#{index} - Run test with username = {0}")
    @MethodSource("invalidUsernameProvider")
    void test_username_regex_invalid(String username) {
        assertFalse(CustomerValidations.isUsernameValid(username));
    }

    static Stream<String> validUsernameProvider() {
        return Stream.of(
                "mkyong",
                "javaregex",
                "JAVAregex",
                "java.regex",
                "java-regex",
                "java_regex",
                "java.regex.123",
                "java-regex-123",
                "java_regex_123",
                "javaregex123",
                "123456",
                "java123",
                "01234567890123456789");
    }

    static Stream<String> invalidUsernameProvider() {
        return Stream.of(
                "abc",                      // invalid length 3, length must between 5-20
                "01234567890123456789a",    // invalid length 21, length must between 5-20
                "_javaregex_",              // invalid start and last character
                ".javaregex.",              // invalid start and last character
                "-javaregex-",              // invalid start and last character
                "javaregex#$%@123",         // invalid symbols, support dot, hyphen and underscore
                "java..regex",              // dot cant appear consecutively
                "java--regex",              // hyphen can't appear consecutively
                "java__regex",              // underscore can't appear consecutively
                "java._regex",              // dot and underscore can't appear consecutively
                "java.-regex",              // dot and hyphen can't appear consecutively
                " ",                        // empty
                "");                        // empty
    }

}


