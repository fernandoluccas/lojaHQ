import br.com.comicstore.bo.ClienteBO
import br.com.comicstore.model.Cliente
import java.lang.Exception
import java.util.*

private val clienteBO = ClienteBO()

fun main() {

    println("Seja bem vindo ao Comic Store")
    val scanner = Scanner(System.`in`)

    var opcao = mostrarMenu(scanner)

    while (opcao != 6) {
        when (opcao) {
            1 -> salvarCliente(scanner)
            2 -> alterarCliente(scanner)
            3 -> pesquisarCliente(scanner)
            4 -> removerCliente(scanner)
            5 -> mostarTodosClientes()
            else -> println(" -- Opção Invalida -- ")
        }
        opcao = mostrarMenu(scanner)
    }

    scanner.close()
    println("Obrigado pelo uso do Comic Store. Até a proxima")

}



private fun alterarCliente(scanner: Scanner) {
    try {
        println("\n---> Alterar Cliente")
        clienteBO.alterarCliente(obterCliente(scanner))
    } catch (e: IllegalArgumentException) {
        println(e.message)
    } catch (e1: Exception) {
        e1.printStackTrace()
    }
}

private fun mostarTodosClientes() {
    clienteBO.mostrarClientes()
}

private fun removerCliente(scanner: Scanner) {
    try {
        println("\n---> Remover Cliente")
        clienteBO.removerCliente(obterCPF(scanner))

    } catch (e: IllegalArgumentException) {
        println(e.message)
    } catch (e1: Exception) {
        e1.printStackTrace()
    }
}

private fun pesquisarCliente(scanner: Scanner) {
    try {
        println("\n---> Pesquisa Cliente")
        println(clienteBO.pesquisarCliente(obterCPF(scanner)))

    } catch (e: IllegalArgumentException) {
        println(e.message)
    } catch (e1: Exception) {
        e1.printStackTrace()
    }
}

private fun salvarCliente(scanner: Scanner) {
    println("\n---> Cadastro de Cliente")
    clienteBO.savarCliente(obterCliente(scanner))
}

private fun obterCliente(scanner: Scanner): Cliente {

    val cliente = Cliente()
    println(" --> Informações do Cliente ")
    print(" - Nome: ")
    cliente.nome = scanner.next()
    print(" - Idade: ")
    cliente.idade = scanner.nextInt()
    print(" - CPF: ")
    cliente.cpf = scanner.next()
    print(" - E-mail: ")
    cliente.email = scanner.next()
    println(" --> Informações do Endereço do Cliente ")
    print(" -- Tipo de Logradouro (Ex.: Rua, Avenida, Travessa): ")
    cliente.endereco.tipoLogradouro = scanner.next()
    print(" -- Logradouro: ")
    cliente.endereco.logradouro = scanner.next()
    print(" -- Numero: ")
    cliente.endereco.numero = scanner.next()
    print(" -- Complemento: ")
    cliente.endereco.complemento = scanner.next()
    print(" -- Bairro: ")
    cliente.endereco.bairro = scanner.next()
    print(" -- Cidade: ")
    cliente.endereco.cidade = scanner.next()
    print(" -- CEP: ")
    cliente.endereco.cep = scanner.next()

    return cliente
}

private fun obterCPF(scanner: Scanner): String {
    print(" - CPF: ")
    return scanner.next()
}

private fun mostrarMenu(scanner: Scanner): Int {
    println("\n--> Menu")
    println(" 1 - Cadastrar Cliente")
    println(" 2 - Alterar Cliente")
    println(" 3 - Consultar Cliente")
    println(" 4 - Deletar Cliente")
    println(" 5 - Mostrar Todos Clientes")
    println(" 6 - Sair")
    print("Opção desejada: ")

    return scanner.nextInt()
}