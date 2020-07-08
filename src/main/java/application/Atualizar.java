package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Cliente;

public class Atualizar {

    public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("treinamento-jpa");
	EntityManager em = emf.createEntityManager();
	
	Cliente cliente = em.find(Cliente.class, 4L);
	
	cliente.setName("João Lucas");
	cliente.setProfissao("Programador Javascript");
	
	em.getTransaction().begin();
	
	em.merge(cliente);
	
	em.getTransaction().commit();
	
	em.close();
	emf.close();

    }

}
