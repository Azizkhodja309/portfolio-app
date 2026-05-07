package com.azizkhodja.portfolio.data

data class Project(
    val name: String,
    val description: String,
    val technologies: String,
    val link: String
)

object ProjectRepository {
    fun getProjects(): List<Project> = listOf(
        Project(
            name = "Portfolio Web",
            description = "Portfolio React ilovasi: Bu yerda kompniyada ishlash davomida men qilgan loyihalar to'plami mavjud.",
            technologies = "React · Vite · Telegram Bot",
            link = "https://easyit.uz/"
        ),
        Project(
            name = "EasyRelay App",
            description = "America Driverlari uchun Amazon boshqaruv paneli",
            technologies = "Kotlin · Retrofit · MVVM",
            link = "https://play.google.com/store/apps/details?id=com.easyrelay.app"
        ),
        Project(
            name = "Intech uskuna",
            description = "Mahsulotlar katalogi bo'lgan e-commerce ilovasi.",
            technologies = "NestJS · React · PostgrsDB",
            link = "https://intech-uskuna.uz/"
        ),
        Project(
            name = "EasyRelay Amazon exctention",
            description = "Logistik kompaniya uchun amazondan yuk olish va haftalik grosslarni qilish uchun komak beruvchi exctention.",
            technologies = "NestJS · NextJS · React",
            link = "https://chromewebstore.google.com/detail/easyrelay-%E2%80%93-boost-dispatc/obmcimindeajfoacnmfbiifcoomomhag?hl=en-US&utm_source=ext_sidebar"
        ),
    )
}
