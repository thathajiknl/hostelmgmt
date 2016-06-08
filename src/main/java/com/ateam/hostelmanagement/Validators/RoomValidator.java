package com.ateam.hostelmanagement.Validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ateam.hostelmanagement.hosteldaoimpl.Room;
@Component
public class RoomValidator implements Validator {

	
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Room.class.isAssignableFrom(arg0);
	}

	
	public void validate(Object arg0, Errors errors) {
		// TODO Auto-generated method stub
		Room room=(Room)arg0;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"roomNumber","required.roomNumber" ,"room number is required" );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"noOfBeds","required.noOfBeds" ,"no of beds is required" );
	}

}
