package org.example.aniix.controller;

import org.example.aniix.dtos.CategoryDTO;
import org.example.aniix.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/category-api")
@CrossOrigin
public class CategoryRestController {
 @Autowired
 private ICategoryService categoryService;
    @GetMapping("/get-all-category")
    ResponseEntity<?> getAllCategory(){
     return ResponseEntity.ok(categoryService.getAll());
    }
    @PostMapping("/add-new-category")
    ResponseEntity<?> addCategory(@RequestBody CategoryDTO categoryDTO){
        return ResponseEntity.ok(categoryService.insert(categoryDTO));
    }
    @PutMapping("/update-category")
    public ResponseEntity<?> updateCategory(@RequestBody CategoryDTO categoryDTO){
        categoryService.update(categoryDTO);

        return ResponseEntity.ok("update category complete");
    }
    @DeleteMapping("/delete-category/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id")Long id){
        Map<String,String> responseMessage = new HashMap<>();
        responseMessage.put("message","delete complete");
        categoryService.delete(id);
        return ResponseEntity.ok(responseMessage);
    }
 }
