package com.colak.springtutorial.enumstrategy.loan;

import com.colak.springtutorial.enumstrategy.LoanRequest;
import com.colak.springtutorial.enumstrategy.LoanType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BigLoanStrategy implements ILoanStrategy {

    @Override
    public LoanType getCode() {
        return LoanType.BIG;
    }

    @Override
    public Boolean process(LoanRequest request) {
        log.info("big impl for {}", request);
        return true;
    }
}