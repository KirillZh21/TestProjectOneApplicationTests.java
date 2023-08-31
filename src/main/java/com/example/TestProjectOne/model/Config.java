package com.example.TestProjectOne.model;


import java.time.LocalDateTime;
import java.util.List;

public class Config {

    private int numberContainer;
    private LocalDateTime timeEmulation;
    private double maxTimeShift;
    private double stepRecording;
    private int numberStep;
    private List<Parameters> parameters;
    private int messageInterval;

    public int getNumberContainer() {
        return numberContainer;
    }

    public void setNumberContainer(int numberContainer) {
        this.numberContainer = numberContainer;
    }

    public LocalDateTime getTimeEmulation() {
        return timeEmulation;
    }

    public void setTimeEmulation(LocalDateTime timeEmulation) {
        this.timeEmulation = timeEmulation;
    }

    public double getMaxTimeShift() {
        return maxTimeShift;
    }

    public void setMaxTimeShift(double maxTimeShift) {
        this.maxTimeShift = maxTimeShift;
    }

    public double getStepRecording() {
        return stepRecording;
    }

    public void setStepRecording(double stepRecording) {
        this.stepRecording = stepRecording;
    }

    public int getNumberStep() {
        return numberStep;
    }

    public void setNumberStep(int numberStep) {
        this.numberStep = numberStep;
    }

    public List<Parameters> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameters> parameters) {
        this.parameters = parameters;
    }

    public int getMessageInterval() {
        return messageInterval;
    }

    public void setMessageInterval(int messageInterval) {
        this.messageInterval = messageInterval;
    }
}


