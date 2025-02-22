package com.cigil.forestfire;

import com.cigil.forestfire.config.SimulationConfig;
import com.cigil.forestfire.service.ForestFireSimulationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ForestFireApplicationTests {

	private ForestFireSimulationService simulationService;

	@BeforeEach
	void setUp() {
		SimulationConfig config = new SimulationConfig();
		config.setGridHeight(5);
		config.setGridWidth(5);
		config.setPropagationProbability(0.5);
		simulationService = new ForestFireSimulationService(config);
	}

	@Test
	void testFirePropagation() {
		simulationService.step();
		assertNotNull(simulationService);
	}

	@Test
	void testSimulationCompletion() {
		while (!simulationService.isSimulationOver()) {
			simulationService.step();
		}
		assertTrue(simulationService.isSimulationOver());
	}

}
