package cl.example.ejercicio4m5

class Usuarios(var nombre: String,
               var edad: Int,
               var trabajo: String?,
               var referencia: Usuarios?)

fun main() {

    val listUsu = mutableListOf<Usuarios>()

    fun agregarUsuario(usuario : Usuarios){
        listUsu.add(usuario)
    }

    fun eliminarUsuario(usuario : Usuarios){
        if (listUsu.remove(usuario)) {
            println("Usuario eliminado: ${usuario.nombre}")
        } else {
            println("Usuario no encontrado en la lista.")
        }
    }

    fun mostrarLista(){
        println("Lista de usuarios:")
        listUsu.forEach { usuario ->
            val trabajoN = usuario.trabajo ?: "Sin trabajo"
            val referenciaN = usuario.referencia?.let { "Referencia: ${it.nombre} de ${it.edad} años" } ?: "Sin referencia"
            println("Nombre: ${usuario.nombre}, Edad: ${usuario.edad}, Trabajo: $trabajoN, $referenciaN")
        }
    }

    val usu1 = Usuarios("Juan Perez", 35, "Montador", null)
    val usu2 = Usuarios("Pamela Rojas", 28, "Secretaria", usu1)
    val usu3 = Usuarios("José Torres", 45, "Ingeniero", usu2)
    val usu4 = Usuarios("Luis Fernandez", 38, "Albañil", null)
    val usu5 = Usuarios("Manuel Roa", 39, "Fierrero", null)

    agregarUsuario(usu1)
    agregarUsuario(usu2)
    agregarUsuario(usu3)
    agregarUsuario(usu4)
    agregarUsuario(usu5)

    mostrarLista()

    eliminarUsuario(usu3)

    mostrarLista()

}
