package br.com.comicstore.model

class Cliente() {

    var nome: String = ""
    var idade: Int = 0
    var cpf: String = ""
    var email: String = ""
    var endereco: Endereco = Endereco()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Cliente

        if (cpf != other.cpf) return false

        return true
    }

    override fun hashCode(): Int {
        return cpf.hashCode()
    }

    override fun toString(): String {
        return "Cliente(nome='$nome', idade=$idade, cpf='$cpf', email='$email', endereco=$endereco)"
    }

}