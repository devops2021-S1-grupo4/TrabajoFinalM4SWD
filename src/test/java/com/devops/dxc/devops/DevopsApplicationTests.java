package com.devops.dxc.devops;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.devops.dxc.devops.model.Util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DevopsApplicationTests {
	Util util = new Util();
	int ahorro = 20000000;
	int sueldo = 1600000;

	@Test
	public void testDiezxciento() throws Exception {
		assertEquals(2000000, util.getDxc(ahorro,sueldo));
	}

	@Test
	public void testImpuesto() throws Exception {
		assertEquals(0.08f, util.getImpuesto(sueldo));
	}

	@Test
	public void testSaldoAhorro() throws Exception {
		assertEquals(18000000, util.getSaldoAhorro(ahorro));

	}

}
