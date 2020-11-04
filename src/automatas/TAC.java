package automatas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JTextArea;
import static sun.net.util.IPAddressUtil.scan;

public class TAC
{

    private static FileInputStream entrada;
    private FileOutputStream salida;

    static public void main(String argv[])
    {
        String aux[] =
        {
            "C:/Users/jesus/Documents/NetBeansProjects/JavaApplication10/codigo.txt"
        };
        try
        {
            parser p = new parser(new Yylex(new FileReader(aux[0])));
            if (argv.length > 1 && argv[1] != null)
            {
                Generador.out = new PrintStream(new FileOutputStream(aux[1]));
            }
            Object result = p.parse().value;
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void generar(String codigo)
    {
        String aux[] =
        {
            codigo
        };
        String res = null;
        Generador g = new Generador();

        try
        {
            parser p = new parser(new Yylex(new FileReader(aux[0])));
            if (aux.length > 1 && aux[1] != null)
            {
                FileOutputStream fs = new FileOutputStream(aux[1]);
                g.out = new PrintStream(fs);
                //resultado.append(codigo);
            }
            Object result = (String) p.parse().value;
            //area.append(String.valueOf(p.do_action(act_num, p, null, top)));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void generar3(String codigo, JTextArea area)
    {
        PrintStream out = new PrintStream(new TextAreaOutputStream(area));
        // redirect standard output stream to the TextAreaOutputStream
        System.setOut(out);

        // redirect standard error stream to the TextAreaOutputStream
        System.setErr(out);
        //RememberAllWrittenTextPrintStream ps = new RememberAllWrittenTextPrintStream(System.out);
        //System.setOut(ps);
        String aux[] =
        {
            codigo
        };
        String res = null;
        parser p;
        Yylex y;
        try
        {
            FileReader fr = new FileReader(aux[0]);
            y = new Yylex(fr);
            p = new parser(y);
            p.parse();
        } catch (Exception ex)
        {
            Logger.getLogger(TAC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
