package br.com.comicstore.model

class Endereco() {

    var tipoLogradouro: String = ""
    var logradouro: String = ""
    var numero: String = ""
    var complemento: String = ""
    var bairro: String = ""
    var cidade: String = ""
    var cep: String = ""

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Endereco

        if (tipoLogradouro != other.tipoLogradouro) return false
        if (logradouro != other.logradouro) return false
        if (numero != other.numero) return false
        if (complemento != other.complemento) return false
        if (bairro != other.bairro) return false
        if (cidade != other.cidade) return false
        if (cep != other.cep) return false

        return true
    }

    override fun hashCode(): Int {
        var result = tipoLogradouro.hashCode()
        result = 31 * result + logradouro.hashCode()
        result = 31 * result + numero.hashCode()
        result = 31 * result + complemento.hashCode()
        result = 31 * result + bairro.hashCode()
        result = 31 * result + cidade.hashCode()
        result = 31 * result + cep.hashCode()
        return result
    }

    override fun toString(): String {
        return "Endereco(tipoLogradouro='$tipoLogradouro', logradouro='$logradouro', numero='$numero', complemento='$complemento', bairro='$bairro', cidade='$cidade', cep='$cep')"
    }


}