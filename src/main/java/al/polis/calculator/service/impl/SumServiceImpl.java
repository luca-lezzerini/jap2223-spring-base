package al.polis.calculator.service.impl;

import al.polis.calculator.service.SumService;
import org.springframework.stereotype.Service;

@Service
public class SumServiceImpl implements SumService {

    @Override
    public double calculateSumOfTwoNumbers(double x, double y) {
        return x + y;
    }

}
