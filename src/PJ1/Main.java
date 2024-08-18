import Dominio.Bootcamp;
import Dominio.Curso;
import Dominio.Dev;
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

        /*System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria);*/

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Aprenderemos o Java Básico");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev dev_Vinicius = new Dev();
        dev_Vinicius.setNome("Vinicius");
        dev_Vinicius.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos de " + dev_Vinicius.getNome() + ":" + dev_Vinicius.getConteudosInscritos());

        dev_Vinicius.progredir();

        System.out.println("-");
        System.out.println("Conteúdos Inscritos de " + dev_Vinicius.getNome() + ":" + dev_Vinicius.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos de " + dev_Vinicius.getNome() + ":" + dev_Vinicius.getConteudosConcluido());
        System.out.println("XP de " + dev_Vinicius.getNome() + ":" + dev_Vinicius.calcularTotalXp());

        System.out.println("--------------------------------------------------------------------------------------------");

        Dev dev_Joao = new Dev();
        dev_Joao.setNome("João");
        dev_Joao.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos de " + dev_Joao.getNome() + ":" + dev_Joao.getConteudosInscritos());

        dev_Joao.progredir();

        System.out.println("-");
        System.out.println("Conteúdos Inscritos de " + dev_Joao.getNome() + ":" + dev_Joao.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos de " + dev_Joao.getNome() + ":" + dev_Joao.getConteudosConcluido());
        System.out.println("XP de " + dev_Joao.getNome() + ":" + dev_Joao.calcularTotalXp());


    }
}