package lk.lmuthumal.demo.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import lk.lmuthumal.demo.Entity.Company;
import lk.lmuthumal.demo.dto.CompanyDto;
import lk.lmuthumal.demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("api/v1/company")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @GetMapping
    public @ResponseBody List<Company> getCompanies(){
        return companyService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity insert(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("website") String website,
            @RequestParam(value = "file",required = false) MultipartFile file){
        byte[] image;
        try {
            image=file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Company company = new Company(name,email,image,website);
        companyService.insert(company);
//        companyService.insert(company);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public CompanyDto getCompanyId(@PathVariable("id") int id){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD,JsonAutoDetect.Visibility.ANY);
        Company byId = companyService.getById(id);
        return new CompanyDto(byId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public ResponseEntity updateCompany(@PathVariable("id") int id,
                                        @RequestParam("name") String name,
                                        @RequestParam("email") String email,
                                        @RequestParam("website") String website,
                                        @RequestParam(value = "file",required = false) MultipartFile file){
        byte[] image;
        if (!file.getOriginalFilename().equals("")){
            try {
                image=file.getBytes();

            } catch (IOException e) {
                e.printStackTrace();
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }else {
            image=companyService.getById(id).getLogo();
        }
        Company company = new Company(id,name,email,image,website);
        companyService.update(company);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCompany(@PathVariable int id){
        companyService.delete(id);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
