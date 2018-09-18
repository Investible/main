package com.codeup.investible.Repository;

import com.codeup.investible.Models.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Long> {
    Company findByTicker(String ticker);
}