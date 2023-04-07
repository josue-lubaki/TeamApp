package ca.josue_lubaki.teamapp.data.db.local

import androidx.annotation.StringRes
import ca.josue_lubaki.teamapp.R
import ca.josue_lubaki.teamapp.data.models.User

enum class Profession(@StringRes val value: Int) {
    DEVELOPER_ANDROID(R.string.developer_android),
    DEVELOPER_IOS(R.string.developer_ios),
    DEVELOPER_WEB(R.string.developer_web),
    DEVELOPER_BACKEND(R.string.developer_backend),
    DEVELOPER_REACT_NATIVE(R.string.developer_react_native),
    DEVELOPER_FLUTTER(R.string.developer_flutter),
    DEVELOPER_KOTLIN(R.string.developer_kotlin),
    DIRECTOR_PRACTICE(R.string.director_practice),
}

val mockData = listOf(
    User(
        id = 1,
        fullName = "Josue Lubaki",
        imageURL = "https://ca.slack-edge.com/TRR87H161-U03ET6VHNSC-7c824e72f1ce-512",
        profession = Profession.DEVELOPER_ANDROID,
    ),
    User(
        id = 2,
        fullName = "Raphael Beaubois",
        imageURL = "https://ca.slack-edge.com/TRR87H161-U02EE7DSHLZ-e39e3f9e1a44-512",
        profession = Profession.DEVELOPER_REACT_NATIVE,
    ),
    User(
        id = 3,
        fullName = "Samir Hn",
        imageURL = "https://ca.slack-edge.com/TRR87H161-U02939W17RS-fdfc00e8d36a-512",
        profession = Profession.DEVELOPER_REACT_NATIVE,
    ),
    User(
        id = 4,
        fullName = "Juan David Sepulveda",
        imageURL = "https://ca.slack-edge.com/TRR87H161-U018N2WK856-63a3abe7978b-512",
        profession = Profession.DEVELOPER_FLUTTER,
    ),
    User(
        id = 5,
        fullName = "Kilyan Sockalingum",
        imageURL = "https://ca.slack-edge.com/TRR87H161-U026470535M-da15fe7033ea-512",
        profession = Profession.DEVELOPER_REACT_NATIVE,
    ),
    User(
        id = 6,
        fullName = "Louis-Jean ALBERT",
        imageURL = "https://ca.slack-edge.com/TRR87H161-U02EPCZ87SL-0b462848d9e5-512",
        profession = Profession.DEVELOPER_ANDROID,
    ),
    User(
        id = 7,
        fullName = "Dicksen Veloopillay",
        imageURL = "https://ca.slack-edge.com/TRR87H161-U04H745N91D-g067480a6be3-512",
        profession = Profession.DEVELOPER_FLUTTER,
    ),
    User(
        id = 8,
        fullName = "Amélie",
        imageURL = "https://ca.slack-edge.com/TRR87H161-U02L59V5ZN3-067741a7b2a4-512",
        profession = Profession.DEVELOPER_IOS,
    ),
    User(
        id = 9,
        fullName = "Constantin Buruiana",
        imageURL = "https://ca.slack-edge.com/TRR87H161-U02CPL0HRUP-3388eb8c8d47-512",
        profession = Profession.DEVELOPER_REACT_NATIVE,
    ),
    User(
        id = 10,
        fullName = "Shabnam Kimiai",
        imageURL = "https://ca.slack-edge.com/TRR87H161-U02FQMAK4KY-c19d927e6b48-512",
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
