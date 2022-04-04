package com.example.assignment.controller;

import com.example.assignment.common.ContextURL;
import com.example.assignment.dto.FormProductDto;
import com.example.assignment.dto.ResponseDto;
import com.example.assignment.entity.Product;
import com.example.assignment.exception.NotExistException;
import com.example.assignment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping(path = ContextURL.API_URL)
public class ProductRestController {

    @Autowired
    ProductService productService;

    @GetMapping(path = ContextURL.PRODUCT_FIND_ALL)
    public ResponseEntity<?> findAll(@RequestParam("page")Optional<Integer> page){
        Pageable pageable = PageRequest.of(page.orElse(1) - 1, 8);
        return ResponseEntity.ok().body(productService.findAll(pageable));
    }
    
    @PostMapping(path = ContextURL.PRODUCT_SAVE)
    public ResponseEntity<?> save(@Valid @RequestBody FormProductDto dto){
        Product product = dto.transfer();
        return ResponseEntity.ok(productService.save(product));
    }

    @PostMapping(path = ContextURL.PRODUCT_UPDATE)
    public ResponseEntity<?> update(@Valid @RequestBody FormProductDto dto,
                                    @PathVariable("id") Optional<Integer> id) throws NotExistException {
        Product product = dto.transfer();
        product.setId(id.orElse(null));
        return ResponseEntity.ok().body(productService.update(product));
    }

    @GetMapping(path = ContextURL.PRODUCT_DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") Optional<Integer> id) throws NotExistException {
        productService.delete(id.orElse(null));
        return ResponseEntity.ok().body(new ResponseDto(400, String.format("Product with id %d is In_Active now", id.get())));
    }

    @GetMapping(path = ContextURL.PRODUCT_FIND_BY_ID)
    public ResponseEntity<?> findById(@PathVariable("id") Optional<Integer> id) throws NotExistException {
        return ResponseEntity.ok().body(productService.findById(id.orElse(null)));
    }

    @GetMapping(path = ContextURL.PRODUCT_PAGE_COUNT)
    public ResponseEntity<?> countPage(){
        return ResponseEntity.ok().body(productService.countPage(PageRequest.of(0, 8)));
    }
}
