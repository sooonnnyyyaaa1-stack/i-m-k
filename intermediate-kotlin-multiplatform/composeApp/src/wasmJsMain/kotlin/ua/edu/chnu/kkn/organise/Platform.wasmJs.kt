package ua.edu.chnu.kkn.organise

import ua.edu.chnu.kkn.organise.data.about.Platform
class WasmPlatform: Platform {
    override val name: String = "Web with Kotlin/Wasm"
}

actual fun getPlatform(): Platform = WasmPlatform()