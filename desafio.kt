// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario (val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)


data class Formacao(val nome: String, val dificuldade: Nivel, var conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()

    fun exibirInscritos(): String {
        var str: String
        if (inscritos.isEmpty()) {
            str = "Nenhum inscrito na formação $nome."
        } else {
            str = "Inscritos na Formação $nome:\n"
            inscritos.forEach { inscrito ->
                str += "- ${inscrito.nome}\n"
            }
        }
        return str
    }

    fun matricular(vararg usuarios: Usuario) {
        for (user in usuarios) {
            if (!inscritos.contains(user)) {
                inscritos.add(user)
                println("${user.nome} foi matriculado com sucesso.")
            } else {
                println("${user.nome} já está matriculado.")
            }
        }
    }

    override fun toString(): String {
        val conteudosString = conteudos.joinToString(separator = "\n") { conteudo ->
            "- ${conteudo.nome}, Duração: ${conteudo.duracao} minutos"
        }
        return "Formação: $nome, Dificuldade: $dificuldade\nConteúdos:\n$conteudosString\n${exibirInscritos()}"
    }
}
//TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
//TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
fun main() {
    val nivel = Nivel.BASICO

    val user1 = Usuario("Robson")
    val user2 = Usuario("Rebeca")

    val conteudo1 = ConteudoEducacional("Deep Learning",360)
    val conteudo2 = ConteudoEducacional("Lógica de programação",240)
    val conteudo3 = ConteudoEducacional("Cálculo",600)

    val formacao = Formacao("Formação Kotlin",nivel,listOf(conteudo1,conteudo2,conteudo3),)

    formacao.matricular(user1,user2,user1)

    println(formacao.inscritos)
    println(formacao)
    
}
