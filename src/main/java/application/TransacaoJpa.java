package application;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.ContaTeste;

public class TransacaoJpa {

    public static void main(String[] args) {

	Scanner scan = new Scanner(System.in);

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("treinamento-jpa");
	EntityManager em = emf.createEntityManager();

	ContaTeste conta1 = em.find(ContaTeste.class, 1L);
	if (conta1 == null) {
	    System.out.print("Insira o saldo da conta 1: ");
	    double saldoConta1 = scan.nextDouble();
	    conta1 = new ContaTeste(saldoConta1);
	}

	ContaTeste conta2 = em.find(ContaTeste.class, 2L);
	if (conta2 == null) {
	    System.out.print("Insira o saldo da conta 2: ");
	    double saldoConta2 = scan.nextDouble();
	    conta2 = new ContaTeste(saldoConta2);
	}
	
	em.getTransaction().begin();
	em.persist(conta1);
	em.persist(conta2);
	
	System.out.println("Saldo conta 1: R$" + conta1.getSaldo() + " | "
		+ "Saldo conta 2: R$"+ conta2.getSaldo());
	
	System.out.println("----------------------------");
	System.out.print("Quanto quer transferir da conta 1 pra conta 2? R$");
	double tranferencia = scan.nextDouble();
	
	conta1.setSaldo(conta1.getSaldo() - tranferencia);
	conta2.setSaldo(conta2.getSaldo() + tranferencia);
	
	if (conta1.getSaldo() > 0) {
	    System.out.println("Transferência realizada com sucesso!");
	    em.getTransaction().commit();
	}else {
	    System.out.println("Ops.. parece que você não tem saldo suficiente.");
	    em.getTransaction().rollback();
	}
	
	em.close();
	emf.close();
	scan.close();
    }

}
