package com.autonomouscar.vision;

public class ImageProcessingStage {
    private String stageName;
    private String parameters;

    public ImageProcessingStage(String stageName, String parameters) {
        this.stageName = stageName;
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "Stage: " + stageName + ", Parameters: " + parameters;
    }
}