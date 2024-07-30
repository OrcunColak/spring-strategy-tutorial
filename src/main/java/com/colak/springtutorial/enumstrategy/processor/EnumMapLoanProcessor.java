package com.colak.springtutorial.enumstrategy.processor;

import com.colak.springtutorial.enumstrategy.LoanRequest;
import com.colak.springtutorial.enumstrategy.LoanType;
import com.colak.springtutorial.enumstrategy.loan.ILoanStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EnumMapLoanProcessor {

    private final Map<LoanType, ILoanStrategy> loanProcessors;

    public EnumMapLoanProcessor(List<ILoanStrategy> processors) {
        loanProcessors = processors.stream()
                .collect(Collectors.toMap(
                        ILoanStrategy::getCode,
                        Function.identity(),
                        (l, r) -> {
                            throw new IllegalArgumentException("Duplicate keys " + l + "and " + r + ".");
                        },
                        () -> new EnumMap<>(LoanType.class)
                ));
    }


    public Boolean process(LoanRequest request) {
        ILoanStrategy processor = loanProcessors.get(request.getLoanType());
        Objects.requireNonNull(processor, "No processor for " + request.getLoanType() + " found");
        return processor.evaluate(request);
    }
}
