package com.autonomouscar.vision;

public class VisionSystem {
    public static void main(String[] args) {
        ImageProcessingPipelineBuilder builder = new ImageProcessingPipelineBuilder();

        ImageProcessingPipeline pipeline = builder
            .addStage("Image Loader", "multisense_camera")
            .addStage("Preprocessing Filter", "GaussianBlur")
            .addStage("Object Detector", "YOLOv8")
            .addStage("Pedestrian Detector", "YOLOv8")
            .addStage("Lane Segmentation", "HoughTransform")
            .build();

        pipeline.execute();
    }

}
