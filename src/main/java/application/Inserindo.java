package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Cliente;

public class Inserindo {

    public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("treinamento-jpa");
	EntityManager em = emf.createEntityManager();
	
	Cliente cliente = new Cliente("Felipe Castelo", 25, "M", "Ajudante de Pedreiro");
	
	em.getTransaction().begin();
	em.persist(cliente);
	em.getTransaction().commit();
	
	System.out.println("Cliente inserido com sucesso!");
	
	em.close();
	emf.close();

    }

}
