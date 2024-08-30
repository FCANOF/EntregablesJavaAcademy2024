package com.autonomouscar.vision;

import java.util.List;

public class ImageProcessingPipeline {
    private List<ImageProcessingStage> stages;

    public ImageProcessingPipeline(List<ImageProcessingStage> stages) {
        this.stages = stages;
    }

    public void execute() {
        stages.forEach(stage -> System.out.println(stage));
    }
}