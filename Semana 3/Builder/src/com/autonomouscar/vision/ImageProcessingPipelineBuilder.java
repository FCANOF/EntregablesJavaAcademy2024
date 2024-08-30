package com.autonomouscar.vision;

import java.util.ArrayList;
import java.util.List;

public class ImageProcessingPipelineBuilder {
    private List<ImageProcessingStage> stages = new ArrayList<>();

    public ImageProcessingPipelineBuilder addStage(String stageName, String parameters) {
        stages.add(new ImageProcessingStage(stageName, parameters));
        return this;
    }

    public ImageProcessingPipeline build() {
        return new ImageProcessingPipeline(stages);
    }
}

