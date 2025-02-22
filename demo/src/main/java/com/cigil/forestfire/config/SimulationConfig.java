package com.cigil.forestfire.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "simulation")
public class SimulationConfig {
    private int gridHeight;
    private int gridWidth;
    private double propagationProbability;

    public int getGridHeight() {
        return gridHeight;
    }

    public void setGridHeight(int gridHeight) {
        this.gridHeight = gridHeight;
    }

    public int getGridWidth() {
        return gridWidth;
    }

    public void setGridWidth(int gridWidth) {
        this.gridWidth = gridWidth;
    }

    public double getPropagationProbability() {
        return propagationProbability;
    }

    public void setPropagationProbability(double propagationProbability) {
        this.propagationProbability = propagationProbability;
    }
}