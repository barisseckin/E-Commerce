package com.eCommerceProject.service;

import com.eCommerceProject.model.Address;
import com.eCommerceProject.model.User;
import com.eCommerceProject.repository.AddressRepository;
import com.eCommerceProject.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService{
    
    private final AddressRepository addressRepository;
    
    private final UserService userService;
    
    @Override
    public Address add(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        addressRepository.deleteById(id);
    }

    @Override
    public List<Address> getAddressByUserId(int userId) {
        Optional<User> user = Optional.ofNullable(userService.getById(userId));
        List<Address> addressesResponse = new ArrayList<>();
        
        if (user.isPresent()) {
            for (Address address : user.get().getAddress()) {
                addressesResponse.add(address);
            }
            return addressesResponse;
        }
        return null;
    }

    @Override
    public Address getById(int id) {
        Optional<Address> address = addressRepository.findById(id);
        return address.orElse(null);
    }
}