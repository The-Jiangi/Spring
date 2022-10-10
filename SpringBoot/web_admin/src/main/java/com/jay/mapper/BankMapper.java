package com.jay.mapper;

import com.jay.bean.Bank;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BankMapper {

    Bank getBank(Long id);

}
