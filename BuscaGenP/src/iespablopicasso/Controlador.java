package iespablopicasso;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.LinkedList;
import java.util.Queue;

public class Controlador {
	//ESTADO 
	
	private static final byte FASTA_HEAD_LINES = 10;  //Líneas a leer desde el fichero para mostrar en la GUI
	private static final String NOMBRE_FICHERO_RESULTADO = "C:\\Users\\Sergiu Campos\\eclipse-workspace\\BuscaGenP\\Resultado.txt";
	private static Controlador singleton;
	
        //Constructor privado. No hay que meterle código ninguno...
	private Controlador() {
		
	}

        //Obtención del singleton	
	public static Controlador getSingleton() {
	    if (singleton == null){
	        singleton = new Controlador();
	    }
	    return singleton;
	}
	

        //Comportamiento principal de la aplicación	
	public void realizaBusqueda(String gen, String mutaciones,String fichero) {
			Gen miGen = new Gen(gen,Byte.valueOf(mutaciones));
			Fasta miFasta = new Fasta(miGen,fichero);
			//int caracter=1;
			String resultado;

	    	
	    	
	    	resultado = miFasta.buscaGen();		
	    	
	    	/*escupir resultado a un fichero*/
	    	this.escribeFichero(resultado);
		 
	}
	
        //Método auxiliar para escribir el String resultado de la búsqueda. Es llamado desde realizaBusqueda
	private void escribeFichero(String resultado) {
		try {
			BufferedWriter bw=new BufferedWriter(new FileWriter(NOMBRE_FICHERO_RESULTADO,true));
            //Escribimos en el fichero
            bw.write(resultado);
            //Guardamos los cambios del fichero
            bw.flush();
            bw.close();
            
		}
		catch(IOException io){
			io.printStackTrace();
			
		}
	}
	

         //Comportamiento que proporciona las primeras FASTA_HEAD_LINES para meter en el JTextArea
	public String cargaHeadFasta(String fichero) {
		String resultado="";
		
        try{
        	BufferedReader br=new BufferedReader(new FileReader(fichero));
                //Leemos el fichero y lo mostramos por pantalla
 
                for(byte i=0;i<FASTA_HEAD_LINES;i++){
                   
                   String linea=br.readLine();
                    resultado += linea+"\n";
                }
                br.close();
        }
        catch (IOException io) {
        	io.printStackTrace();
        	
        }
		return resultado;
	
	}
}
