package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Cliente;

public class RecuperandoDados {

    public static void main(String[] args) {
	// -------------------------- buscando pessoa -----------------------------
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("treinamento-jpa");
	EntityManager em = emf.createEntityManager();
	
	int n = 1;
	
	Cliente cliente = em.find(Cliente.class, Long.valueOf(n));
	
	System.out.println(cliente);
	
	em.close();
	emf.close();
    }

}
