enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, val conteudos: List<ConteudoEducacional>) {
    
    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
    
    fun desmatricular(usuario: Usuario) {
        inscritos.remove(usuario)
    }
    
    fun listarInscritos() {
        println("Usuários inscritos na formação $nome:")
        inscritos.forEach { println(it.nome) }
    }
}

fun printMessageWithPrefix(message: String, prefix: String = "Info"){
    println("[$prefix] $message")
}

fun sum(x: Int, y: Int): Int{
    return x + y
}

fun multiply(x: Int, y: Int) = x * y

fun main() {
    val usuario1 = Usuario("João")
    val usuario2 = Usuario("Maria")
    val usuario3 = Usuario("Pedro")
    
    val conteudo1 = ConteudoEducacional("Introdução à Programação", 90)
    val conteudo2 = ConteudoEducacional("Estruturas de Dados", 120)
    val conteudo3 = ConteudoEducacional("Algoritmos Avançados", 150)
    
    val formacao1 = Formacao("Desenvolvimento de Software", Nivel.BASICO, listOf(conteudo1))
    val formacao2 = Formacao("Ciência da Computação", Nivel.AVANCADO, listOf(conteudo1, conteudo2, conteudo3))
    
    formacao1.matricular(usuario1)
    formacao1.matricular(usuario2)
    formacao2.matricular(usuario2)
    formacao2.matricular(usuario3)
    
    formacao1.listarInscritos()
    formacao2.listarInscritos()
    
    formacao2.desmatricular(usuario2)
    formacao2.listarInscritos()
    
    // Chamar funções adicionais aqui, se necessário
    printMessageWithPrefix("Hello", "Log")
}
