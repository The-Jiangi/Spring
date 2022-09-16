package jay.spring.service;

import jay.spring.dao.BankDao;
import jay.spring.entity.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BankDao bankDao;

    
}
