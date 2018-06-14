fun return42(): Int {
    return libraryFunction() + commonFunction()
}

actual fun platformFunction() = 0