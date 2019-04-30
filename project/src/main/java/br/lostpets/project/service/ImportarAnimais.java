package br.lostpets.project.service;

/**
 * @author gamota
 *
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import org.springframework.stereotype.Component;
import br.lostpets.project.model.PetPerdido;

@Component
public class ImportarAnimais {

	public ImportarAnimais() {
		Scanner in = null;

		try {
			in = new Scanner(new FileReader("animaisPerdidos/saida.txt")).useDelimiter(";|\\r\\n");
		} catch (FileNotFoundException fileNotFoundException) {
			System.err.println("Erro ao abrir arquivo.");
			System.exit(1);
		}

		PetPerdido pet = new PetPerdido(null, null, null, null);

		System.out.printf("%-24s%-60s%-17s%7s\n", "Nome do animal", "Descricao", "Tipo de animal", "CEP");

		try {
			while (in.hasNext()) {

				pet.setNomeAnimal(in.next());
				pet.setDescricao(in.next());
				pet.setTipoAnimal(in.next());
				pet.setCep(in.next());

				System.out.printf("%-24s%-60s%-17s%12s\n", pet.getNomeAnimal(), pet.getDescricao(), pet.getTipoAnimal(),
						pet.getCep());
			}
		} catch (NoSuchElementException elementException) {
			System.err.println("Arquivo com problemas.");
			in.close();
			System.exit(1);
		} catch (IllegalStateException stateException) {
			System.err.println("Erro na leitura do arquivo.");
			System.exit(1);
		}

		if (in != null)
			in.close();
	}
}
