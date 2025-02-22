package com.cigil.forestfire.controller;

import com.cigil.forestfire.model.Cell;
import com.cigil.forestfire.service.ForestFireSimulationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/simulation")
public class SimulationController {
    private final ForestFireSimulationService simulationService;

    public SimulationController(ForestFireSimulationService simulationService) {
        this.simulationService = simulationService;
    }

    @PostMapping("/initialize")
    public ResponseEntity<Map<String, Object>> initializeSimulation() {
        simulationService.initializeFire();

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Simulation initialized");
        response.put("grid", formatGrid(simulationService.getGridState()));

        return ResponseEntity.ok(response);
    }

    @PostMapping("/step")
    public ResponseEntity<Map<String, Object>> nextStep() {
        List<String> previousState = formatGrid(simulationService.getGridState());
        simulationService.step();
        List<String> currentState = formatGrid(simulationService.getGridState());

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Step executed");
        response.put("simulationOver", simulationService.isSimulationOver());
        response.put("previousState", previousState);
        response.put("currentState", currentState);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/status")
    public ResponseEntity<Map<String, Boolean>> isSimulationOver() {
        Map<String, Boolean> response = new HashMap<>();
        response.put("simulationOver", simulationService.isSimulationOver());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/grid")
    public ResponseEntity<List<String>> getGridState() {
        return ResponseEntity.ok(formatGrid(simulationService.getGridState()));
    }

//    private List<String> formatGrid(Cell[][] grid) {
//        List<String> formattedGrid = new ArrayList<>();
//        for (Cell[] row : grid) {
//            StringBuilder sb = new StringBuilder();
//            for (Cell cell : row) {
//                switch (cell.getState()) {
//                    case TREE -> sb.append("🌳");
//                    case FIRE -> sb.append("🔥");
//                    case ASH -> sb.append("⚫");
//                }
//            }
//            formattedGrid.add(sb.toString());
//        }
//        return formattedGrid;
//    }

    private List<String> formatGrid(Cell[][] grid) {
        List<String> formattedGrid = new ArrayList<>();
        for (Cell[] row : grid) {
            StringBuilder sb = new StringBuilder();
            for (Cell cell : row) {
                switch (cell.getState()) {
                    case TREE -> sb.append("TREE ");
                    case FIRE -> sb.append("FIRE ");
                    case ASH -> sb.append("ASH ");
                }
            }
            formattedGrid.add(sb.toString().trim());
        }
        return formattedGrid;
    }

}