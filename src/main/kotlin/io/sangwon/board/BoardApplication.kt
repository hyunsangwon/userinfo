package io.sangwon.board

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["io.sangwon.board"])
class BoardApplication

fun main(args: Array<String>) {
	runApplication<BoardApplication>(*args)
}
