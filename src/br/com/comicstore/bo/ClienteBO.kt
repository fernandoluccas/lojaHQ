package br.com.comicstore.bo

import br.com.comicstore.dao.Banco
import br.com.comicstore.model.Cliente

class ClienteBO {

    fun savarCliente(cliente: Cliente) {

        if (cliente.nome.isBlank() || cliente.nome.isEmpty()) throw IllegalArgumentException("Nome obrigatorio")
        if (cliente.cpf.isBlank() || cliente.cpf.isEmpty()) throw IllegalArgumentException("CPF obrigatorio")

        Banco.save(cliente = cliente)
        println("Cliente salvo com sucesso")
        println("Quantidade de clientes salvos: ${Banco.listaCliente.size}")

    }

    fun pesquisarCliente(cpf: String): Cliente {
        val cliente = Cliente()
        cliente.cpf = cpf
        return Banco.find(cliente = cliente)
    }

    fun removerCliente(cpf: String) {
        val cliente = pesquisarCliente(cpf)
        if (Banco.remove(cliente = cliente)) {
            println("Cliente removido com sucesso!")
        } else {
            println("Cliente não encontrado para remoção")
        }
    }

    fun mostrarClientes() {
        for (cliente in Banco.listaCliente) {
            println(cliente)
        }
    }

    fun alterarCliente(cliente: Cliente) {
        if (!Banco.remove(cliente))
            println("Cliente não foi localizado. Será inserido o cliente informado!")

        Banco.save(cliente)

        println("Cliente alterado/inserido com sucesso!")
    }
}