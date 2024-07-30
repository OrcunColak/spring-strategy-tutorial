package com.colak.springtutorial.enumstrategy.loan;

import com.colak.springtutorial.enumstrategy.LoanRequest;
import com.colak.springtutorial.enumstrategy.LoanType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class HugeLoanStrategy implements ILoanStrategy {

    @Override
    public Boolean process(LoanRequest request) {
        log.info("huge impl for {}", request);
        return true;
    }

    @Override
    public LoanType getCode() {
        return LoanType.HUGE;
    }
}

