package com.mycompany.desligarpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CMD {

    //Pega o objeto de tempo de execução associado ao aplicativo Java atual.
    private static final Runtime run = Runtime.getRuntime();
    private static Process pro;
    private static BufferedReader read;

    public CMD() {
    }

    public void desligarNow() {
        try {
            //Executa o comando de string especificado em um processo separado.
            pro = run.exec("EXPLORER.EXE");//"shutdown -a"

//            read = new BufferedReader(new InputStreamReader(pro.getInputStream()));
//            read.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Apenas para mostrar o que fazar se precisar entrar com mais de um comando
    public void test() {
        //Comando abaixo e necessario se for inserir mais de um comnado
        //"cmd /c start cmd.exe",
        
        //E criado um vetor com os comandos
        String[] cmds = {
            "cmd /c start cmd.exe",
            "EXPLORER.EXE",
            "EXPLORER.EXE"
        };

        try {
            pro = run.exec(String.join("& ", cmds));//Junta todos os comando em apenas um linha, os separando com "& "

            //Esse metodo aqui e modo "bruto"
            //Mas roda sem essas duas linhas de baixo
            read = new BufferedReader(new InputStreamReader(pro.getInputStream()));
            read.readLine();
        } catch (Exception e) {
        }
    }
}
