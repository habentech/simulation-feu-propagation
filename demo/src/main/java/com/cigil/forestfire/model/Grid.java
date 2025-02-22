package com.cigil.forestfire.model;

public class Grid {
    private final int height;
    private final int width;
    private final Cell[][] grid;

    public Grid(int height, int width) {
        this.height = height;
        this.width = width;
        this.grid = new Cell[height][width];
        initializeGrid();
    }

    private void initializeGrid() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = new Cell(CellState.TREE);
            }
        }
    }

    public void igniteCell(int x, int y) {
        if (x >= 0 && x < height && y >= 0 && y < width) {
            grid[x][y].setState(CellState.FIRE);
        }
    }

    public Cell getCell(int x, int y) {
        return grid[x][y];
    }
    public Cell[][] getGrid() {
        return grid;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
