package org.frice

fun main(args: Array<String>) {
	val obj = O()
	launch(obj)
}

class O : GameFX(width = 600) {
	override fun onInit() {
		title = "My awesome title"
	}

	override fun onLastInit() {
		// title = "Your awesome title"
		// not allowed
	}
}