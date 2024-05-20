plugins {
    id("app")
}

dependencies {

    implementation(project(":sdk:good:enums"))
//    implementation(project(":sdk:bad:enums"))

    implementation(project(":sdk:good:sealed"))
//    implementation(project(":sdk:bad:sealed"))

    implementation(project(":sdk:good:suspends"))
//    implementation(project(":sdk:bad:suspends"))

    implementation(project(":sdk:good:flows"))
//    implementation(project(":sdk:bad:flows"))

    implementation(project(":sdk:good:defaultArgs"))
//    implementation(project(":sdk:bad:defaultArgs"))

    implementation(project(":sdk:good:generics"))
//    implementation(project(":sdk:bad:generics"))
}
