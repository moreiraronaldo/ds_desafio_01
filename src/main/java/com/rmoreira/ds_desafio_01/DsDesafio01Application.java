package com.rmoreira.ds_desafio_01;

import com.rmoreira.ds_desafio_01.entities.Order;
import com.rmoreira.ds_desafio_01.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class DsDesafio01Application implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args)  {

		SpringApplication.run(DsDesafio01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Dados do pedido");
		System.out.print("Codigo: ");
		int codigo = sc.nextInt();

		System.out.print("Valor basico: ");
		Double basic = sc.nextDouble();

		System.out.print("Percentual de desconto: ");
		Double discount = sc.nextDouble();

		Order order = new Order(codigo,basic,discount);

		Double total = orderService.total(order);

		System.out.println("Pedido codigo " + order.getCode());
		System.out.println("Valor total: R$ " + total);

		sc.close();
	}
}
