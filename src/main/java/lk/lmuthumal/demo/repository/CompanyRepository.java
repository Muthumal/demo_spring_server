package lk.lmuthumal.demo.repository;

import lk.lmuthumal.demo.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Integer> {
}
