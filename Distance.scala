object Distance extends App {
    val kilometersPerHours = 11.0
    val minutes = 100.0
    val distance = kilometersPerHours * minutes / 60.0
    println(s"走った距離は${distance}kmです")
}

// val
// 定数

// var
// 変数（良くない）

// printIn(s"走った距離は${distance}kmです")
// 文字リテラルの前にsを記述すると、${変数}を文字列の中で使用することができる