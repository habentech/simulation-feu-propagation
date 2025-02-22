
import React, { useState, useEffect, useCallback  } from "react";
import { Button, Container, Table, Modal } from "react-bootstrap";
import CellState from "./CellState";



const API_URL = "http://localhost:8080/simulation";

const ForestFireSimulation = () => {
  const [grid, setGrid] = useState([]);
  const [simulationOver, setSimulationOver] = useState(false);
  const [isRunning, setIsRunning] = useState(false);
  const [showModal, setShowModal] = useState(false);



  const fetchGrid = async () => {
    try {
      const response = await fetch(`${API_URL}/grid`);
      const data = await response.json();

      const formattedGrid = data.map(row => row.split(" "));

      setGrid(formattedGrid);
      setSimulationOver(false);
    } catch (error) {
      console.error("Error fetching grid:", error);
    }
  };



  const initializeSimulation = async () => {
    try {
      const response = await fetch(`${API_URL}/initialize`, { method: "POST" });
      let data = await response.json();
      data = data.grid.map(row => row.split(" "))
      setGrid(data);
      setSimulationOver(false);
    } catch (error) {
      console.error("Error initializing simulation:", error);
    }
  };


const executeStep = useCallback(async () => {
  if (simulationOver) {
    setIsRunning(false);
    return;
  }
  try {
    const response = await fetch(`${API_URL}/step`, { method: "POST" });
    const data = await response.json();

    const formattedGrid = data.currentState.map(row => row.split(" "));
    setGrid(formattedGrid);
    setSimulationOver(data.simulationOver);

    if (data.simulationOver) {
      setIsRunning(false);
      setShowModal(true);
    }
  } catch (error) {
    console.error("Error executing step:", error);
  }
}, [simulationOver]);

useEffect(() => {
  let interval;

  const startSimulation = async () => {
    await fetchGrid(); // ✅ Charge la grille avant de commencer
    setIsRunning(true); // ✅ Active l'exécution automatique

    interval = setInterval(async () => {
      await executeStep();
    }, 2000);
  };

  if (isRunning) {
    startSimulation();
  }

  return () => clearInterval(interval);
}, [isRunning, executeStep]); // 🔹 executeStep ajouté pour éviter l'erreur
    
  return (
    <Container className="mt-4 text-center">
      <h1 className="mb-4">Forest Fire Simulation</h1>
      <Table bordered className="mx-auto w-auto">
        <tbody>
          {grid.map((row, rowIndex) => (
            <tr key={rowIndex}>
              {row.map((cell, colIndex) => (
                <td key={colIndex} className="text-center" style={{ fontSize: "1em", padding: "5px", border: "1px solid black" }}>
                  {cell === CellState.TREE ? "🌳" : cell === CellState.FIRE ? "🔥" : "⚫"}
                </td>
              ))}
            </tr>
          ))}
        </tbody>
      </Table>

      <div className="mt-3">
        <Button variant="primary" className="me-2" onClick={initializeSimulation}>
          Initialize
        </Button>

        <button
          onClick={() => setIsRunning(true)}
          disabled={isRunning || simulationOver}
          className="btn btn-success me-2">
          Start Simulation
        </button>

        <button
          onClick={() => setIsRunning(false)}
          disabled={!isRunning}
          className="btn btn-danger">
          Stop Simulation
        </button>


      </div>
      <Modal show={showModal} onHide={() => setShowModal(false)} centered>
        <Modal.Header closeButton>
          <Modal.Title>🔥 Simulation Terminée 🔥</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          🌳🔥 Toute la forêt est maintenant brûlée ! 🌳🔥
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={() => setShowModal(false)}>
            Fermer
          </Button>
        </Modal.Footer>
      </Modal>
    </Container>
    
  );
};

export default ForestFireSimulation;
