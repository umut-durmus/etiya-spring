package com.etiya.ecommerce.api.controllers;


import com.etiya.ecommerce.core.utils.result.DataResult;
import com.etiya.ecommerce.services.concretes.AddressManager;
import com.etiya.ecommerce.services.dtos.requests.address.AddAddressRequest;
import com.etiya.ecommerce.services.dtos.responses.address.AddAddressResponse;
import com.etiya.ecommerce.services.dtos.responses.address.GetByIdAddressResponse;
import com.etiya.ecommerce.services.dtos.responses.address.ListAddressResponse;
import com.etiya.ecommerce.services.dtos.responses.customerOrderProduct.ListCustomerOrderProductResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@AllArgsConstructor
public class AddressesController {

    private final AddressManager addressManager;

    @GetMapping("/")
    public DataResult<List<ListAddressResponse>> getAllAddress() {
        return addressManager.getAll();
    }

    @PostMapping("/save")
    public DataResult<AddAddressResponse> createAddress(@Valid @RequestBody AddAddressRequest addAddressRequest) {
        return addressManager.addAddress(addAddressRequest);
    }

    @GetMapping("/{id}")
    public DataResult<GetByIdAddressResponse> getByIdAddress(@PathVariable Integer id) {
        return addressManager.addressGetById(id);
    }
    @GetMapping("page")
    public DataResult<Slice<ListAddressResponse>>getWithPage(@RequestParam int page,
                                                                          @RequestParam int size){
        Pageable pageable= PageRequest.of(page,size);
        return addressManager.getWithPagination(pageable);
    }
}
