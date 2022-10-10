package com.jay.service.impl;

import com.jay.bean.Bank;
import com.jay.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jay.mapper.*;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    BankMapper bankMapper;

    @Override
    public Bank getBankById(Long id) {
        return bankMapper.getBank(id);
    }
}
