package com.cigil.forestfire.model;

public class Cell {
    private CellState state;

    public Cell(CellState state) {
        this.state = state;
    }

    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }

    public boolean isFlammable() {
        return this.state == CellState.TREE;
    }
}
