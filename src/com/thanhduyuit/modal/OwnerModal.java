package com.thanhduyuit.modal;

import java.util.ArrayList;
import java.util.List;

public class OwnerModal extends UserModal {

	
	private List<PitchModal> listPitchs = new ArrayList<PitchModal>();
	
	
	public OwnerModal(String username, String password, String fullName, String email, String phoneNumber,
			String userType, String note) {
		super(username, password, fullName, email, phoneNumber, userType, note);
		// TODO Auto-generated constructor stub
	}


	public OwnerModal() {
		// TODO Auto-generated constructor stub
	}

}
