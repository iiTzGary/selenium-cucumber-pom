package utils;


import java.util.List;
import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.*;
public class CustomListener implements EventListener {

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestStepStarted.class, this::onStepStart);
        publisher.registerHandlerFor(TestStepFinished.class, this::onStepFinish);
    }

    private void onStepStart(TestStepStarted event) {
        System.out.println("Step started: " + getStepText(event.getTestStep()));
    }

    private void onStepFinish(TestStepFinished event) {
        System.out.println("Step finished: " + getStepText(event.getTestStep()) +
                " | Result: " + event.getResult().getStatus());
    }

    private String getStepText(TestStep testStep) {
        List<String> stepTexts = testStep.getCodeLocation().lines().toList();
        return stepTexts.isEmpty() ? "[Undefined Step]" : stepTexts.get(0);
    }
}