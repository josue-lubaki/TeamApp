package ca.josue_lubaki.teamapp.data.db.local

import androidx.annotation.StringRes
import ca.josue_lubaki.teamapp.R
import ca.josue_lubaki.teamapp.data.models.User

enum class Profession(
    @StringRes val value: Int,
    val bannerUrl : String
) {
    DEVELOPER_ANDROID(
        value = R.string.developer_android,
        bannerUrl = "https://camo.githubusercontent.com/5346f5a9b63e9e93ff8265ebb05eeda7fc03e48dfe766ba177c788e5c65c6c86/68747470733a2f2f312e62702e626c6f6773706f742e636f6d2f2d37413457796e774c734d772f58624270435847386648492f41414141414141414d74342f754f613162704c736b5967727747626c6c6853753253446a5f4d69673853584a51434c63424741735948512f73313630302f323030305f36303070782e676966"
    ),
    DEVELOPER_IOS(
        value = R.string.developer_ios,
        bannerUrl = "https://images.unsplash.com/photo-1502096472573-eaac515392c6?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2069&q=80"
    ),
    DEVELOPER_WEB(
        value = R.string.developer_web,
        bannerUrl = "https://images.unsplash.com/photo-1633356122544-f134324a6cee?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80"
    ),
    DEVELOPER_BACKEND(
        value = R.string.developer_backend,
        bannerUrl = "https://images.unsplash.com/photo-1593720216276-0caa6452e004?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2156&q=80"
    ),
    DEVELOPER_REACT_NATIVE(
        value = R.string.developer_react_native,
        bannerUrl = "https://blog.talent500.co/wp-content/uploads/2022/04/ReactToolKit_Banner03-1200x500.png"
    ),
    DEVELOPER_FLUTTER(
        value = R.string.developer_flutter,
        bannerUrl = "https://pasinfotech.com/wp-content/uploads/2019/06/flutter-banner.jpg"
    ),
    DEVELOPER_KOTLIN(
        value = R.string.developer_kotlin,
        bannerUrl = "https://monstertut.com/wp-content/uploads/2017/05/kotlin-tutorial-course-beginner-udemy.jpg"
    ),
    DIRECTOR_PRACTICE(
        value = R.string.director_practice,
        bannerUrl = "https://images.unsplash.com/photo-1519389950473-47ba0277781c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80"
    ),
}

val mockData = listOf(
    User(
        id = 1,
        fullName = "Raphael Beaubois",
        imageURL = "https://ca.slack-edge.com/TRR87H161-U02EE7DSHLZ-e39e3f9e1a44-512",
        profession = Profession.DEVELOPER_REACT_NATIVE,
    ),
    User(
        id = 2,
        fullName = "Amélie",
        imageURL = "https://ca.slack-edge.com/TRR87H161-U02L59V5ZN3-067741a7b2a4-512",
        profession = Profession.DEVELOPER_IOS,
    ),
    User(
        id = 3,
        fullName = "Juan David Sepulveda",
        imageURL = "https://ca.slack-edge.com/TRR87H161-U018N2WK856-63a3abe7978b-512",
        profession = Profession.DEVELOPER_FLUTTER,
    ),
    User(
        id = 4,
        fullName = "Josue Lubaki",
        imageURL = "https://ca.slack-edge.com/TRR87H161-U03ET6VHNSC-7c824e72f1ce-512",
        profession = Profession.DEVELOPER_ANDROID,
    ),
    User(
        id = 5,
        fullName = "Kilyan Sockalingum",
        imageURL = "https://ca.slack-edge.com/TRR87H161-U026470535M-da15fe7033ea-512",
        profession = Profession.DEVELOPER_REACT_NATIVE,
    ),
    User(
        id = 6,
        fullName = "Shabnam Kimiai",
        imageURL = "https://ca.slack-edge.com/TRR87H161-U02FQMAK4KY-c19d927e6b48-512",
        profession = Profession.DEVELOPER_REACT_NATIVE,
    ),
    User(
        id = 7,
        fullName = "Samir Hn",
        imageURL = "https://ca.slack-edge.com/TRR87H161-U02939W17RS-fdfc00e8d36a-512",
        profession = Profession.DEVELOPER_REACT_NATIVE,
    ),
    User(
        id = 8,
        fullName = "Louis-Jean ALBERT",
        imageURL = "https://ca.slack-edge.com/TRR87H161-U02EPCZ87SL-0b462848d9e5-512",
        profession = Profession.DEVELOPER_ANDROID,
    ),
    User(
        id = 9,
        fullName = "Dicksen Veloopillay",
        imageURL = "https://ca.slack-edge.com/TRR87H161-U04H745N91D-g067480a6be3-512",
        profession = Profession.DEVELOPER_FLUTTER,
    ),
    User(
        id = 10,
        fullName = "Constantin Buruiana",
        imageURL = "https://ca.slack-edge.com/TRR87H161-U02CPL0HRUP-3388eb8c8d47-512",
        profession = Profession.DEVELOPER_REACT_NATIVE,
    ),
    User(
        id = 11,
        fullName = "Sylvain Aïnama",
        imageURL = "https://ca.slack-edge.com/TRR87H161-U03M2Q1V6AC-4904d2f5609f-512",
        profession = Profession.DEVELOPER_FLUTTER,
    ),
    User(
        id = 12,
        fullName = "Zacharie",
        imageURL = "https://ca.slack-edge.com/TRR87H161-U046E22BNVD-bc98ce2b5d12-512",
        profession = Profession.DEVELOPER_REACT_NATIVE,
    ),
    User(
        id = 13,
        fullName = "Julien Hamon",
        imageURL = "https://ca.slack-edge.com/TRR87H161-U01DRTNDWJH-676bfa9c4bc5-512",
        profession = Profession.DIRECTOR_PRACTICE,
    ),
)
