package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Cliente;

public class deletandoDados {

    public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("treinamento-jpa");
	EntityManager em = emf.createEntityManager();
	
	em.getTransaction().begin();
	
	Cliente cliente = em.find(Cliente.class, 3L);
	
	em.remove(cliente);
	
	em.getTransaction().commit();
	
	System.out.println("deletado com sucesso!");
	
	em.close();
	emf.close();


    }

}
