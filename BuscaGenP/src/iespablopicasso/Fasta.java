package iespablopicasso;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Fasta {
	
	//Estado
	Gen gen;
	String ficheroSeleccionado;
	//String resultado;
		
	//Comportamiento
    //Constructor
    public Fasta(Gen miGen, String fichero) {
    	gen = miGen;
    	ficheroSeleccionado = fichero;
    	//resultado = "";
 	
    }
    
    //Comportamiento principal de búsqueda. Abrirá el fichero, creará la cola, la alimentará y le dará
    // la cola a gen para comparar el contenido y así obtener el resultado.
    public String buscaGen() {
    	Queue<Character> cola = new LinkedList<Character>();
    	char readed;
    	String resultado = "";
    	
    	try {
    		BufferedReader br = new BufferedReader(new FileReader(ficheroSeleccionado));
    		
    		/*
    		 * lo que sea que calcule y meta en resultado la cabecera
    		 */
    		readed=(char)br.read();
    		while(readed!=(char)-1 && cola.size()<gen.getDatos().length()) {
    			cola.add(readed);
    			readed=(char)br.read();
    			
    		}
    		
    		while (readed!=(char)-1){
    			resultado += gen.compara(cola);
    		
    			
    		
    		//Aqu seguimos hasta el final del fichero
    			cola.poll();
    			readed=(char)br.read();
    			
    		while(readed==10 || readed==13) {
    			readed=(char)br.read();
				
    		}
    		cola.offer(readed);
    		}
    		br.close();
    		
    		
    	}
    	catch(IOException io){
    		io.printStackTrace();
    		
    	}
    	
    	
    	return resultado;
    }

}
