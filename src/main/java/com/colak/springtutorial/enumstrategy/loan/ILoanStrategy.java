package com.colak.springtutorial.enumstrategy.loan;

import com.colak.springtutorial.enumstrategy.LoanRequest;
import com.colak.springtutorial.enumstrategy.LoanType;

public interface ILoanStrategy {

    LoanType getCode();

    Boolean process(LoanRequest request);

    default Boolean evaluate(LoanRequest request) {
        if (getCode() != request.getLoanType()) {
            throw new IllegalArgumentException("Wrong loan type " + request.getLoanType() + ". Only " + getCode() + " supported");
        }
        return process(request);
    }
}
