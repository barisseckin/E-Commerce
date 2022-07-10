package com.eCommerceProject.api;

import com.eCommerceProject.model.Address;
import com.eCommerceProject.service.AddressService;
import com.eCommerceProject.shared.ECommerceMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address/")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody Address address) {
        addressService.add(address);
        return ResponseEntity.ok(ECommerceMessage.ADDRESS_CREATED);
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(addressService.getAll());
    }

    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        addressService.deleteById(id);
        return ResponseEntity.ok(ECommerceMessage.ADDRESS_DELETED);
    }

    @GetMapping("getAddressByUserId/{userId}")
    public ResponseEntity<?> getAddressByUserId(@PathVariable int userId) {
        return ResponseEntity.ok(addressService.getAddressByUserId(userId));
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return ResponseEntity.ok(addressService.getById(id));
    }

}
