package iespablopicasso;

import java.util.Queue;

public class Gen {
	//Estado
	String datos;
	byte mutaciones;
	
	
	//Comportamiento
        
        //Constructor
    public Gen(String datos, byte mutaciones) {
		this.datos = datos;
		this.mutaciones = mutaciones;
	}

        //Getter
    public String getDatos() {
		return datos;
		
	}


    //Comportamiento clave. Se llamará cada vez que el fichero cambie la cola. Nos dan una cola y la comparamos con nuestro
    //String caracter a caracter contando los fallos/errores. Se debe devolver una cadena "cola;erroresencontrados"
    public String compara(Queue<Character> cola) {
    	int erroresEncontrados= 0;
    	String resultado;
    	
    	String miCola= cola.toString();
    	miCola= miCola.replaceAll("[^A-Za-z]", "");

    	for(int i = 0;i<miCola.length();i++) {
    			if(datos.charAt(i)!=miCola.charAt(i)) {
    				erroresEncontrados++;
    			}	
    		}
    	
    	if(erroresEncontrados>mutaciones) {
    		resultado = "";
    	}
    	else {
    		
		resultado= miCola +";"+ String.valueOf(erroresEncontrados) +"\n";
    	}
    	return resultado;
    }
	

        //Getter
	public byte getMutaciones() {
		return mutaciones;
	}

}
