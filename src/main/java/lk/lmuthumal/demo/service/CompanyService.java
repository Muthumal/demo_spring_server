package lk.lmuthumal.demo.service;

import lk.lmuthumal.demo.Entity.Company;
import lk.lmuthumal.demo.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@org.springframework.stereotype.Service
public class CompanyService implements Service<Company> {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company getById(int id) {
        return companyRepository.getOne(id);
    }

    @Override
    public void update(Company company) {
        companyRepository.save(company);
    }

    @Override
    public void delete(int id) {
        companyRepository.deleteById(id);
    }

    @Override
    public void insert(Company company) {
        companyRepository.save(company);
    }
}
