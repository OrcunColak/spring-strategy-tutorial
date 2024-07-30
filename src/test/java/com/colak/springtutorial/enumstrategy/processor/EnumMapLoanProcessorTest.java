package com.colak.springtutorial.enumstrategy.processor;

import com.colak.springtutorial.enumstrategy.LoanRequest;
import com.colak.springtutorial.enumstrategy.LoanType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EnumMapLoanProcessorTest {

    @Autowired
    private EnumMapLoanProcessor processor;

    @Test
    void process() {

        LoanRequest loanRequest = LoanRequest.builder()
                .loanType(LoanType.SMALL)
                .loanSum(new BigDecimal("123"))
                .build();

        Boolean process = processor.process(loanRequest);

        assertThat(process).isTrue();
    }
}