package com.gazorpazorp.model.dtoMapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.gazorpazorp.dto.CustomerDetailsDto;
import com.gazorpazorp.model.Customer;
import com.gazorpazorp.model.User;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

	CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
	
	@Mapping(source="customer.id", target="id")
	@Mapping(target="firstName")
	@Mapping(target="lastName")
	@Mapping(target="email")
	@Mapping(target="address")
	@Mapping(target="paymentMethod")
	CustomerDetailsDto customerAndUserToCustomerDetailsDto(Customer customer, User user);
	
	@Mapping(source="userId", target="id")
	@Mapping(target="firstName")
	@Mapping(target="lastName")
	@Mapping(target="email")
	User customerDetailsDtoToUser(CustomerDetailsDto dto, Long userId);
	
	@Mapping(source="dto.id", target="id")
	@Mapping(source="userId", target="userId")
	@Mapping(source="dto.address", target="address")
	@Mapping(source="dto.paymentMethod", target="paymentMethod")
	Customer customerDetailsDtoToCustomer(CustomerDetailsDto dto, Long userId);
}
