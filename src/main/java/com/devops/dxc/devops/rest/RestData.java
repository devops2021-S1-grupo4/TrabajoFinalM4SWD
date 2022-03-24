package com.devops.dxc.devops.rest;


import java.util.logging.Level;
import java.util.logging.Logger;
import com.devops.dxc.devops.model.Dxc;
import com.devops.dxc.devops.model.Impuesto;
import com.devops.dxc.devops.model.SaldoAhorro;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/rest/msdxc")
public class RestData {

	private final static Logger LOGGER = Logger.getLogger("devops.subnivel.Control");

	@CrossOrigin
	@GetMapping(path = "/dxc", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Dxc getData(@RequestParam(name = "sueldo") String sueldo, @RequestParam(name = "ahorro") String ahorro){

		LOGGER.log(Level.INFO, "< Trabajo DevOps - DXC > <Consultado Diez por ciento>");

        Dxc response = new Dxc(Integer.parseInt(ahorro), Integer.parseInt(sueldo));
		return response;
	}

	@CrossOrigin
	@GetMapping(path = "/saldoahorro", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody SaldoAhorro getSaldorestante(@RequestParam(name = "ahorro") String ahorro){

		LOGGER.log(Level.INFO, "< Trabajo DevOps - Saldorestante > <Conocer el saldo restante que quedará luego de un posible retiro>");

        SaldoAhorro response = new SaldoAhorro(Integer.parseInt(ahorro));
		return response;
	}

	@CrossOrigin
	@GetMapping(path = "/impuesto", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Impuesto getImpuesto(@RequestParam(name = "sueldo") String sueldo){

		LOGGER.log(Level.INFO, "< Trabajo DevOps - Impuesto > <Conocer el impuesto asociado al retirar el monto máximo.>");

        Impuesto response = new Impuesto(Integer.parseInt(sueldo));
		return response;
	}

}