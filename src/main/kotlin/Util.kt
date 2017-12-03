object Util {
    fun readResourceLines(file: String): List<String> = this::class.java.classLoader.getResourceAsStream(file).use {
        it.bufferedReader().readLines()
    }
}