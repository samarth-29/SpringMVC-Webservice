package com.samarth.app.ws.service;

import java.util.List;

import com.samarth.app.ws.shared.dto.AddressDTO;

public interface AddressService {
	
	List<AddressDTO> getAddresses(String userId);

	AddressDTO getAddress(String addressId);

}
