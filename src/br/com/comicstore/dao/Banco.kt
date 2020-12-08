package br.com.comicstore.dao

import br.com.comicstore.model.Cliente

object Banco {
    var listaCliente: ArrayList<Cliente> = ArrayList()
        private set

    fun save(cliente: Cliente) {
        if (listaCliente.contains(cliente))
            throw IllegalArgumentException("Não é possivel inserir cliente. O mesmo já existe no banco")

        listaCliente.add(cliente)

    }

    fun find(cliente: Cliente): Cliente {
        if (!listaCliente.contains(cliente)) {
            throw IllegalArgumentException("Cliente não localizado")
        }

        return listaCliente.get(listaCliente.indexOf(cliente))
    }

    fun remove(cliente: Cliente): Boolean {
        return listaCliente.remove(cliente)
    }

}

