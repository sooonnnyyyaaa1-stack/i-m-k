package ua.edu.chnu.kkn.organise.di

import com.russhwolf.settings.ObservableSettings
import com.russhwolf.settings.Settings
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.binds
import org.koin.dsl.module
import org.koin.plugin.module.dsl.create
import org.koin.plugin.module.dsl.single
import org.koin.plugin.module.dsl.viewModel
import ua.edu.chnu.kkn.organise.data.about.AboutRepository
import ua.edu.chnu.kkn.organise.data.about.Platform
import ua.edu.chnu.kkn.organise.data.common.preferences.AppPreferences
import ua.edu.chnu.kkn.organise.data.common.preferences.Preferences
import ua.edu.chnu.kkn.organise.data.reminders.RemindersRepository
import ua.edu.chnu.kkn.organise.ui.about.AboutViewModel
import ua.edu.chnu.kkn.organise.ui.reminders.ReminderViewModel

private fun createSettings() : Settings = Settings()
val dataModule = module {
    single { create(::createSettings) } binds arrayOf(Settings::class, ObservableSettings::class)
    singleOf(::AppPreferences) bind Preferences::class
}

val appModule = module {
    includes(dataModule)
    single<Platform>()
    single<AboutRepository>()
    viewModel<AboutViewModel>()
    single<RemindersRepository>()
    viewModel<ReminderViewModel>()
}