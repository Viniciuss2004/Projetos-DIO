import Dominio.Curso;
import Dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Curso curso1 = new Curso();

        curso1.setTitulo("Curso de Java");
        curso1.setDescricao("Aprenderemos o Java Básico");
        curso1.setCargaHoraria(20);

        Curso curso2 = new Curso();

        curso2.setTitulo("Curso de Python");
        curso2.setDescricao("Aprenderemos o Python Básico");
        curso2.setCargaHoraria(10);

        Mentoria mentoria = new Mentoria();

        mentoria.setTitulo("Curso de Java");
        mentoria.setDescricao("Aprenderemos o Java Básico");
        mentoria.setData(LocalDate.now());

        System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria);

    }
}