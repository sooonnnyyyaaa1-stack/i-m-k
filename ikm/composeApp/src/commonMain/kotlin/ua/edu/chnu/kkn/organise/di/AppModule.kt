package ua.edu.chnu.kkn.organise.di

import org.koin.dsl.module
import org.koin.plugin.module.dsl.single
import org.koin.plugin.module.dsl.viewModel
import ua.edu.chnu.kkn.organise.data.about.AboutRepository
import ua.edu.chnu.kkn.organise.data.about.Platform
import ua.edu.chnu.kkn.organise.data.reminders.RemindersRepository
import ua.edu.chnu.kkn.organise.ui.about.AboutViewModel
import ua.edu.chnu.kkn.organise.ui.reminders.ReminderViewModel

val appModule = module {
    single<Platform>()
    single<AboutRepository>()
    viewModel<AboutViewModel>()
    single<RemindersRepository>()
    viewModel<ReminderViewModel>()
}