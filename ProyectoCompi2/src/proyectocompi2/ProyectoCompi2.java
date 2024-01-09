/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectocompi2;
import java.io.*;
import jflex.exceptions.*;
import java_cup.*;
import java_cup.runtime.Symbol;
/**
 *
 * @autores: Adrian Herrera y Juan Mallma
 * @Proyecto del curso de compiladores e Interpretes
 * Profesor: Allan Gabriel Rodriguez Davila
 * Verano 2023
 */
public class ProyectoCompi2 {

    
    public static void pruebaLexer2() throws Exception {
       // Reader reader = new BufferedReader(new FileReader(rutaScanear));
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\XPC\\OneDrive\\Documentos\\GitHub\\Compiladores-Proyecto2\\ProyectoCompi2\\src\\proyectocompi2\\input.txt");
        Reader reader = new InputStreamReader(fileInputStream);
        Lexer lex = new Lexer(reader);

        int i = 0;
        Symbol token;

        // Se especifica la ruta del archivo de salida
        String outputPath = "C:\\Users\\XPC\\OneDrive\\Documentos\\GitHub\\Compiladores-Proyecto2\\ProyectoCompi2\\src\\proyectocompi2\\output.txt";
        // Se inicializa el writer para escribir sobre el archivo
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));

        while (true) {
            token = lex.next_token();
            if (token.sym != 0) {
                /*
                 * Se define y escribe la hilera con la informacion del token con su codigo,
                 * nombre, valor, linea y columna con el que aparecen en el codigo.txt
                 */
                String tokenInfo = "Codigo Token: " + token.sym +
                        ", Nombre Token: " + sym.terminalNames[token.sym] +
                        ", Valor: " + (token.value == null ? lex.yytext() : token.value.toString()) +
                        ", Linea: " + (token.left + 1) + ", Columna: " + (token.right + 1) + "\n";
                System.out.println(tokenInfo); // Se imprime en consola la info
                writer.write(tokenInfo); // Se escribe en el archivo txt la info
                writer.write("\n");
            } else {
                String cantLexemas = "Cantidad de lexemas encontrados: " + i;
                System.out.println(cantLexemas);

                // Se escribe la cantidad de lexemas en el archivo
                writer.write(cantLexemas);
                writer.newLine();

                writer.close(); // Se cierra el writer
                break; // Use break instead of return to exit the loop
            }
            i++; // Se incrementa el contador de lexemas
        }

    }
    /**
     * Funcion principal del programa que ejecuta las pruebas,
     * No recibe parametros obligatorios 
     */
    public static void main(String[] args) throws FileNotFoundException, Exception {
        //Se llama a la prueba lexica del archivo 
        pruebaLexer2();
        System.out.println("\nBEGIN");
        //Se lee el archivo de prueba para el analisis sintactico
        FileInputStream fileInputStream = new FileInputStream("C:\\\\Users\\\\XPC\\\\OneDrive\\\\Documentos\\\\GitHub\\\\Compiladores-Proyecto2\\\\ProyectoCompi2\\\\src\\\\proyectocompi2\\input.txt");
        Reader reader = new InputStreamReader(fileInputStream);
        //Se carga el archivo en el lexer
        Lexer lexer = new Lexer(reader);
        //Se inicializa el parser con el lexer
        parser p = new parser(lexer);
        //Se ejecuta el parseo
        p.parse();
        //Se verifica si el archivo fuente es generble por la grmatica
        p.estadoGramatica();
        System.out.println("\nEND");
        
    }
        
}
