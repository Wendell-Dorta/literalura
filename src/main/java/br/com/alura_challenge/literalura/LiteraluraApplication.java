package br.com.alura_challenge.literalura;

import br.com.alura_challenge.literalura.runner.MenuRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {
	private final MenuRunner menuRunner;

	public LiteraluraApplication(MenuRunner menuRunner) {
		this.menuRunner = menuRunner;
	}

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		menuRunner.showMenu();
	}
}
