package calculator.controller;

import calculator.domain.Calculator;
import calculator.domain.DelimiterExtractor;
import calculator.domain.Splitter;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String additionNumbers = inputView.inputAdditionNumbers();
        Calculator calculator = new Calculator(new DelimiterExtractor(), new Splitter());

        outputView.printResult(calculator.calculate(additionNumbers));
    }

}
