package com.cigil.forestfire.service;


import com.cigil.forestfire.config.SimulationConfig;
import com.cigil.forestfire.model.Cell;
import com.cigil.forestfire.model.CellState;
import com.cigil.forestfire.model.Grid;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ForestFireSimulationService {
    private final Grid grid;
    private final double propagationProbability;
    private final Random random = new Random();

    public ForestFireSimulationService(SimulationConfig config) {
        this.grid = new Grid(config.getGridHeight(), config.getGridWidth());
        this.propagationProbability = config.getPropagationProbability();
    }

    @PostConstruct
    public void initializeFire() {
        // Réinitialiser toute la grille à TREE avant d'allumer le feu
        for (int i = 0; i < grid.getHeight(); i++) {
            for (int j = 0; j < grid.getWidth(); j++) {
                grid.getCell(i, j).setState(CellState.TREE);
            }
        }

        // Allumer le feu au centre
        int centerX = grid.getHeight() / 2;
        int centerY = grid.getWidth() / 2;
        grid.igniteCell(centerX, centerY);
    }



    public void step() {
        Cell[][] nextState = new Cell[grid.getHeight()][grid.getWidth()];

        // Copie de la grille actuelle
        for (int i = 0; i < grid.getHeight(); i++) {
            for (int j = 0; j < grid.getWidth(); j++) {
                nextState[i][j] = new Cell(grid.getCell(i, j).getState());
            }
        }

        // Propagation du feu
        for (int i = 0; i < grid.getHeight(); i++) {
            for (int j = 0; j < grid.getWidth(); j++) {
                if (grid.getCell(i, j).getState() == CellState.FIRE) {
                    propagateFire(i, j, nextState);
                    nextState[i][j].setState(CellState.ASH);
                }
            }
        }

        // Appliquer les changements à la grille
        for (int i = 0; i < grid.getHeight(); i++) {
            for (int j = 0; j < grid.getWidth(); j++) {
                grid.getCell(i, j).setState(nextState[i][j].getState());
            }
        }
    }


    private void propagateFire(int x, int y, Cell[][] nextState) {
        int[][] directions = {
                {-1, 0}, {1, 0}, {0, -1}, {0, 1}, // Haut, Bas, Gauche, Droite
                {-1, -1}, {-1, 1}, {1, -1}, {1, 1} // Diagonales
        };

        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            if (newX >= 0 && newX < grid.getHeight() && newY >= 0 && newY < grid.getWidth()) {
                Cell adjacentCell = grid.getCell(newX, newY);

                if (adjacentCell.isFlammable()) {
                    double randomValue = random.nextDouble();
                    System.out.println("🔥 Checking fire propagation to (" + newX + ", " + newY + ")");
                    System.out.println("   → Random value: " + randomValue + " | Probability: " + propagationProbability);

                    if (randomValue < propagationProbability) {
                        System.out.println("🔥🔥 Fire spreads to (" + newX + ", " + newY + ")");
                        nextState[newX][newY].setState(CellState.FIRE);
                    }
                }
            }
        }
    }


    public boolean isSimulationOver() {
        for (int i = 0; i < grid.getHeight(); i++) {
            for (int j = 0; j < grid.getWidth(); j++) {
                if (grid.getCell(i, j).getState() == CellState.FIRE) {
                    return false;
                }
            }
        }
        return true;
    }

    public Cell[][] getGridState() {
        return grid.getGrid();
    }

}
