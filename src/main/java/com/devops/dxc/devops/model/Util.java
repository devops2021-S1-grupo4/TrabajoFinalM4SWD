package com.devops.dxc.devops.model;

import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.google.gson.Gson;

public class Util {

    /**
     * Método para cacular el 10% del ahorro en la AFP.  Las reglas de negocio se pueden conocer en 
     * https://www.previsionsocial.gob.cl/sps/preguntas-frecuentes-nuevo-retiro-seguro-10/
     *
     * @param ahorro
     * @param sueldo
     * @return
     */
    public static int getDxc(int ahorro, int sueldo){
        if(((ahorro*0.1)/getValorUf()) > 150 ){
            return (int) (150*getValorUf()) ;
        } else if(((ahorro)/getValorUf()) > 35 ){
            return (int) (ahorro*0.1);
        } else{
            return (int) ahorro;
        }
    }

    /**
     * Método que retorna el valor de la UF.  Este método debe ser refactorizado por una integración a un servicio
     * que retorne la UF en tiempo real.  Por ejemplo mindicador.cl
     * @return
     */
    public static Float getValorUf(){

        RestTemplate restTemplate = new RestTemplate();
	    ResponseEntity<String> call= restTemplate.getForEntity("https://mindicador.cl/api" ,String.class);
	    //Indicadores response = new Indicadores();
		Gson gson = new Gson();
        Indicadores estado = gson.fromJson(call.getBody().toLowerCase(), Indicadores.class);
        Float resultado = estado.getUf().getValor();
        //response.getUf().getValor();
        return resultado;
    }

    /**
     * Método para conocer el saldo restante que quedará luego de un posible retiro.  Las reglas de negocio se pueden conocer en 
     * https://www.previsionsocial.gob.cl/sps/preguntas-frecuentes-nuevo-retiro-seguro-10/
     *
     * @param ahorro
     * @return
     */
    public static int getSaldoAhorro(int ahorro){
        if ((ahorro/getValorUf())<35){
            return (int) 0;
        }else{
            double noventaxciento = ahorro * 0.9;
		    return (int) noventaxciento;
        }
    }
    /**
     * Método para conocer el impuesto asociado al retirar el monto máximo.  Las reglas de negocio se pueden conocer en 
     * https://www.previsionsocial.gob.cl/sps/preguntas-frecuentes-nuevo-retiro-seguro-10/
     *
     * @param sueldo
     * @return
     */
    public static Float getImpuesto(int sueldo){
		Integer sueldoAnual = sueldo*12;

		float inpuesto = 0.0f;
		if (sueldoAnual > 18370440 && (sueldoAnual < 32502600)){
			inpuesto =  0.08f;
		}else if(sueldoAnual > 32502601 && (sueldoAnual < 45503640)){
			inpuesto = 0.135f;
		}else if(sueldoAnual > 45503641 && (sueldoAnual < 58504680)){
			inpuesto = 0.230f;
		}else if(sueldoAnual > 58504681 && (sueldoAnual < 78006240)){
			inpuesto = 0.304f;
		}else if(sueldoAnual > 78006241 && (sueldoAnual < 201516120)){
			inpuesto = 0.350f;
		}else if(sueldoAnual > 201516121){
			inpuesto = 0.400f;
		}

		System.out.println("Sueldo Anual: "+sueldoAnual);
		System.out.println("Impuesto"+inpuesto);
		return inpuesto;
	}
}
