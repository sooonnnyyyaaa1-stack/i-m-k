package ua.edu.chnu.kkn.organise.data.about

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.alloc
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import platform.CoreGraphics.CGRectGetHeight
import platform.CoreGraphics.CGRectGetWidth
import platform.Foundation.NSLog
import platform.Foundation.NSString
import platform.Foundation.NSUTF8StringEncoding
import platform.Foundation.stringWithCString
import platform.UIKit.UIDevice
import platform.UIKit.UIScreen
import platform.UIKit.UIUserInterfaceIdiomPad
import platform.UIKit.UIUserInterfaceIdiomPhone
import platform.posix.uname
import platform.posix.utsname
import ua.edu.chnu.kkn.organise.data.about.ScreenInfo
import kotlin.experimental.ExperimentalNativeApi

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class Platform actual constructor() {
    @OptIn(ExperimentalNativeApi::class)
    actual val osName: String
        get() = when (UIDevice.currentDevice.userInterfaceIdiom) {
            UIUserInterfaceIdiomPhone -> "iOS"
            UIUserInterfaceIdiomPad -> "iPadOS"
            else -> kotlin.native.Platform.osFamily.name
        }
    actual val osVersion: String
        get() = UIDevice.currentDevice.systemVersion
    @OptIn(ExperimentalForeignApi::class)
    actual val deviceModel: String
        get() = memScoped {
            val systemInfo: utsname = alloc()
            uname(systemInfo.ptr)
            return NSString.stringWithCString(systemInfo.machine, encoding = NSUTF8StringEncoding)
                ?: "---"
        }
    @OptIn(ExperimentalNativeApi::class)
    actual val cpuType: String
        get() = kotlin.native.Platform.cpuArchitecture.name
    actual val screen: ScreenInfo
        get() = ScreenInfo()

    actual fun logSystemInfo() {
        NSLog(
            "($osName; $osVersion; $deviceModel; ${screen.width}x${screen.height}@${screen.density}x; $cpuType)"
        )
    }
}

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class ScreenInfo actual constructor() {
    @OptIn(ExperimentalForeignApi::class)
    actual val width: Int
        get() = CGRectGetWidth(UIScreen.mainScreen.nativeBounds).toInt()
    @OptIn(ExperimentalForeignApi::class)
    actual val height: Int
        get() = CGRectGetHeight(UIScreen.mainScreen.nativeBounds).toInt()
    actual val density: Int?
        get() = UIScreen.mainScreen.scale.toInt()
}